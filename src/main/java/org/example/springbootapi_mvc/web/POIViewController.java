package org.example.springbootapi_mvc.web;

import jakarta.servlet.http.HttpSession;
import org.example.springbootapi_mvc.models.POI;
import org.example.springbootapi_mvc.repositories.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar las vistas relacionadas con los puntos de interés (POI).
 */
@Controller
@RequestMapping("/web/poi")
public class POIViewController {
    @Autowired
    private POIRepository poiRepository;

    /**
     * Muestra la lista de puntos de interés.
     *
     * @param session la sesión HTTP actual
     * @param model el modelo para la vista
     * @return la vista de la lista de puntos de interés
     */
    @GetMapping("/lista")
    public String listarPOIs(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/poi/lista");
            return "redirect:/web/login";
        }

        model.addAttribute("pois", poiRepository.findAll());
        return "poi/lista";
    }

    /**
     * Muestra los detalles de un punto de interés específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del punto de interés
     * @param model el modelo para la vista
     * @return la vista de los detalles del punto de interés
     */
    @GetMapping("/{id}")
    public String detallePOI(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/poi/" + id);
            return "redirect:/web/login";
        }

        POI poi = poiRepository.findById(id).get();
        model.addAttribute("poi", poi);
        return "poi/detalle";
    }

    /**
     * Muestra el formulario para editar un punto de interés específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del punto de interés
     * @param model el modelo para la vista
     * @return la vista del formulario de edición del punto de interés
     */
    @GetMapping("/{id}/editar")
    public String editarPOI(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/poi/" + id + "/editar");
            return "redirect:/web/login";
        }

        POI poi = poiRepository.findById(id).get();
        model.addAttribute("poi", poi);
        return "poi/editar";
    }

    /**
     * Guarda los cambios realizados a un punto de interés específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del punto de interés
     * @param poi el punto de interés con los cambios realizados
     * @return redirige a la vista de detalles del punto de interés
     */
    @PostMapping("/{id}/editar")
    public String guardarPOI(HttpSession session, @PathVariable String id, @ModelAttribute POI poi) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/poi/" + id + "/editar");
            return "redirect:/web/login";
        }

        POI poiActual = poiRepository.findById(id).get();
        poiActual.setNombre(poi.getNombre());
        poiActual.setCiudad(poi.getCiudad());
        poiActual.setTipo(poi.getTipo());
        poiActual.setHorario_apertura(poi.getHorario_apertura());
        poiActual.setPrecio(poi.getPrecio());

        poiRepository.save(poiActual);
        return "redirect:/web/poi/" + id;
    }

    /**
     * Elimina un punto de interés específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del punto de interés
     * @return redirige a la vista de la lista de puntos de interés
     */
    @PostMapping("/{id}/eliminar")
    public String eliminarPOI(HttpSession session, @PathVariable String id) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/poi/" + id + "/eliminar");
            return "redirect:/web/login";
        }

        if (!poiRepository.existsById(id)) {
            return "redirect:/web/poi/lista";
        }

        poiRepository.deleteById(id);
        return "redirect:/web/poi/lista";
    }

    /**
     * Muestra el formulario para crear un nuevo punto de interés.
     *
     * @param session la sesión HTTP actual
     * @param model el modelo para la vista
     * @return la vista del formulario de creación de un nuevo punto de interés
     */
    @GetMapping("/nuevo")
    public String nuevoPOI(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/poi/nuevo");
            return "redirect:/web/login";
        }

        POI poi = new POI();
        model.addAttribute("poi", poi);
        return "poi/nuevo";
    }

    /**
     * Guarda un nuevo punto de interés.
     *
     * @param session la sesión HTTP actual
     * @param poi el nuevo punto de interés a guardar
     * @return redirige a la vista de la lista de puntos de interés
     */
    @PostMapping("/nuevo")
    public String guardarNuevoPOI(HttpSession session, @ModelAttribute POI poi) {
        poiRepository.save(poi);
        return "redirect:/web/poi/lista";
    }
}
