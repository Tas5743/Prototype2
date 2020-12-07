package com.group7.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class PrototypeApplication {
    public static void main(String[] args) {
        System.getProperties().put( "server.port", 8081);
        SpringApplication.run(PrototypeApplication.class, args);
    }

}
