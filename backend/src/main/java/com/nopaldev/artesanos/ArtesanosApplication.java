package com.nopaldev.artesanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application.properties"),
        // TODO: find a way to proxy this by configuration
        //  for example: application-${spring.profiles.activate}.properties
        @PropertySource("classpath:application-local.properties")
})
public class ArtesanosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtesanosApplication.class, args);
    }

}
