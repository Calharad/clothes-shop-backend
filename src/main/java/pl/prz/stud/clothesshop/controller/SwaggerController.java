package pl.prz.stud.clothesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
    @GetMapping("/api/swagger")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
