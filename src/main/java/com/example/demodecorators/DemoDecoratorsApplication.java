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
    public CommandLineRunner run(MyService myService, MyService2 myService2) {
        return args -> {
            MyServiceInterface serviceProxy1 = MyServiceProxy.createProxy(myService);
            MyServiceInterface serviceProxy2 = MyServiceProxy.createProxy(myService2);
            serviceProxy1.performTask();
            serviceProxy1.performTaskNoDecorator();


            serviceProxy2.performTask();
            serviceProxy2.performTaskNoDecorator();
        };
    }
}
