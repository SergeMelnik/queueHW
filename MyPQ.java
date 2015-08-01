// Sergey Melnik
// SID: 1231219

// this class implements a Priority Queue using a quaternary tree (four children per parent)
public class MyPQ implements PriorityQueue {
   int size;
   double[] arrayThing;

   
   // class constructor. Creates an empty Quaternary Heap with default size 10 array
   public MyPQ() {
      this(10);
   }
   
   // class constructor, Creates an empty Quaternary Heap and array
   // parameter: size of array to be created
   public MyPQ(int n) {
      size = 0;
      arrayThing = new double[n];
   }
   
   // returns true if the Quaternary Heap is empty (has no elements)
   public boolean isEmpty() {
      return (size == 0);
   }

   
   // returns the number of elements in this Quaternary Heap
   public int size() {
      return size;
   }

   // returns the minimum (next-in-line-priority) element in the Quaternary Heap
   // throws EmptyPQException if Quaternary Heap contains no elements
   public double findMin() {
      if (size == 0)
         throw new IllegalStateException();
      return arrayThing[1];
   }

   // Inserts a new element into the Quaternary Heap (allowing duplicate values)
   // Parameter: element to be inserted.
   public void insert(double x) {
      if (size + 1 > arrayThing.length - 1)  // expand if needed
         expand();
      size++;
      int i = size;
      double temp;
      arrayThing[i] = x;
      int daddy = (i + 2) / 4;
      while ((i != 1) && (arrayThing[daddy] > arrayThing[i])) {
         temp = arrayThing[daddy];
         arrayThing[daddy] = arrayThing[i];
         arrayThing[i] = temp;
         i = daddy;
         daddy = (i + 2) / 4;
      }
   }

   // Removes and returns the minimum element from the Quaternary Heap.
   // throws EmptyPQException if Quaternary Heap is empty
   public double deleteMin(){
      if (isEmpty())
         throw new IllegalStateException(); 
      double nextToGo = arrayThing[1];
      arrayThing[1] = arrayThing[size];
      size--;
      percolateDown();
      return nextToGo;
   }

   // "empties" the Quaternary Heap, so it looks as if it contains no elements  
   public void makeEmpty() {
      size = 0;
   }
   
   // "percolates down", rearanging the top element into it's proper place
   private void percolateDown() {
      int i = 1;
      double temp;
      int bestKid = checkKids(i);
      while (bestKid != i) {
         temp = arrayThing[i];
         arrayThing[i] = arrayThing[bestKid];
         arrayThing[bestKid] = temp;
         bestKid = checkKids(i);
      }
   }
   
   // this method returns i (location of node) if none of child nodes are better priority
   // otherwize, it returns the location of best priority child
   private int checkKids(int i) {
      int bestKid = i;
      int k = i*4 - 3;
      for (int kid = 1; ((kid <= 4) && (k + kid <= size)); kid++) {
         if (arrayThing[k + kid] < arrayThing[bestKid]){
            bestKid = k + kid;
         }
      }
      return bestKid;
   }
   
   // "expands" the current array to be twice its original size
   private void expand() {
      double[] newArrayThing = new double[arrayThing.length * 2];
      for (int i = 1; i <= size; i++)
         newArrayThing[i] = arrayThing[i];
      arrayThing = newArrayThing;
   }
}