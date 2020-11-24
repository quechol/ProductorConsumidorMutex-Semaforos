package tankes2;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.Thread.sleep;

public class ProductorMutex extends Thread{
    private Y rcM;
    private DibujaTanke panelM; 
    private Lock mutex;
    public ProductorMutex(DibujaTanke panelM, Y rcM){
        this.panelM=panelM;
        this.rcM=rcM;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if(rcM.getY()>50){
                if(mutex.tryLock()){
                    mutex.lock();
                        panelM.aguaM.getAgua().add(new Rectangle2D.Double(50,rcM.getY(), 100, 5));
                        rcM.setY(rcM.getY()-5);
                        System.out.println("Productor MUTEX, Y: "+rcM.getY());
                    mutex.unlock();
                }
                panelM.repaint();
                try{
                    sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }else if(rcM.getY()<=50){
                System.out.println("Esperando Producir, MUTEX");
                try{
                    sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }
        }
    }
}
