package com.zain.jo.linkedin.network_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class NetworkAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetworkAppApplication.class, args);
    }

}
