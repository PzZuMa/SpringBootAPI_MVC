package org.example.springbootapi_mvc.web;

import jakarta.servlet.http.HttpSession;
import org.example.springbootapi_mvc.models.Hotel;
import org.example.springbootapi_mvc.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 * Controlador para la gestión de vistas relacionadas con hoteles.
 */
@Controller
@RequestMapping("/web/hotel")
public class HotelViewController {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Muestra la lista de hoteles.
     *
     * @param session la sesión HTTP actual
     * @param model el modelo para la vista
     * @return la vista de la lista de hoteles
     */
    @GetMapping("/lista")
    public String listarHoteles(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/hotel/lista");
            return "redirect:/web/login";
        }

        model.addAttribute("hoteles", hotelRepository.findAll());
        return "hotel/lista";
    }

    /**
     * Muestra el detalle de un hotel específico.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del hotel
     * @param model el modelo para la vista
     * @return la vista del detalle del hotel
     */
    @GetMapping("/{id}")
    public String detalleHotel(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/hotel/" + id);
            return "redirect:/web/login";
        }

        Hotel hotel = hotelRepository.findById(id).get();
        model.addAttribute("hotel", hotel);
        return "hotel/detalle";
    }

    /**
     * Muestra el formulario para editar un hotel.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del hotel
     * @param model el modelo para la vista
     * @return la vista del formulario de edición del hotel
     */
    @GetMapping("/{id}/editar")
    public String editarHotel(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/hotel/" + id + "/editar");
            return "redirect:/web/login";
        }

        Hotel hotel = hotelRepository.findById(id).get();
        model.addAttribute("hotel", hotel);
        return "hotel/editar";
    }

    /**
     * Guarda los cambios realizados a un hotel.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del hotel
     * @param hotel el objeto hotel con los cambios
     * @return la redirección a la vista del detalle del hotel
     */
    @PostMapping("/{id}/editar")
    public String guardarHotel(HttpSession session, @PathVariable String id, @ModelAttribute Hotel hotel) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/hotel/" + id + "/editar");
            return "redirect:/web/login";
        }

        Hotel hotelActual = hotelRepository.findById(id).get();
        hotelActual.setNombre(hotel.getNombre());
        hotelActual.setDireccion(hotel.getDireccion());
        hotelActual.setTelefono(hotel.getTelefono());
        hotelActual.setEstrellas(hotel.getEstrellas());
        hotelActual.setPrecio(hotel.getPrecio());
        hotelActual.setCiudad(hotel.getCiudad());
        hotelActual.setEmail(hotel.getEmail());

        hotelRepository.save(hotelActual);
        return "redirect:/web/hotel/" + id;
    }

    /**
     * Elimina un hotel.
     *
     * @param session la sesión HTTP actual
     * @param id el ID del hotel
     * @return la redirección a la vista de la lista de hoteles
     */
    @PostMapping("/{id}/eliminar")
    public String eliminarHotel(HttpSession session, @PathVariable String id) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/hotel/" + id + "/eliminar");
            return "redirect:/web/login";
        }

        if (!hotelRepository.existsById(id)) {
            return "redirect:/web/hotel/lista";
        }

        hotelRepository.deleteById(id);
        return "redirect:/web/hotel/lista";
    }

    /**
     * Muestra el formulario para crear un nuevo hotel.
     *
     * @param session la sesión HTTP actual
     * @param model el modelo para la vista
     * @return la vista del formulario de creación de un nuevo hotel
     */
    @GetMapping("/nuevo")
    public String nuevoHotel(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            session.setAttribute("source", "/web/hotel/nuevo");
            return "redirect:/web/login";
        }

        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        return "hotel/nuevo";
    }

    /**
     * Guarda un nuevo hotel.
     *
     * @param session la sesión HTTP actual
     * @param hotel el objeto hotel a guardar
     * @return la redirección a la vista de la lista de hoteles
     */
    @PostMapping("/nuevo")
    public String guardarNuevoHotel(HttpSession session, @ModelAttribute Hotel hotel) {
        hotelRepository.save(hotel);
        return "redirect:/web/hotel/lista";
    }
}
