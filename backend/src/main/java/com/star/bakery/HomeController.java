package com.star.bakery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Star Cake Bakery 🎂";
    }

    @GetMapping("/cakes")
    public String cakes() {
        return "Chocolate, Vanilla, Red Velvet, Black Forest";
    }
}
