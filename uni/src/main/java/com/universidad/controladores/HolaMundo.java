package com.universidad.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HolaMundo {

    @GetMapping("/")
    public ResponseEntity<String> hola(){
        return new ResponseEntity<>( "hola mundo", HttpStatus.ACCEPTED);
    }
}
