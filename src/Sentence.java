// Name:  
// Date: 
  
public class Sentence
{
   private String mySentence;
   private int myNumWords;
   
   //Precondition:  str is not empty.
   //               Words in str separated by exactly one blank.
   public Sentence( String str )
   { 
      mySentence = str;
      String[] words = str.split(" ");
      myNumWords = words.length;
   }
   
   public int getNumWords()
   {  
      return myNumWords;  
   }

   public String getSentence()
   {
      return mySentence; 
   }
   
   //Returns true if mySentence is a palindrome, false otherwise.
   //calls the 3-arg isPalindrome(String, int, int)
   public boolean isPalindrome()
   {
      String x = "";
     // x = lowerCase(removeBlanks(removePunctuation(mySentence)));
      x = lowerCase(removePunctuation(removeBlanks(mySentence)));
      return isPalindrome(x, 0, x.length());
   }
   //Precondition: s has no blanks, no punctuation, and is in lower case.
   //Recursive method.
   //Returns true if s is a palindrome, false otherwise.
   public static boolean isPalindrome(String s, int start, int end )
   {
      boolean temp_bool = false;
      if (s == ""){
         return true;
      }
      if (start >= end-1){
         return true;
      }
      if (s.charAt(start) == s.charAt(end-1)){
         temp_bool = isPalindrome(s, start + 1, end - 1);
      }
      return temp_bool;
   }
   //Returns copy of String s with all blanks removed.
   //Postcondition:  Returned string contains just one word.
   public static String removeBlanks( String s )
   {
      s = s.replaceAll(" ", "");
      return s;
   }
   
   //Returns copy of String s with all letters in lowercase.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   public static String lowerCase( String s )
   {  
      return s.toLowerCase();
   }
   
   //Returns copy of String s with all punctuation removed.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   public static String removePunctuation( String s )
   {
      String punct = ".,'?!:;\"(){}[]<>";
      for (int i=0; i<s.length(); i++){
         if (punct.contains(s.substring(i, i+1))){
            s = s.replace(s.substring(i, i+1), "");
            i --;
         }
      }
      //System.out.println("Punctuation removed: " + s);
      return s;
   }
}

 /*****************************************
   
 PALINDROME TESTER
 "Hello there!" she said.
 4
 false
 
 A Santa lived as a devil at NASA.
 8
 true
 
 Flo, gin is a sin! I golf.
 7
 true
 
 Eva, can I stab bats in a cave?
 8
 true
 
 Madam, I'm Adam.
 3
 true

 **********************************************/

