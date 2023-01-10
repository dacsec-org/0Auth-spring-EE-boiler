package org.dacsec.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String index() {
        byte[] decodedBytes = Base64.getDecoder().decode("VGltZTJDb2Rl");
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
