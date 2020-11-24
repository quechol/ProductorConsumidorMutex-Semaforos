package tankes2;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.Thread.sleep;
public class ConsumidorMutex extends Thread{
    private Y rcM;
    private DibujaTanke panelM;
    private Lock mutex;
    public ConsumidorMutex(DibujaTanke panelM, Y rcM){
        this.panelM=panelM;
        this.rcM=rcM;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if (rcM.getY()<250){
                if(mutex.tryLock()){
                    mutex.lock();
                        panelM.aguaM.getAgua().remove(panelM.aguaM.getAgua().size()-1);
                        rcM.setY(rcM.getY()+5);
                        System.out.println("Consumidor MUTEX, Y: "+rcM.getY());
                    mutex.unlock();
                }
                panelM.repaint();
                try{    
                    sleep(1000);
                }catch(InterruptedException e){}
            }
        }
    }
}
