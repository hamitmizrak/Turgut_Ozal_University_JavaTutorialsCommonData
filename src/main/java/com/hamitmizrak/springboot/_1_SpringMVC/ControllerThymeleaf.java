package com.hamitmizrak.springboot._1_SpringMVC;

import com.hamitmizrak.springboot.dto.RegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Spring MVC
@Controller
@RequestMapping("/mvc/v1")
public class ControllerThymeleaf {

    // http://localhost:4444/mvc/v1/thmeleaf0
    @GetMapping("/thymeleaf0")
    @ResponseBody
    public String thymeleaf0(){
        return "Merhabalar Thmeleaf 0";
    }

    // http://localhost:4444/mvc/v1/thymeleaf1
    @GetMapping("/thymeleaf1")
    public String thymeleaf1(){
        return "thymeleaf_frontend1";
    }

    // http://localhost:4444/mvc/v1/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String thymeleaf2(Model model){
        model.addAttribute("key2","Merhabalar Ben Javadan geldim");
        return "thymeleaf_frontend2";
    }

    // http://localhost:4444/mvc/v1/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String thymeleaf3(Model model){
        RegisterDto registerDto= RegisterDto.builder()
                .id(1L)
                .name("Hamit")
                .surname("Mızrak")
                .email("hamitmizrak@gmail.com")
                .password("Hm123456@.")
                .build();
        model.addAttribute("key3",registerDto);
        return "thymeleaf_frontend3";
    }


    // http://localhost:4444/mvc/v1/thymeleaf3
    @GetMapping("/thymeleaf4")
    public String thymeleaf4(Model model){
        List<RegisterDto> listem=new ArrayList<>();

        for (int i = 1; i <=10 ; i++) {
            RegisterDto registerDto= RegisterDto.builder()
                    .id(Long.valueOf(i))
                    .name("Hamit "+i)
                    .surname("Mızrak "+i)
                    .email("hamitmizrak@gmail.com "+i)
                    .password("Hm123456@. "+i).
                    date(new Date(System.currentTimeMillis()))
                    .build();
            listem.add(registerDto);
        }

        model.addAttribute("key4",listem);
        return "thymeleaf_frontend4";
    }
}
