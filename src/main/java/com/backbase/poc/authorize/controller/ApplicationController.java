package com.backbase.poc.authorize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backbase.poc.authorize.service.DummyService;

@Controller
public class ApplicationController {

    @Autowired
    private DummyService dummyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails =
                    (UserDetails) authentication.getPrincipal();
            map.addAttribute("userDetails", userDetails);
        }
        return "index";
    }

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public String secure() {
            dummyService.securedService();
        return "check";
    }
}
