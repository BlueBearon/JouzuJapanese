package com.chasepacker;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

   @Override
   public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               .allowedOrigins("http://localhost:3000", "https://jouzujapanese.netlify.app", "https://jouzujapanesebackend-768f8f815a31.herokuapp.com")
               .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
   }
}