
package Main;

import java.awt.Toolkit;
import javax.swing.JFrame;


public class Frame extends JFrame{
    
    public Frame(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setUndecorated(false);
        this.setTitle("Spinning Square");
        this.setBounds(0, 0, 1000,1000);
        //this.pack();
        this.setVisible(true);
    }
}
