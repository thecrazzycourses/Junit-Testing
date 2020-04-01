package com.crazzy.junit.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {

    @GetMapping("/home")
    public String getHome() {
        return "App is up";
    }
}
