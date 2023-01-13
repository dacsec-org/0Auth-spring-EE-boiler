package org.dacsec.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dacsec
 * <p>
 * {@link HomePageController} is the controller for the home page.
 */
@RestController
public class HomePageController {
    
        /**
        * @return the home page.
        */
        @GetMapping("/")
        public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
            if (principal != null) {
                model.addAttribute("profile", principal.getClaims());
            }
            return "index";
        }
    
}
