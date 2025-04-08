/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TimerTimerTask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author juras
 */
public class EjemploTimerTask {
    public static void main(String[] args) {
    
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            int contador = 0;
        @Override
        public void run(){
            if(contador <= 3){
            
            System.out.println("Tarea realizada" + new Date() + "nombre del thread" + Thread.currentThread().getName());
            System.out.println("Finalizado");
            contador ++;
            } else {
          timer.cancel();
            }
            
        }
        }, 5000,20000);
        System.out.println("Tareas iniciadas:");
        
    }
}
