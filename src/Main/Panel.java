
package Main;

import Shapes.Shape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Panel extends JPanel implements Runnable{
    
    Shape s;
    Thread gameThread;
    final int fps = 60;
    float largura = 1;

    public Panel(){
        this.setBounds(300, 300, 300, 300);
        this.setVisible(true);
        this.s = new Shape();
        startGameThread();
    }
    
    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        s.rotate((Graphics2D) g);
//        g.dispose();
    }

    @Override
    public void run() {
        
        long rep = 0;
        long drawPRep = 2000000;

        
        while(this.gameThread.isAlive()){
            
            rep++;
            
            if(rep == drawPRep){
                repaint();
                rep = 0;
            }
        }
        
    }
}
