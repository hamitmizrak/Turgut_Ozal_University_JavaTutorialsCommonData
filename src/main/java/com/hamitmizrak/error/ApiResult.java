package com.hamitmizrak.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.sql.Date;
import java.util.Map;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

// jackson: objeyi json çevirir.
// validationError: null ise dönemsini istemeyebiliriz.
// Eğer Sistemde Null bir değer varsa bu null değeri frontentte göndermemek için
@JsonInclude(JsonInclude.Include.NON_NULL)
// Backentten Frontend' bilgi göndermek istersek biz bu Class yardımızyla hata mesjalarımızı gönderebilieceğiz.
public class ApiResult {
    //Field
    private int status;
    private String path;
    private String message;
    private String error;
    //tarih
    private Date createdDate=new Date(System.currentTimeMillis());
    //private String createdDate=nowDate();

    //validationError
    private Map<String,String> validationErrors;

   //Parametreli constructor
    public ApiResult(int status, String path, String message, String error) {
        this.status = status;
        this.path = path;
        this.message = message;
        this.error = error;
    }

    //Parametreli constructor
    public ApiResult(int status, String path, String message) {
        this.status = status;
        this.path = path;
        this.message = message;
    }

    //Tarih Formatter
    //Now Date
    /*private  String nowDate() {
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.MMMM.yyyy HH:mm:ss",locale);
        Date date=new Date();
        String change=simpleDateFormat.format(date);
        System.out.println(change);
        return change;
    }*/
}
