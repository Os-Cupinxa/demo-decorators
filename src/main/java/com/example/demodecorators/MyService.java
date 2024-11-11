package com.example.demodecorators;

import org.springframework.stereotype.Service;

@Service
public class MyService implements MyServiceInterface {

    @AddInfo
    @Override
    public void performTask() {
        System.out.println("Executando a tarefa...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Tarefa finalizada.");
    }

    @Override
    public void performTaskNoDecorator() {
        System.out.println("Executando a tarefa sem decorator...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Tarefa finalizada sem decorator.");
    }
}
