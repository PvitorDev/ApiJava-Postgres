package com.carros.demo.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class indexController {

    @GetMapping()
    public String get(){
       return "Get spring";
    }
}
