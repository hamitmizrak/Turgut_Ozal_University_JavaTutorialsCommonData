package com.hamitmizrak.controller.api;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.controller.IRegisterApi;
import com.hamitmizrak.error.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

//LOMBOK
@RequiredArgsConstructor //injection
@Log4j2

//API: Dış Dünyaya açılan kapıdır.
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000") //CORS: eğer reactta package.json'da proxy yazarsam @CrossOrigin yazmasamda olur
public class RegisterApiImpl implements IRegisterApi {
    //INJECTION
    private final IRegisterService iUserRegisterService;
    //Constructor Injection

    // +++++++++ CRUD  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // CREATE
    // http://localhost:4444/api/v1/register
    @Override
    @PostMapping("/register")
    public ResponseEntity<RegisterDto>  createRegister(@Valid @RequestBody RegisterDto userRegisterDto) {
        iUserRegisterService.createRegister(userRegisterDto);
        return ResponseEntity.ok(userRegisterDto);
    }

    // LIST
    // http://localhost:4444/api/v1/list
    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<RegisterDto>>  getAllRegisters() {
        return ResponseEntity.ok(iUserRegisterService.getAllRegisters());
    }

    // FIND
    // http://localhost:4444/api/v1/register
    // http://localhost:4444/api/v1/register/0
    // http://localhost:4444/api/v1/register/-1
    // http://localhost:4444/api/v1/register/1
    @Override
    @GetMapping({"/register","/register/{id}"})
    public ResponseEntity<?>  getFindByRegister( @PathVariable(name="id",required = false) Long id) {
        if(id==null){
            log.error("404 not found => Bulunamadı");
            return  ResponseEntity.notFound().build();
        }else if(id==0){
            log.error("400 bad request => Kötü istek");
            return  ResponseEntity.badRequest().build();
        }else if(id<0){
            log.error("401 bad request => Kötü istek");
            ApiResult apiResult= ApiResult.builder()
                    .error("401")
                    .message("unAuthorized")
                    .path("http://localhost:4444/register/-1")
                    .build();
            return  ResponseEntity.status(401).body(apiResult);
        }

        //LOG
        log.info(id+ "verisi bulundu:  "+iUserRegisterService.getFindByRegisterId(id));
        return ResponseEntity.ok(iUserRegisterService.getFindByRegisterId(id));
    }


    // DELETE
    // http://localhost:4444/api/v1/register
    // http://localhost:4444/api/v1/register/0
    // http://localhost:4444/api/v1/register/1
    @Override
    @DeleteMapping({"/register","/register/{id}"})
    public ResponseEntity<Map<String,Boolean>>  deleteRegister(@PathVariable(name="id",required = false) Long id) {
        if(id==null){
            log.error("404 not found => Bulunamadı");
            return  ResponseEntity.notFound().build();
        }else if(id==0){
            log.error("400 bad request => Kötü istek");
            return  ResponseEntity.badRequest().build();
        }
        log.info(id+ "verisi bulundu: "+iUserRegisterService.getFindByRegisterId(id));
        return  ResponseEntity.ok(iUserRegisterService.deleteRegister(id));
    }

    // UPDATE
    // http://localhost:4444/api/v1/register
    // http://localhost:4444/api/v1/register/0
    // http://localhost:4444/api/v1/register/1
    @Override
    @PutMapping({"/register","/register/{id}"})
    public ResponseEntity<RegisterDto>  updateRegister(@PathVariable(name="id",required = false) Long id, @Valid @RequestBody RegisterDto userRegisterDto) {
        if(id==null){
            log.error("404 not found => Bulunamadı");
            return  ResponseEntity.notFound().build();
        }else if(id==0){
            log.error("400 bad request => Kötü istek");
            return  ResponseEntity.badRequest().build();
        }
        log.info(id+ "verisi bulundu: "+iUserRegisterService.getFindByRegisterId(id));
        return  ResponseEntity.ok(iUserRegisterService.updateRegister(id,userRegisterDto));
    }
}
