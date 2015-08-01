// Sergey Melnik
// SID: 1231219


 // what the fuck does this do?

public class GenericBinaryHeap<K extends Comparable<K>, E> {
   private int size;
   private K[] keyArray;
   private E[] elementArray;
   
   
   public GenericBinaryHeap() {
      size = 0;
      keyArray = (K[]) new Comparable[10];
      elementArray = (E[]) new Comparable[10];
   }

   // Return true if the priority queue has no elements
   // @return true if the queue has no elements
   public boolean isEmpty() {
      return (size == 0);
   }


    // Returns the number of elements in this priority queue.
    // @return the number of elements in this priority queue.
   public int size() {
      return size;
   }

   // Returns the minimum element in the priority queue
   // @return the minimum element
   // @throws EmptyPQException if priority queue contains no elements
   public E findMin() {
      if (size == 0)
         throw new IllegalStateException();
      return (E)elementArray[1];
   }
   
   private <K> K giveKey(int i) {
      return (K)keyArray[i];
   }

   // Inserts a new element into the priority queue. Duplicate values ARE allowed.
   // @param x element to be inserted into the priority queue.
   public void insert(K insKey, E insElement) {
      if (size + 1 > keyArray.length - 1)  // expand if needed
         expand();
      size++;
      int i = size;
      
      K keyTemp;
      E elementTemp;
      
      keyArray[i] = insKey;
      elementArray[i] = insElement;
      
      
      while ((i != 1) &&    ((keyArray[i/2]).compareTo((K)keyArray[i]) > 0)) {  // the thing isn't yet at the top and top is less important priority
         keyTemp = keyArray[i/2];
         keyArray[i/2] = keyArray[i];
         keyArray[i] = keyTemp;
         elementTemp = elementArray[i/2];
         elementArray[i/2] = elementArray[i];
         elementArray[i] = elementTemp;
         i = i/2;
      }
   }




   // Removes and returns the minimum element from the priority queue.
   // @return the minimum element
   // @throws IllegalStateException if priority queue contains no elements
   public K deleteMin(){
      if (isEmpty())
         throw new IllegalStateException(); 
      K nextToGo = keyArray[1];
      keyArray[1] = keyArray[size];
      size--;
      percolateDown();
      
      return nextToGo;
   }

    
   // Resets the priority queue to appear as not containing any elements.  
   public void makeEmpty() {
      size = 0;
   }
   
   private void percolateDown() {  // for removing node
      int i = 1;
      int left = 2;
      int right = 3;
      K keyTemp;
      E elementTemp;
      
      // while not a leaf, AND while at least one of the below are better priority
      while ((left <= size) && ((keyArray[left].compareTo(keyArray[i]) < 0) || 
            ((keyArray[right].compareTo(keyArray[i]) < 0) && (right <= size)  ))) {  // 
         // cases
         // only one node to left, decide to flip or not
         // 
         keyTemp = keyArray[i];
         elementTemp = elementArray[i];
         
         if ((left == size) || (keyArray[left].compareTo(keyArray[right]) <= 0)){ // only one node to left, it must be better priority 
            
            keyArray[i] = keyArray[left];
            elementArray[i] = elementArray[left];
            keyArray[left] = keyTemp;
            elementArray[left] = elementTemp;
            i = left;
         } else {                      // only right must be better priority, lets switch it
            keyArray[i] = keyArray[right];
            elementArray[i] = elementArray[i];
            keyArray[right] = keyTemp;
            elementArray[right] = elementTemp;
            i = right;
         }
         left = i * 2;     // readjust pointers
         right = left + 1;
      }

   }
   
   
   private void expand() {
      K[] newkeyArray = (K[])new Comparable[keyArray.length * 2];
      E[] newelementArray = (E[])new Comparable[newkeyArray.length];
      for (int i = 1; i <= size; i++) {
         newkeyArray[i] = keyArray[i];
         newelementArray[i] = elementArray[i];
      }
      keyArray = newkeyArray;
      elementArray = newelementArray;
   }
}