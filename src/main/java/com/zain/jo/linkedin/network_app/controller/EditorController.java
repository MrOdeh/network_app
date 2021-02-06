package com.zain.jo.linkedin.network_app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/editor")
public class EditorController {

    @PreAuthorize("hasAuthority('beer.create')")
    @GetMapping("/time")
    public String getTime(){
        return LocalDateTime.now().toString();
    }
    @PreAuthorize("hasAuthority('brewery.delete')")
    @GetMapping("/random")
    public String getName(){
        return  "" + new Random().nextInt() + " see : " + UUID.randomUUID();
    }
}
