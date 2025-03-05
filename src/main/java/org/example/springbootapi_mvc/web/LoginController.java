package org.example.springbootapi_mvc.web;

import jakarta.servlet.http.HttpSession;
import org.example.springbootapi_mvc.SecurityService;
import org.example.springbootapi_mvc.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/login")
public class LoginController {
    @Autowired
    SecurityService securityService;

    @GetMapping
    public String login(Model model) {
        return "web/login";
    }

    @PostMapping
    public String processLogin(HttpSession session, Model model, @ModelAttribute Usuario login) {
        var result = securityService.login(login.getNombre(), login.getEmail());
        if(result.isPresent()){
            session.setAttribute("user", result.get());
            if (session.getAttribute("source") != null) {
                var source = session.getAttribute("source");
                session.removeAttribute("source");
                return "redirect:" + source;
            }
            return "redirect:/web/home";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "web/login";
        }
    }

    @GetMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/web/login";
    }

}
