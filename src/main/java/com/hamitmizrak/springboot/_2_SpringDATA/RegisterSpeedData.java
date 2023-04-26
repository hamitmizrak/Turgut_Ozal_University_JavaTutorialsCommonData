package com.hamitmizrak.springboot._2_SpringDATA;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
// LOMBOK
// @RequiredArgsConstructor


@RequiredArgsConstructor
@Configuration
public class RegisterSpeedData {

    // 1.YOL

/* @Autowired
   private IRegisterRepository repository;*//*


    //2.YOL
    */
/*private IRegisterRepository repository;
    @Autowired
    public RegisterSpeedData(IRegisterRepository repository) {
        this.repository = repository;
    }*/


    //3.YOL
    private final ILoginRepository repository;

    @Bean
    CommandLineRunner createRegister() {
        return (args) -> {
            for (int i = 1; i <= 5; i++) {
                LoginEntity register = LoginEntity
                        .builder()
                        .surname("soyadı " + i)
                        .name("adı " + i)
                        .email("hamitmizrak" + i + "@gmail.com")
                        .password(UUID.randomUUID().toString())
                        .build();
                repository.save(register);
            }
        }; // end return
    } //end CommandLineRunner
} // end RegisterSpeedData

