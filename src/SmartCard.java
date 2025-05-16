//name:    date:

import java.text.DecimalFormat;
import java.util.*;
public class SmartCard 
{
   public final static DecimalFormat df = new DecimalFormat("$0.00");
   public final static double MIN_FARE = 0.5;
   /* enter the private fields */
   private double balance;
   private Station my_station;
   private boolean is_boarded;
   private int numbers;

   /* the one-arg constructor  */
   public SmartCard(double b){
      balance = b;
      numbers = 0;
      my_station = null;
      is_boarded = false;
   }

   /* write the instance methods  */

   public double getBalance(){
      return balance;
   }

   public String getFormattedBalance(){
      return df.format(balance);
   }

   public boolean getIsBoarded(){
      return is_boarded;
   }

   public Station getBoardedAt(){
      return my_station;
   }

   public void board(Station s){
      if (is_boarded == true){
         System.out.println("Error: already boarded?!");
         return;
      }
      else if(balance < 0.5){
         System.out.println("Insufficient funds to board. Please add more money.");
         return;
      }
      else{
         my_station = s;
         is_boarded = true;
      }
   }

   public double cost(Station s){
      return (double) (0.5 + (0.75 * Math.abs(s.getZone() - my_station.getZone())));
   }

   public void exit(Station s){
      if (is_boarded == false){
         System.out.println("Error: Did not board?!");
      }
      else if (cost(s) > balance){
         System.out.println("Insufficient funds to exit. Please add more money.");
         return;
      }
      else{
         System.out.println("From " + my_station.getName() + " to " + s.getName() + " costs " + df.format(cost(s)) + ". SmartCard has " + df.format(balance - cost(s)) + ".");
      }
      is_boarded = false;
      my_station = null;
   }

   public void addMoney(double d){
      System.out.println(df.format(d) + " added. Your new balance is " + df.format(balance + d));
   }
}
   
// ***********  start a new class.  The new class does NOT have public or private.  ***/
class Station
{
   private String name;
   private int zone;

   public Station(String n, int z){
      name = n;
      zone = z;
   }

   public Station(){
      name = "Neha";
      zone = 18;
   }

   public int getZone(){
      return zone;
   }

   public String getName(){
      return name;
   }

}

