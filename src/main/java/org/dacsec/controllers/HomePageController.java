package org.dacsec.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dacsec
 * <p>
 * {@link HomePageController} is the controller for the home page.
 */
@RestController
@RequestMapping("/")
public class HomePageController {
    
        /**
        * @return the home page.
        */
        @RequestMapping
        public String index() {
            return "index";
        }
    
}
