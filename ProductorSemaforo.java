package tankes2;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;
import static java.lang.Thread.sleep;
public class ProductorSemaforo extends Thread{
    private Y rcS;
    private DibujaTanke panelS; 
    private Lock mutex;
    private Semaphore sem;
    public ProductorSemaforo(DibujaTanke panelS, Y rcS){
        this.panelS=panelS;
        this.rcS=rcS;
        mutex = new ReentrantLock();
        sem = new Semaphore(1);
        
    }
    public void run(){
        while(true){
            if(rcS.getY()>50){
                ///*
                //Semaforo Inicio
                try 
                {
                    sem.acquire();
                        //Inicio Seccion Critica
                        panelS.aguaS.getAgua().add(new Rectangle2D.Double(200,rcS.getY(), 100, 5));
                        rcS.setY(rcS.getY()-5);
                        System.out.println("Productor Semaforo, Y: "+rcS.getY());
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
                        panelS.aguaS.getAgua().add(new Rectangle2D.Double(200,rcS.getY(), 100, 5));
                        rcS.setY(rcS.getY()-5);
                        System.out.println("Productor Semaforo, Y: "+rcS.getY());
                    mutex.unlock();
                }
                //fin prueba
                */
                panelS.repaint();
                try{
                    //sleep(500+(int)Math.random()*200);
                    //sleep(1000);
                    sleep(650);
                }catch(Exception e){}
            }else if(rcS.getY()<=50){
                System.out.println("Esperando Producir, Semaforo");
                try{
                    sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }
        }
    }
}
