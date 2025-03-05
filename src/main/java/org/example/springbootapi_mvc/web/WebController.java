package org.example.springbootapi_mvc.web;

import jakarta.servlet.http.HttpSession;
import org.example.springbootapi_mvc.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para manejar las rutas web principales.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    /**
     * Maneja la ruta raíz y redirige según el estado de autenticación del usuario.
     *
     * @param session la sesión HTTP actual
     * @return redirección a la página de inicio si está autenticado, de lo contrario a la página de login
     */
    @GetMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:home";
        }
        return "redirect:login";
    }

    /**
     * Maneja la ruta /home y muestra el dashboard si el usuario está autenticado.
     *
     * @param session la sesión HTTP actual
     * @param model el modelo para pasar datos a la vista
     * @return la vista del dashboard si está autenticado, de lo contrario redirige al login
     */
    @GetMapping("/home")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:login";
        }

        Usuario user = (Usuario) session.getAttribute("user");
        model.addAttribute("user", user);
        return "web/home";
    }
}