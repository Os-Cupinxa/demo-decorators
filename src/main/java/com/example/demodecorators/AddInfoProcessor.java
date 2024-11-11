package com.example.demodecorators;

import java.lang.reflect.Method;

public class AddInfoProcessor {

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
