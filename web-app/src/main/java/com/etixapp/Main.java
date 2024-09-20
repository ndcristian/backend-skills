package com.etixapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.etixapp.service.FilesStorageService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Main implements CommandLineRunner {
  @Resource
  FilesStorageService storageService;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... arg) {
    storageService.init();
  }
}