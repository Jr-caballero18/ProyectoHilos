/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author juras
 */
public class EjemploExecutorService  {
    public static void main(String[] args) {
     
     ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("Tarea del main");
        
        executor.schedule(()->{
        System.out.println("Inicio tarea");
        try{
            System.out.println("");
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            System.out.println(e);
            e.printStackTrace();
        }
        
        
        }, 2, TimeUnit.SECONDS);
        
        System.out.println("Hasta aqui llegue jeje ");
        executor.shutdown();
        System.out.println("holaaa sigo vivoo");
    }
}
