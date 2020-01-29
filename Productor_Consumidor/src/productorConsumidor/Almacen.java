/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorConsumidor;


/**
 *
 * @author Joaquin Pereira Chapel
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

    public synchronized void producir(String productor) throws InterruptedException {
        System.out.println(productor + " intentando almacenar un producto");
        
        while(isFull()){
            wait();
        }
        
        producto++;
        System.out.println(productor + " almacena un producto. "
                + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));

        notifyAll();
        
        Thread.sleep(500);
    }

    public synchronized void consumir(String consumidor) throws InterruptedException {
        System.out.println(consumidor + " intentando retirar un producto");
        
        while(isEmpty()){
            wait();
        }
        
        producto--;
        System.out.println(consumidor + " retira un producto. "
                + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));

        notifyAll();
        Thread.sleep(500);
    }

}
