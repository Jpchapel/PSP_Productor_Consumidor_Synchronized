/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productor_consumidor;


/**
 *
 * @author Stream
 */
public class Almacen {

    private final int MAX_LIMITE = 20;
    private int producto = 0;

    public boolean isFull() {
        return producto == MAX_LIMITE;
    }

    public boolean isEmpty() {
        return producto == 0;
    }

    public synchronized void producir(String nombreProductor) throws InterruptedException {
        System.out.println(nombreProductor + " intentando almacenar un producto");
        
        while(isFull()){
            wait();
        }
        
        producto++;
        System.out.println(nombreProductor + " almacena un producto. "
                + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));

        notifyAll();
        
        Thread.sleep(500);
    }

    public synchronized void consumir(String nombreConsumidor) throws InterruptedException {
        System.out.println(nombreConsumidor + " intentando retirar un producto");
        
        while(isEmpty()){
            wait();
        }
        
        producto--;
        System.out.println(nombreConsumidor + " retira un producto. "
                + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));

        notifyAll();
        Thread.sleep(500);
    }

}
