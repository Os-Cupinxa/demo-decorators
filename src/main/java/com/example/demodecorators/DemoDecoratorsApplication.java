package com.example.demodecorators;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoDecoratorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDecoratorsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(MyService myService) {
        return args -> {
            MyServiceInterface serviceProxy = MyServiceProxy.createProxy(myService);
            serviceProxy.performTask();
            serviceProxy.performTaskNoDecorator();
        };
    }
}
