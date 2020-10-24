package com.group7.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeApplication {

    public static void main(String[] args) {
        System.getProperties().put( "server.port", 8081);
        SpringApplication.run(PrototypeApplication.class, args);
    }

}
