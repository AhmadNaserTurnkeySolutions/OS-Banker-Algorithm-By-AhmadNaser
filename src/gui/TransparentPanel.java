/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
*
* @author Ahmad-Hammad
*/

public class TransparentPanel extends JPanel{

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }
private int red;
private int green;
private int blue;
private int alpha;

public TransparentPanel(){
this(233,238,238,100);
}
public TransparentPanel(int red,int green,int blue,int alpha){
super();
this.setOpaque(false);
this.setLayout(null);
}
    @Override
public void paintComponent(Graphics g){
super.paintComponent(g);
Color c=new Color(red,green,blue,alpha);
g.setColor(c);
g.fillRect(0,0, this.getWidth(),this.getHeight());

}
}

