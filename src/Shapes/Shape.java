
package Shapes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Shape{
    
    float percentual = (float) 1.0;
    public BufferedImage img;
    int flag = 0;
    
    public Shape(){
  
        try {
            img = ImageIO.read(getClass().getResourceAsStream("sword.png"));
        } catch (IOException ex) {
            System.out.println("nao deu");
        }
    }

    
    public void update(){
        
        if(percentual <= -0.9){
            percentual = (float) -0.95;
            if(flag == 1)
                flag = 0;
            else
                flag = 1;
        }
        else if(percentual >= 1){
            percentual = 1;
            if(flag == 1)
                flag = 0;
            else
                flag = 1;
        }
        
        if(flag == 1)
            percentual = (float) (percentual-0.15);
        else
            percentual = (float) (percentual+0.15);
    }
    
    public void rotate(Graphics2D G2){
        G2.drawImage(this.img, (int) (20+(100-percentual*50)), 20, (int) (percentual*100), 100, null);
        update();
    }

    
    public void draw(Graphics2D G2){
        G2.drawImage(this.img, 20, 20, 100, 100, null);
    }

}
