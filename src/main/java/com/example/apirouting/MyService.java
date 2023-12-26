package com.example.apirouting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyService {
    @GetMapping(" /about")
    public String getMyService() {
        return "About Page";
    }

}
