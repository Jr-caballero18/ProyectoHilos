/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juras
 */
public class EjemploExecutorServicePeriod  {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("Tarea del main");
        
        AtomicInteger contador = new AtomicInteger(5);
        
        Future<?> future = executor.scheduleAtFixedRate(()->{
            try {
                System.out.println("Tarea del schedule");
                TimeUnit.SECONDS.sleep(1);
                contador.getAndDecrement();
            } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
            }
        
        }, 1, 2, TimeUnit.SECONDS);
        
        while(contador.get()>= 0){
        if(contador.get() == 0){
        future.cancel(true);
        contador.getAndDecrement();
        executor.shutdown();
        }
        
        }
        System.out.println("Aqui llegue ");
    }
}
