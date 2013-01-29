/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankersproject;

/**
 * Utilities for causing a thread to sleep.
 * Note, we should be handling interrupted exceptions
 * but choose not to do so for code clarity.
 */

class SleepUtilities {

   private static final int NAP_TIME = 5;

   /**
    * Nap between zero and NAP_TIME seconds.
    */
   static void nap() {
      nap(NAP_TIME);
   }

   /**
    * Nap between zero and duration seconds.
    */
   static void nap(int duration) {
      int sleeptime = (int) (duration * Math.random() );
      try { Thread.sleep(sleeptime*1000); } catch (InterruptedException ie) {}
   }
}