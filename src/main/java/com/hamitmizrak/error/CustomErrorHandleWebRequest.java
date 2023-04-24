package com.hamitmizrak.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LOMBOK
@Log4j2
@RequiredArgsConstructor

//SpringBoot defaulltan gelen error'ı kendimize göre customize yapıyoruz.
@RestController
@CrossOrigin
public class CustomErrorHandleWebRequest implements ErrorController {

    //injection
    private final ErrorAttributes errorAttributes;

    //http://localhost:4444/error
    //spring'ten gelen /error yakalayıp custom handle yapmak için
    @RequestMapping("/error")
   public ApiResult handleError(WebRequest webRequest){
        //ApiResult değişkenlerini atamak
        int status;
        String message,path;
        ApiResult error;

        //Spring 2.3>=
        Map<String,Object> attributes=this.errorAttributes.getErrorAttributes(
              webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.BINDING_ERRORS)
        ); //end attributes

        status=(Integer)attributes.get("status");
        message=(String)attributes.get("message");
        path=(String)attributes.get("path");
        error=new ApiResult(status,path,message);

        //attibutesta error varsa
        if(attributes.containsKey("errors")){
          List<FieldError> fieldErrorList =(List)attributes.get("errors");
          Map<String,String> validationMistake=new HashMap<>();
          for(FieldError fieldError:fieldErrorList){
              validationMistake.put(fieldError.getField(),fieldError.getDefaultMessage());
          }
          error.setValidationErrors(validationMistake);
        }
        return error;
    } //end handleError
}
