package com.example.templateissue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.WebSession;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @GetMapping
    public String index(final WebSession webSession,
                        final Model model) {
        return "index";
    }

    @GetMapping("another-page")
    public String another(final WebSession webSession,
                          final Model model) {
        return "another";
    }
}
