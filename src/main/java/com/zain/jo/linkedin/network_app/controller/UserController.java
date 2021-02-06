package com.zain.jo.linkedin.network_app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @PreAuthorize("hasAuthority('beer.read')")
    @GetMapping("/time")
    public String getTime(){
        return "User has no privildge for seeing time.";
    }

    @PreAuthorize("hasAuthority('customer.create')")
    @GetMapping("/random")
    public String getName(){
        return  "User has no privildge for getting random.";
    }
}
