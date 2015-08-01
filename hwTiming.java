// Sergey Melnik
// SID: 1231219
import java.util.*;

public class hwTiming {
   public static void main(String[] args) {
      
      
      // minimum testing is  n = 5
      // calls on variant constructor method as to not include array expansion in any timing;
      testMe(10);
      testMe(100);
      testMe(500);
      testMe(1000);
      testMe(10000);
      
   
      
   }
   
   
   // 
   public static void testMe(int n) {
      if (n < 4)
         throw new IllegalArgumentException();
      
      System.out.println("************************************************");
      System.out.println("TESTING N = " + n);
      System.out.println("************************************************");
      Random rand = new Random();
      
      PriorityQueue a = new BinaryHeap(n);
      PriorityQueue b = new ThreeHeap(n);
      PriorityQueue c = new MyPQ(n);
      
      runAndPrint(rand, a, n - 5);
      runAndPrint(rand, b, n - 5);
      runAndPrint(rand, c, n - 5);
   }
   
   
   
   // runs and prints results for one priorityque
   // accepts a random object, the priorityqueue to be tested, and a number of initial insertions to make
   public static void runAndPrint(Random rand, PriorityQueue xxx, int numb) {
      for (int i = 0; i < numb; i++) {
         xxx.insert(rand.nextDouble() * 100.0 + 1.0);
      }
      long startTime;
      long endTime;
      long elapsedTime;
      for (int i = 0; i < 4; i++) {    // four insert's are timed and run "just in case"
         startTime = System.nanoTime();
         xxx.insert(rand.nextDouble() * 100.0 + 1.0);
         endTime = System.nanoTime();
         elapsedTime = endTime - startTime;
         System.out.println("insert: " + elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds");
      }
      for (int i = 0; i < 4; i++) {    // four deleteMin's are timed and run "just in case"
         startTime = System.nanoTime();
         xxx.deleteMin();
         endTime = System.nanoTime();
         elapsedTime = endTime - startTime;
         System.out.println("deleteMin: " + elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds");
      }
      System.out.println("---------------------");
   }
}