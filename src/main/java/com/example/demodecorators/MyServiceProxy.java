package com.example.demodecorators;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyServiceProxy {

    public static MyServiceInterface createProxy(MyServiceInterface originalService) {
        return (MyServiceInterface) Proxy.newProxyInstance(
                originalService.getClass().getClassLoader(),
                originalService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Method realMethod = originalService.getClass().getMethod(method.getName(), method.getParameterTypes());

                        if (realMethod.isAnnotationPresent(AddInfo.class)) {
                            System.out.println("Iniciando o método: " + method.getName());
                            long startTime = System.currentTimeMillis();

                            Object result = method.invoke(originalService, args);

                            long endTime = System.currentTimeMillis();
                            System.out.println("Finalizando o método: " + method.getName());
                            System.out.println("Tempo de execução: " + (endTime - startTime) + "ms");

                            return result;
                        } else {
                            return method.invoke(originalService, args);
                        }
                    }
                });
    }
}
