package com.hamitmizrak.springboot.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
//@SneakyThrows
public class RegisterDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date date=new Date(System.currentTimeMillis());

    public static void main(String[] args) {
        RegisterDto registerDto=new RegisterDto();
        System.out.println(registerDto.date);
    }
}
