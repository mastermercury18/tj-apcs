// Name:  Neha Chandran 
// Date:  09/15/2022
import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) 
   {
     //part_1_using_pig();
     part_2_using_piglatenizeFile();
      
      /*  extension only    */
      // String pigLatin = pig("What!?");
      // System.out.print(pigLatin + "\t\t" + pigReverse(pigLatin));   //Yahwta!?
      // pigLatin = pig("{(Hello!)}");
      // System.out.print("\n" + pigLatin + "\t\t" + pigReverse(pigLatin)); //{(Yaholle!)}
      // pigLatin = pig("\"McDonald???\"");
      // System.out.println("\n" + pigLatin + "  " + pigReverse(pigLatin));//"YaDcmdlano???"
   }

   public static void part_1_using_pig()
   {
      Scanner sc = new Scanner(System.in); //input from the keyboard
      while(true)
      {
         System.out.print("\nWhat word? ");
         String s = sc.next();     //reads up to white space
         if(s.equals("-1"))
         {
            System.out.println("Goodbye!"); 
            System.exit(0);
         }
         String p = pig(s);
         System.out.println( p );
      }		
   }

   public static final String punct = ",./;:'\"?<>[]{}|`~!@#$%^&*()";
   public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   public static final String vowels = "AEIOUaeiou";
   public static String pig(String s)
   {
      String beg_punct = "";
      String end_punct = "";
      String true_end_punct = "";
      String beg_word = "";

     //remove and store the beginning punctuation
      for (int i=0; i < s.length(); i++){
         if (!letters.contains(s.substring(i, i+1))){
            if (punct.contains(s.substring(i, i+1))){
               beg_punct += s.substring(i, i+1);
            }
         }
         else{
            break;
         }
      }
      //remove and store the ending punctuation 
      for (int i= s.length(); i > 0; i--){
         if (letters.contains(s.substring(i-1, i))){
            break;
         }
         else{
            end_punct += s.substring(i-1, i);
         }
      }
      for (int i=end_punct.length(); i > 0; i--){
         true_end_punct += end_punct.substring(i-1, i);
      }
      s = s.replace(beg_punct, "");
      s = s.replace(true_end_punct, ""); 

      //START HERE with the basic case:
      //     find the index of the first vowel
      //     y is a vowel if it is not the first letter
      //     qu
      
      if (s.equals("")){
         return s;
      }
      if (s != "" && vowels.contains(s.substring(0, 1))){ // first letter is vowel
         s = beg_punct + s + "way" + true_end_punct;
         return s;
      } 
      else if (s != "" && !vowels.contains(s.substring(0, 1))) {
         for (int i=1; i < s.length(); i++) { // first letter not vowel
            if (s.toLowerCase().contains("qu") && vowels.contains(s.toLowerCase().substring(s.toLowerCase().indexOf("qu") + 2, s.toLowerCase().indexOf("qu") + 3))) { // qu special case
               beg_word = s.substring(0, s.toLowerCase().indexOf("qu") + 2);
               s = capitalize(s, beg_word, beg_punct, true_end_punct);
               return s;
            }
            else if (s != "" && vowels.contains(s.substring(i, i + 1)) || (s.charAt(0) != 'y' && s.substring(i, i+1).equals("y"))) { // ith letter is vowel
               beg_word = s.substring(0, i);
               s = capitalize(s, beg_word, beg_punct, true_end_punct);
               return s;
            }
         }
         // if the first character of old s is capital, then capitalize first letter of new s
         //Character.toUpperCase(s.charAt(0));
      }
      //if no vowel has been found
      //is the first letter capitalized?

      //return the piglatinized word 

      return "**** NO VOWEL ****"; 
   }

   public static String capitalize(String s, String beg_word, String beg_punct, String end_punct){
      if (Character.isUpperCase(s.charAt(0))){
         s = s.replaceFirst(beg_word, "");
         s = beg_punct + s.substring(0,1).toUpperCase() + s.substring(1) + beg_word.substring(0,1).toLowerCase() + beg_word.substring(1) + "ay" + end_punct;
      }
      else{
         s = s.replaceFirst(beg_word, "");
         s = beg_punct + s + beg_word + "ay" + end_punct;
      }
      return s;
   }


   public static void part_2_using_piglatenizeFile() 
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("input filename including .txt: ");
      String fileNameIn = sc.next();
      System.out.print("output filename including .txt: ");
      String fileNameOut = sc.next();
      piglatenizeFile( fileNameIn, fileNameOut );
      System.out.println("Piglatin done!");
   }

/****************************** 
*  piglatinizes each word in each line of the input file
*    precondition:  both fileNames include .txt
*    postcondition:  output a piglatinized .txt file 
******************************/
   public static void piglatenizeFile(String fileNameIn, String fileNameOut) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(fileNameIn));  
      }
      catch(IOException e)
      {
         System.out.println("oops"+ e.getMessage());
         System.exit(0);   
      }
   
      PrintWriter outfile = null;
      try
      {
         outfile = new PrintWriter(new FileWriter(fileNameOut));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
   	//process each word in each line
      boolean isFirstLine = true;
      while(infile.hasNextLine()){
         if (!isFirstLine){
            outfile.print("\n");
            isFirstLine = false;
         }
         String line = infile.nextLine();
         String[] result = line.split(" ");
         for (int i=0; i < result.length; i++) {
            if (i == result.length - 1){
               outfile.print(pig(result[i]));
            }
            else{
               outfile.print(pig(result[i]) + " ");
            }
         }
         isFirstLine = false;
      }
   
      outfile.close();
      infile.close();
   }
   
   /** EXTENSION: Output each PigLatin word in reverse, preserving before-and-after 
       punctuation.  
   */
   public static String pigReverse(String s)
   {
      if(s.length() == 0)
         return "";
         
      return "";   //just to compile   
   }
}
