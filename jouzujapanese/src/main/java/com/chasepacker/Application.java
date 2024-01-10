package com.chasepacker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.chasepacker"})
public class Application {

   public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
   }
   
   @Bean
   CommandLineRunner initXMLParser() {
        return args -> {
            XMLParser.scan();
        };
   }

}