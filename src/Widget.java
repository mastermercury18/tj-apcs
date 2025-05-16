// Name:
// Date: 

public class Widget implements Comparable<Widget>
{
   //fields
   int cubits;
   int hands;
   //constructors
   
   public Widget(){
      cubits = 0;
      hands = 0;
   }
   public Widget(int c, int h){
      cubits = c;
      hands = h;
   }
   public Widget(Widget w){
      cubits = w.getCubits();
      hands = w.getHands();
   }
   
   //accessors and modifiers
   public int getCubits(){
      return cubits;
   }
   public int getHands(){
      return hands;
   }
   public void setCubits(int c){
      cubits = c;
   }
   
   public void setHands(int h){
      hands = h;
   }
   
   //compareTo and equals
   public int compareTo(Widget w){
      if (w.getCubits() > cubits)
         return 1;
      else if (w.getCubits() == cubits){
         if (w.getHands() > hands)
            return 1;
         else if (w.getHands() < hands)
            return -1;
         else
            return 0;
      }
      else{
         return -1;
      }
   }
   
   public boolean equals(Widget w, Widget v){
      if (w.compareTo(v) == 0)
         return true;
      return false;
   }

   //toString
   
   public String toString(){
      return cubits + " cubits " + hands + " hands ";
   }
   
}
