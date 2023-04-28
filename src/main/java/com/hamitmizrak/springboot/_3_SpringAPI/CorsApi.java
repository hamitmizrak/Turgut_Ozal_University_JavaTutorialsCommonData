package com.hamitmizrak.springboot._3_SpringAPI;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//CORS
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CorsApi {

    // http://localhost:4444/api/v1/cors
    @GetMapping("/cors")
    public String message(){
        return "Merhabalar Ben Java API'dan geldim";
    }
}
