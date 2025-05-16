import java.util.*;

public class TestString {
    public static void main(String args[])
    {
        String name1 = new String("Jordan");
        String name2 = new String("Jorx");

        System.out.println(name1.compareTo(name2));

        String line = "Some more really silly stuff on strings!";

        String s = null;
        System.out.println(s);
      //  System.out.println(s.toString());

        String[] abra3 = "A B R A C A D A B R A".split(" ");
        for (String str : abra3){
            System.out.print(str + " ");
        }
        System.out.println(Arrays.toString(abra3));





    }
}
