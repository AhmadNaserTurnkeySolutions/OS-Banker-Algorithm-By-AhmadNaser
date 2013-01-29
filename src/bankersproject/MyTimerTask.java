/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankersproject;

import java.util.TimerTask;
import javax.swing.JFrame;

/**
 *
 * @author IBM
 */
public class MyTimerTask extends TimerTask {
  public  JFrame f;
  
  public MyTimerTask(JFrame f)
  {
  this.f=f;
  }

    @Override
    public void run() {
 
       f.repaint();
    }
    
}
