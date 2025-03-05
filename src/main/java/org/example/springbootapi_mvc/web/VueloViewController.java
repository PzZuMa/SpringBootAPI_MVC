package org.example.springbootapi_mvc.web;

import jakarta.servlet.http.HttpSession;
import org.example.springbootapi_mvc.models.Vuelo;
import org.example.springbootapi_mvc.repositories.VuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar las vistas relacionadas con los vuelos.
 */
@Controller
@RequestMapping("/web/vuelo")
public class VueloViewController {

    @Autowired
    private VuelosRepository vueloRepository;

    /**
     * Muestra la lista de vuelos.
     *
     * @param session la sesión HTTP actual
     * @param model el modelo para la vista
     * @return la vista de la lista de vuelos
     */
    @GetMapping("/lista")
    public String listarVuelos(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/vuelo/lista");
            return "redirect:/web/login";
        }

        model.addAttribute("vuelos", vueloRepository.findAll());
        return "vuelo/lista";
    }

    /**
     * Muestra los detalles de un vuelo específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del vuelo
     * @param model el modelo para la vista
     * @return la vista de los detalles del vuelo
     */
    @GetMapping("/{id}")
    public String detalleVuelo(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/vuelo/" + id);
            return "redirect:/web/login";
        }

        Vuelo vuelo = vueloRepository.findById(id).get();
        model.addAttribute("vuelo", vuelo);
        return "vuelo/detalle";
    }

    /**
     * Muestra el formulario para editar un vuelo específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del vuelo
     * @param model el modelo para la vista
     * @return la vista del formulario de edición del vuelo
     */
    @GetMapping("/{id}/editar")
    public String editarVuelo(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/vuelo/" + id + "/editar");
            return "redirect:/web/login";
        }

        Vuelo vuelo = vueloRepository.findById(id).get();
        model.addAttribute("vuelo", vuelo);
        return "vuelo/editar";
    }

    /**
     * Guarda los cambios realizados a un vuelo específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del vuelo
     * @param vuelo el vuelo con los cambios realizados
     * @return redirige a la vista de detalles del vuelo
     */
    @PostMapping("/{id}/editar")
    public String guardarVuelo(HttpSession session, @PathVariable String id, @ModelAttribute Vuelo vuelo) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/vuelo/" + id + "/editar");
            return "redirect:/web/login";
        }

        Vuelo vueloActual = vueloRepository.findById(id).get();
        vueloActual.setCodigo(vuelo.getCodigo());
        vueloActual.setAerolinea(vuelo.getAerolinea());
        vueloActual.setOrigen(vuelo.getOrigen());
        vueloActual.setDestino(vuelo.getDestino());
        vueloActual.setFecha_salida(vuelo.getFecha_salida());
        vueloActual.setHora_salida(vuelo.getHora_salida());
        vueloActual.setDuracion(vuelo.getDuracion());

        vueloRepository.save(vueloActual);
        return "redirect:/web/vuelo/" + id;
    }

    /**
     * Elimina un vuelo específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del vuelo
     * @return redirige a la vista de la lista de vuelos
     */
    @PostMapping("/{id}/eliminar")
    public String eliminarVuelo(HttpSession session, @PathVariable String id) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/vuelo/" + id + "/eliminar");
            return "redirect:/web/login";
        }

        if (!vueloRepository.existsById(id)) {
            return "redirect:/web/vuelo/lista";
        }

        vueloRepository.deleteById(id);
        return "redirect:/web/vuelo/lista";
    }

    /**
     * Muestra el formulario para crear un nuevo vuelo.
     *
     * @param session la sesión HTTP actual
     * @param model el modelo para la vista
     * @return la vista del formulario de creación de un nuevo vuelo
     */
    @GetMapping("/nuevo")
    public String nuevoVuelo(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/vuelo/nuevo");
            return "redirect:/web/login";
        }

        Vuelo vuelo = new Vuelo();
        model.addAttribute("vuelo", vuelo);
        return "vuelo/nuevo";
    }

    /**
     * Guarda un nuevo vuelo.
     *
     * @param session la sesión HTTP actual
     * @param vuelo el nuevo vuelo a guardar
     * @return redirige a la vista de la lista de vuelos
     */
    @PostMapping("/nuevo")
    public String guardarNuevoVuelo(HttpSession session, @ModelAttribute Vuelo vuelo) {
        vueloRepository.save(vuelo);
        return "redirect:/web/vuelo/lista";
    }
}
