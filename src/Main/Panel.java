
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
        System.out.println("oi");
    }

    @Override
    public void run() {
        double drawInterval =30000000;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        
        while(gameThread != null){

            currentTime = System.nanoTime();

            delta +=(currentTime - lastTime)/ drawInterval;
            timer +=(currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
                repaint();
                delta--;
                drawCount++;
            }
           
            if(timer >= 100000000){
                drawCount = 0;
                timer = 0;
                largura = (float) (largura- 0.1);
                if(largura < 0){
                    largura = 1;
                }
            }
        }
    }
    
   
    
}
