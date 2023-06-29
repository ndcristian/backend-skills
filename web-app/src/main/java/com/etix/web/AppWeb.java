package com.etix.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
/** Disabling the Auto-Configuration*/
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AppWeb  {
    public static void main(String[] args) {
        SpringApplication.run(AppWeb.class, args);
    }
}
