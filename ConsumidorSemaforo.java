package tankes2;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;
import static java.lang.Thread.sleep;
public class ConsumidorSemaforo extends Thread{
    private Y rcS;
    private DibujaTanke panelS;
    private Lock mutex;
    private Semaphore sem;
    public ConsumidorSemaforo(DibujaTanke panelS, Y rcS){
        this.panelS=panelS;
        this.rcS=rcS;
        mutex = new ReentrantLock();
        sem = new Semaphore(1);
    }
     public void run(){
        while(true){
            if (rcS.getY()<250){
                ///*
                //Semaforo Inicio
                try{
                    sem.acquire();
                        //Iniocio Seccion Critica
                        panelS.aguaS.getAgua().remove(panelS.aguaS.getAgua().size()-1);
                        rcS.setY(rcS.getY()+5);
                        System.out.println("Consumidor Semaforo, Y: "+rcS.getY());
                        //Fin Seccion Critica
                    sem.release();
                } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                }
                //Semaforo Fin
                //*/
                
                /*
                //prueba
                if(mutex.tryLock()){
                    mutex.lock();
                        panelS.aguaS.getAgua().remove(panelS.aguaS.getAgua().size()-1);
                        rcS.setY(rcS.getY()+5);
                        System.out.println("Consumidor Semaforo, Y: "+rcS.getY());
                    mutex.unlock();
                }
                //fin prueba
                */
                
                panelS.repaint();
                try{    
                    sleep(1000);
                }catch(InterruptedException e){}
            }
        }
     }
}
