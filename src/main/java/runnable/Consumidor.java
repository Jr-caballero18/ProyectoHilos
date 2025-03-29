/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package runnable;

import Synchronized.Panaderia;

/**
 *
 * @author juras
 */
public class Consumidor implements Runnable{
    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10; i++){
            panaderia.consumir();
        }
    }
}
