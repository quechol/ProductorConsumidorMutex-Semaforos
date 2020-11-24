package tankes2;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

public class Tankes extends JFrame{
    private DibujaTanke panel;
    
    private Y rcM;
    private Y rcS;
    
    private ProductorMutex pM;
    private ConsumidorMutex cM;
    private ProductorSemaforo pS;
    private ConsumidorSemaforo cS;
    
    private Agua aguaM;
    private Agua aguaS;
    
    private Lock mutex;
    private Semaphore sem;
    
    public Tankes(){
        setSize(400,400);
        setLocation(550,250);
        
        mutex = new ReentrantLock();
        sem = new Semaphore(1);
        
        rcM=new Y();
        rcS=new Y();
        
        aguaM=new Agua();
        aguaS = new Agua();
        
        panel = new DibujaTanke(aguaM,aguaS);
        
        pM = new ProductorMutex(panel,rcM);
        cM = new ConsumidorMutex(panel,rcM);
        
        pS = new ProductorSemaforo(panel,rcS);
        cS = new ConsumidorSemaforo(panel,rcS);
        
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(panel);
        
        pM.start();
        cM.start();
        pS.start();
        cS.start();
    }
    public static void main(String[] args) {
        Tankes fr = new Tankes();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
