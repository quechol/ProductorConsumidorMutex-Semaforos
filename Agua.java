package tankes2;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
public class Agua {
    private ArrayList<Rectangle2D> agua; 
    Agua(){
        agua=new ArrayList<Rectangle2D>();
    }    
    public ArrayList<Rectangle2D> getAgua() {
        return agua;
    }
    public void setAgua(ArrayList<Rectangle2D> agua) {
        this.agua = agua;
    }   
}
