// Sergey Melnik
// SID: 1231219
// I will use this to test my PriorityQueue


import java.util.*;

public class MyTester {
   public static void main(String[] args) {
      
      BinaryHeap xxx = new BinaryHeap();
      Random rand = new Random();
      
      
      
      testMyShit(rand, xxx, 1);
      testMyShit(rand, xxx, 3);
      testMyShit(rand, xxx, 9);
      testMyShit(rand, xxx, 10);
   }
   
   public static void testMyShit(Random rand, BinaryHeap xxx, int numb) {

      Set<Double> input = new HashSet<Double>();
      Set<Double> output = new HashSet<Double>();

      double temp;
      for (int i = 0; i < numb; i++) {
         temp = (rand.nextDouble() * 100.0 + 1.0);
         System.out.println(temp);
         xxx.insert(temp);
         input.add(temp);
      }
      
      
      System.out.println(" -------- SIZE OF SHIT:  " + xxx.size() + "----------" );
      while (!xxx.isEmpty()){
         temp = xxx.deleteMin();
         System.out.println(temp);
         output.add(temp);
      }
      System.out.println(input.equals(output));
      System.out.println();
      
      
   }
}