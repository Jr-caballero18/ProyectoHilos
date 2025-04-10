/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juras
 */
public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
      ExecutorService executor = Executors.newSingleThreadExecutor();
      
      Runnable tarea = () ->{
        System.out.println("Inicio de la tarea");
          try {
              System.out.println("Nombre del thread" + Thread.currentThread().getName());
              TimeUnit.SECONDS.sleep(5);
          } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
              System.out.println(e);
          }
    };
      // Se ejecuta la tarea
      executor.submit(tarea);
      //cerrar la entrada de tareas
      executor.shutdown();
      
        System.out.println("Metodo main se esta ejecutando 1");
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Meotodo main se sigue ejecutando 1");
    }
}
