package com.hamitmizrak.persist;

public class DataPersist {
    //URL: https://github.com/hamitmizrak/Turgut_Ozal_University_JavaTutorialsCommonData

    /*
    CREATE
    POST /api/v1/register HTTP/1.1
    Host: localhost:4444
    Content-Type: application/json
    Content-Length: 91

    {
        "uname":"HamitM",
        "email":"hamitmizrak@gmail.com",
        "passwd":"Hm12345@."
    }
   */


    /*
    LIST
    GET /api/v1/list HTTP/1.1
    Host: localhost:4444
    * */

    /*
    FIND
    GET /api/v1/register/10 HTTP/1.1
    Host: localhost:4444
    * */

    /*
    DELETE
    DELETE /api/v1/register/1 HTTP/1.1
    Host: localhost:4444
    */

    /*
    UPDATE
    PUT /api/v1/register/2 HTTP/1.1
    Host: localhost:4444
    Content-Type: application/json
    Content-Length: 97

    {
        "uname":"HamitM22",
        "email":"hamitmizrak22@gmail.com",
        "passwd":"Hm1234522@."
    }
    */
}
