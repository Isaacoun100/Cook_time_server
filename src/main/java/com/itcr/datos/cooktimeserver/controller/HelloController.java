package com.itcr.datos.cooktimeserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String getString(){
        return "Hello WEBO";
    }
}
