package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PController {
    @GetMapping("/")
    public String getInfo(){
        return "Hello gradle";
    }
}
