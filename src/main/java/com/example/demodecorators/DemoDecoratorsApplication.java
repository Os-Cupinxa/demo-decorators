package com.example.demodecorators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

@SpringBootApplication
public class DemoDecoratorsApplication {

    public static void main(String[] args) throws Exception {
        MyService service = new MyService();

        for (Method method : service.getClass().getMethods()) {
            if (method.isAnnotationPresent(AddInfo.class)) {
                System.out.println("Informação adicional: Este método possui um decorador.");
            }

            method.invoke(service);
        }
    }
}
