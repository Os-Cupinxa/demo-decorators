package com.example.demodecorators;

import org.springframework.stereotype.Controller;

@Controller
public class MyService {

    @AddInfo
    public void methodWithInfo() {
        System.out.println("Executando método com @AddInfo...");
    }

    public void methodWithoutInfo() {
        System.out.println("Executando método sem @AddInfo...");
    }
}
