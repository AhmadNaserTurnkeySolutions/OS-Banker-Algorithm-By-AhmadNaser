package bankersproject;

public class Customer implements Runnable {

   // the number of threads
   public static final int COUNT = 5;
        
   // the number of different resources
   private int numOfResources;

   // the maximum this thread will demand 
   private int[] maxDemand;
//RQ 0 0 0 1 0 RQ 1 0 0 3 4 RQ 2 2 3 5 5 RQ 3 0 3 3 2
   //RL 0 0 0 1 0 
   //RL 1 0 0 3 4 
   //RL 2 2 3 5 5 
   //RL 3 0 3 3 2
   // this customer number
   private int customerNum;

   // request it is making
   private int[] request;
        
   // random number generator
   private java.util.Random rand;
     
   // synchronizing object
   private Bank theBank;
        
   public Customer (int customerNum, int[] maxDemand, Bank theBank) {
      this.customerNum = customerNum;
      this.maxDemand = new int[maxDemand.length];
      this.theBank = theBank;
            
      System.arraycopy (maxDemand, 0, this.maxDemand, 0, maxDemand.length);
      numOfResources = maxDemand.length;
      request = new int[numOfResources];
      rand = new java.util.Random();
   }
        
   public void run() {
      boolean canRun = true;
            
      while (canRun) {

         try {
            // rest for awhile
            SleepUtilities.nap();
            
            // make a resource request
            for (int i=0; i < numOfResources; i++) 
                request[i] = rand.nextInt(maxDemand[i]+1);
                        
            // see if the customer can proceed
            if (theBank.requestResources(customerNum, request)) {
               // use the resources
               SleepUtilities.nap();
                
               // release the resources
               theBank.releaseResources(customerNum, request);
            }

         //} catch (InterruptedException ie) {
         } catch (Exception e) {
              canRun = false;
            }
      }

      System.err.println("Customer # " + customerNum + " I'm interrupted.");
   }
}