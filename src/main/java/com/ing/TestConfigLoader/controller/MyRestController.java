package com.ing.TestConfigLoader.controller;

import com.ing.TestConfigLoader.model.TypicodePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api")
public class MyRestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value ="/endpoint1")
    public ResponseEntity getDetails() {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity(restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",
                    TypicodePojo[].class), HttpStatus.OK);
        }catch (Exception e){
            System.out.print("Error occurred while connecting external api");
            System.out.print(e.getMessage());
            responseEntity = new ResponseEntity("Error While connecting external api",HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return responseEntity;
    }
}
