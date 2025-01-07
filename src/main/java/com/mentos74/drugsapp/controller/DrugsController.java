package com.mentos74.drugsapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrugsController {


    @GetMapping("/v1/drugs")
    public ResponseEntity<String> getDrugs(){
        String repsonse = "Hello guys";
        return  ResponseEntity.ok(repsonse);
    }



//    @PostMapping()
//    public ResponseEntity<>

}
