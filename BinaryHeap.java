// Sergey Melnik
// SID: 1231219

// this class implements a Binary min Heap using an array to store the "tree"
public class BinaryHeap implements PriorityQueue {
   private int size;
   private double[] arrayThing;
   
   // class constructor. Creates an empty Binary Heap with default size 10
   public BinaryHeap() {
      this(10);
   }
   
   // class constructor, Creates an empty Binary Heap and array
   // parameter: size of array to be created
   public BinaryHeap(int n) {
      size = 0;
      arrayThing = new double[n];
   }
   
   // returns true if the priority queue is empty (has no elements)
   public boolean isEmpty() {
      return (size == 0);
   }


   // returns the number of elements in this Binary Heap
   public int size() {
      return size;
   }
   
   // returns the minimum (next-in-line-priority) element in the Binary Heap
   // throws EmptyPQException if priority queue contains no elements
   public double findMin() {
      if (size == 0)
         throw new EmptyPQException();
      return arrayThing[1];
   }

   // Inserts a new element into the Binary Heap (allowing duplicate values)
   // Parameter: element to be inserted
   public void insert(double x) {
      if (size + 1 > arrayThing.length - 1)  // expand if needed
         expand();
      size++;
      int i = size;
      double temp;
      arrayThing[i] = x;
      while ((i != 1) && (arrayThing[i/2] > arrayThing[i])) {  // the thing isn't yet at the top and top is less important priority
         temp = arrayThing[i/2];
         arrayThing[i/2] = arrayThing[i];
         arrayThing[i] = temp;
         i = i/2;
      }
   }
   
   // Removes and returns the minimum element from the priority queue.
   // throws EmptyPQException if Binary Heap is empty
   public double deleteMin(){
      if (isEmpty())
         throw new EmptyPQException(); 
      double nextToGo = arrayThing[1];
      arrayThing[1] = arrayThing[size];
      size--;
      percolateDown();
      return nextToGo;
   }

   // "empties" the Binary Heap, so it looks as if it contains no elements  
   public void makeEmpty() {
      size = 0;
   }
   
   // "percolates down", rearanging the top element into it's proper place
   private void percolateDown() {
      int i = 1;
      int left = 2;
      int right = 3;
      double temp;
      while ((left <= size) && ((arrayThing[left] < arrayThing[i]) || 
               ((arrayThing[right] < arrayThing[i]) && (right <= size)))) { 
         temp = arrayThing[i];
         if ((left == size) || (arrayThing[left] <= arrayThing[right])) {
            arrayThing[i] = arrayThing[left];
            arrayThing[left] = temp;
            i = left;
         } else {
            arrayThing[i] = arrayThing[right];
            arrayThing[right] = temp;
            i = right;
         }
         left = i * 2;
         right = left + 1;
      }
   }
   
   // "expands" the current array to be twice its original size
   private void expand() {
      double[] newArrayThing = new double[arrayThing.length * 2];
      for (int i = 1; i <= size; i++)
         newArrayThing[i] = arrayThing[i];
      arrayThing = newArrayThing;
   }
}