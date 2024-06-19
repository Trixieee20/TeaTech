package com.TeaTech.co.TeaTech.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {


    //http:localhost:8080/Hello-World
    @GetMapping("/Hello-World")
    
    public String helloWorld(){
        return "Hello World";


    }
}
