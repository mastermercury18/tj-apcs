// Name:
// Date:
import java.io.*;      //imports File 
import java.util.*;    //imports Scanner 

public class Searches_Driver
{
   private static int amount = 1325;
   
   public static void main(String[] args) throws Exception
   {
      String[] apple = input("declaration.txt");
      Arrays.sort(apple);  
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("Enter a word: ");
         String target = sc.next();   //Liberty  
         if(target.equals("-1") )
            break;
         Searches.reset();
         int found = Searches.linear(apple, target);
         if(found == -1)
            System.out.println(target + " was not found by the linear search.");
         else
            System.out.println("Linear Search found it at location "+found+" in " + Searches.getLinearCount()+" comparisons.");
         int found2 = Searches.binary(apple, target);
         if(found2 == -1)
            System.out.println(target + " was not found by the binary search.");
         else
            System.out.println("Binary Search found it at location "+found2+" in " + Searches.getBinaryCount()+" comparisons.");
      }
   }
   
   public static String[] input(String filename) throws Exception
   {
      Scanner infile = new Scanner( new File(filename) );
      String[] array = new String[amount];
      for (int k =0; k<amount; k++)    
         array[k] = infile.next();
      infile.close();
      return array;
   }
}

/////////////////////////////////////////////////////////
class Searches
{
   private static int linearCount = 0;
   private static int binaryCount = 0;      
   
   public static int getLinearCount()
   {
      return linearCount;
   }
   
   public static int getBinaryCount()
   {
      return binaryCount;
   }
   
   public static void reset()
   {
      linearCount = 0;
      binaryCount = 0;
   }
   
   @SuppressWarnings("unchecked")//removes the warning for Comparable
   public static int linear(Comparable[] array, Comparable target)
   { 
      for (int i=0; i<array.length; i++){
         linearCount ++;
         if (array[i].equals(target))
            return i;
      }
      return -1;
   }
   
   @SuppressWarnings("unchecked")
   public static int binary(Comparable[] array, Comparable target)
   {
      return binaryhelper(array, target, 0, array.length);
   }
   
   @SuppressWarnings("unchecked")
   private static int binaryhelper(Comparable[] array, Comparable target, int start, int end)
   {
      binaryCount ++;
      int middle = (end+start)/2;
      if (array[middle].equals(target))
         return middle;
      if ( start > end)
         return -1;
      else{
        // System.out.println("bc " + binaryCount + " start " + start + " mid " + middle + " end " + end);
         if (array[middle].compareTo(target) > 0){
            return binaryhelper(array, target, start, middle-1);
         }
         else{
            return binaryhelper(array, target, middle+1, end);
         }
      }
   }
}