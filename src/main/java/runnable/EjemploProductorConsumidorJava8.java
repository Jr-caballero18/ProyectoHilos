/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package runnable;

/**
 *
 * @author juras
 */
import Synchronized.Panaderia;
import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                p.hornear("Pan nº: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread( () -> {
            for(int i = 0 ; i < 10; i++){
                p.consumir();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
