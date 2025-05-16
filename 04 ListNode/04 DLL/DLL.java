// Name:
// Date:

//  DoubleLinkedList, circular, with a dummy head node
//  implements some of the List and LinkedList interfaces: 
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o); 
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

class DLL  
{
   private int size;
   private DLNode head; //points to a dummy node--very useful--don't mess with it
   public DLL()  
   {
   
     //make it circular
     head = new DLNode();
     head.setNext(head);
     head.setPrev(head);
        
   } 
   
   /* two accessor methods  */
   public int size()
   {
      return size;
   }
   public DLNode getHead()
   {
      return head;
   }
   
   /* appends obj to end of list; increases size;
   	  @return true  */
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;   
   }
   
   /* inserts obj at position index (the list is zero-indexed).  
      increments size. 
      no need for a special case when size == 0.
	   */
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      DLNode pointer = head;
      if( index > size || index < 0 )
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      if (index == 0){
         addFirst(obj);
         return;
      }
      index ++;
      /* enter your code below  */
      for (int i=0; i<index-1; i++){
         pointer = pointer.getNext();
      }
      DLNode temp = new DLNode(obj, pointer, pointer.getNext());
      pointer.getNext().setPrev(temp);
      pointer.setNext(temp);
      size ++;
                    
   }
   
    /* return obj at position index (zero-indexed). 
    */
   public Object get(int index) throws IndexOutOfBoundsException
   { 
      DLNode pointer = head;
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      index ++;
      for (int i=0; i<index; i++){
         pointer = pointer.getNext();
      }
      return pointer.getValue();
   }
   
   /* replaces obj at position index (zero-indexed). 
        returns the obj that was replaced.
        */
   public Object set(int index, Object obj) throws IndexOutOfBoundsException
   {
      DLNode pointer = head;
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      index ++;
      /* enter your code below  */
      /*if (index == 0){
         pointer.setValue(obj);
         return head.getValue();
      } */
      if (index != 0){
         for (int i=0; i<index; i++){
            pointer = pointer.getNext();
         }
      }
      DLNode temp = new DLNode(obj, pointer.getPrev(), pointer.getNext());
      pointer.getPrev().setNext(temp);
      pointer.getNext().setPrev(temp);
      return pointer.getValue();
   }
   
   /*  removes the node from position index (zero-indexed).  decrements size.
       @return the object in the node that was removed. 
        */
   public Object remove(int index) throws IndexOutOfBoundsException
   {
      DLNode pointer = head;
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      index ++;
      for (int i=0; i<index-1; i++){
         pointer = pointer.getNext();
      }
      DLNode removed = pointer.getNext();
      pointer.setNext(removed.getNext());
      removed.getNext().setPrev(pointer);
      size --;
      return removed.getValue();
   }
   
  	/* inserts obj to front of list, increases size.
	    */ 
   public void addFirst(Object obj)
   {
      /*if (size == 0)
         head.setValue(obj);
      else { */
         DLNode newhead = new DLNode(obj, head, head.getNext());
         head.getNext().setPrev(newhead);         
         head.setNext(newhead);
         //head = newhead;
      //}
      size++;
   }
   
   /* appends obj to end of list, increases size.
       */
   public void addLast(Object obj)
   {
      if (size == 0){
         addFirst(obj);
      }
      else {
         DLNode last = head.getPrev();
         DLNode pointer = head;
         DLNode newlast = new DLNode(obj, last, pointer);
         last.setNext(newlast);
         pointer.setPrev(newlast);
         size ++;
      }
   }
   
   /* returns the first element in this list  
      */
   public Object getFirst()
   {
   
      return head.getNext().getValue();
   }
   
   /* returns the last element in this list  
     */
   public Object getLast()
   {
   
      return head.getPrev().getValue();
   }
   
   /* returns and removes the first element in this list, or
      returns null if the list is empty  
      */
   public Object removeFirst()
   {
      DLNode pointer = head;
      DLNode oldPointer = head.getNext();
      pointer.getNext().getNext().setPrev(pointer);      
      pointer.setNext(pointer.getNext().getNext());
      //head = pointer.getNext();
      size --;
      return oldPointer.getValue();
   }
   
   /* returns and removes the last element in this list, or
      returns null if the list is empty  
      */
   public Object removeLast()
   {
   
      DLNode pointer = head;
      if (pointer == null)
         return null;
      DLNode last = pointer.getPrev();
      pointer.setPrev(last.getPrev());
      last.getPrev().setNext(pointer);
      size --;
      return last.getValue();

   }
   
   /*  returns a String with the values in the list in a 
       friendly format, for example   [Apple, Banana, Cucumber]
       The values are enclosed in [], separated by one comma and one space.
    */
   public String toString()
   {
      String temp = "";
      DLNode p = head;
      if (size == 0)
         return "";
      p = p.getNext();
      DLNode save = p;
      //System.out.print(p.getValue() + " ");
      temp += "[" + p.getValue();
      while (p.getNext().getNext() != save){
         p = p.getNext();
         temp += ", " + p.getValue();
      }
      temp += "]";
      return temp;
   }
}