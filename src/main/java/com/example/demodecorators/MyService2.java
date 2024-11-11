package com.example.demodecorators;

import org.springframework.stereotype.Service;

@Service
public class MyService2 implements MyServiceInterface {

    @AddInfo
    @Override
    public void performTask() {
        System.out.println("Executando a tarefa 2...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Tarefa finalizada 2.");
    }

    @Override
    public void performTaskNoDecorator() {
        System.out.println("Executando a tarefa sem decorator 2...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Tarefa finalizada sem decorator 2.");
    }
}
