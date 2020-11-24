package tankes2;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
public class DibujaTanke extends JPanel{
    public Agua aguaM; 
    public Agua aguaS; 
    public DibujaTanke(Agua aguaM, Agua aguaS){
        this.aguaM = aguaM;
        this.aguaS = aguaS;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Graphics2D g3 = (Graphics2D)g;
        
        g2.setColor(Color.BLACK);
        g2.draw(new Rectangle2D.Double(50,50,100,200));
        g2.setColor(Color.BLUE);
        for(int i=0;i<aguaM.getAgua().size();i++){
            g2.fill((Rectangle2D)aguaM.getAgua().get(i));
        }
        
        g3.setColor(Color.BLACK);
        g3.draw(new Rectangle2D.Double(200,50,100,200));
        g3.setColor(Color.BLUE);
        for(int j=0;j<aguaS.getAgua().size();j++){
            g3.fill((Rectangle2D)aguaS.getAgua().get(j));
        }
        
        JLabel MutexL  = new JLabel("MUTEX");
        add(MutexL);
        MutexL.setBounds(0,0,0,0);
        JLabel EspL  = new JLabel("                            ");
        add(EspL);
        EspL.setBounds(0,0,0,0);
        JLabel SemL  = new JLabel("SEMAFORO");
        add(SemL);
        SemL.setBounds(0,0,0,0);
    }
}
