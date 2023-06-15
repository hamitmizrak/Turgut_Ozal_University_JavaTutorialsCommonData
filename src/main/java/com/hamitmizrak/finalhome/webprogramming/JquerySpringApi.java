package com.hamitmizrak.finalhome.webprogramming;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//LOMBOK
@RequiredArgsConstructor //injection
@Log4j2

//API: Dış Dünyaya açılan kapıdır.
@RestController
@RequestMapping("/api/v1/jquery")
@CrossOrigin //(origins = "http://localhost:3000")
public class JquerySpringApi  {
    //INJECTION
    private final IJqueryService iJqueryService;
    //Constructor Injection

    // +++++++++ CRUD  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // CREATE
    // http://localhost:4444/api/v1/jquery/post
    //@RequestMapping(  value ="/post",method = RequestMethod.POST ,produces = {"application/json"}, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    //  /* @PostMapping(
    //            path = "/{email}/authenticate",
    //            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    //            produces = {
    //                    MediaType.APPLICATION_ATOM_XML_VALUE,
    //                    MediaType.APPLICATION_JSON_VALUE
    //            })*/
    //@RequestMapping(value = "/post", method = RequestMethod.POST,produces = "application/json") // Ajax için
    @PostMapping(value = "/post",consumes={"application/json"})
    public ResponseEntity<JqueryDto>  createRegister(@Valid @RequestBody(required = true) JqueryDto jqueryDto) { //@RequestBody(required = false)
        System.out.println(jqueryDto);
        iJqueryService.createRegister(jqueryDto);
        return ResponseEntity.ok(jqueryDto);
    }

    // LIST
    // http://localhost:4444/api/v1/jquery/get
    @GetMapping(value = "/get")
    public ResponseEntity<List<JqueryDto>>  getAllRegisters() {
        return ResponseEntity.ok(iJqueryService.getAllRegisters());
    }
}
