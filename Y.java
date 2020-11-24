package tankes2;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;
public class Y {
    private int  y;
    Y(){
        y=250;
    }
    public synchronized int getY() {
        return y;
    }
    public synchronized void setY(int y) {
        this.y = y;
    }
}
