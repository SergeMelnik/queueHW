// Sergey Melnik
// SID: 1231219
// I will use this to test my PriorityQueue


// .isEmpty
// .findMin
// .insert
// .deleteMin
// .makeEmpty
// .size

import java.util.*;

public class MyTester22 {
   public static void main(String[] args) {
      
      
      Random rand = new Random();
      
      
      for (int nodes = 2; nodes < 30; nodes++) {
         dHeap xxx = new dHeap(nodes);
         for (int cc = 2; cc < 1000; cc = cc + 5)
            testMyStuff(rand, xxx, cc);
      }
   }
   
   public static void testMyStuff(Random rand, dHeap xxx, int numb) {

      Set<Double> input = new HashSet<Double>();
      Set<Double> output = new HashSet<Double>();

      double temp;
      for (int i = 0; i < numb; i++) {
         temp = (rand.nextDouble() * 100.0 + 1.0);
         //System.out.println(temp);
         xxx.insert(temp);
         input.add(temp);
      }
      
      // xxx.printall();
      
      // System.out.println(" -------- SIZE OF SHIT:  " + xxx.size() + "----------" );
      while (!xxx.isEmpty()){
         temp = xxx.deleteMin();
         //System.out.println(temp);
         output.add(temp);
      }
      
      if (input.equals(output)){
         System.out.print("t");
      } else {
         System.out.println("HOLYSHIT IT DOESNT WORK!!!!");
      }
      //System.out.println();
      
      // xxx.printall();
   }
}