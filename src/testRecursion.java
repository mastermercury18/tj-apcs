import java.util.*;

public class testRecursion {
    public static void main (String [] args)
    {
        //show(123);
        //System.out.println(mixup("IDEAL"));
        int[] a = new int[] {1, 3, 4, 7, 9, 11, 13};
        disarray(a, 7);
        System.out.println(Arrays.toString(a));

    }
    public static void show(int n){
        System.out.println(n%10);
        if (n > 0){
            show(n/10);
        }
        System.out.println(n%10);

    }

    public static double sum(int n){
        if (n==0){
            return 0;
        }
        return 1 + sum(1/n-1);
    }

    public static void fibIter(int n){
        int a = 0;
        int b = 1;
        int c = 1;
        for(int i=0; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.println(a);
        }
    }

   public static String mixup(String word)
    {
        if(word.length() == 1)
            return "";
        else
            return mixup(word.substring(0, word.length()-1));
    }

    public static int goFigure( int x )

    {

        if( x < 100 ) {
            System.out.println(x);
            x = goFigure(x + 10);
        }

        return (x-1);

    }

    public static int surprise( int n, int a, int d )
    {
        if( n == 1 )
            return a;
        else
            return d + surprise(n - 1, a, d);
    }

    public static int mystery( int k, int n )
    {
        if( n == k )
            return k;
        else
        if( n > k )
            return mystery(k, n - k);
        else
            return mystery(k - n, n);
    }

    public static int sumnums(int n){
        if( n == 1){
            return 1;
        }
        return n + sumnums(n - 1);
    }

    public static int f1( int a, int b )
    {
        if( a == b )
            return b;
        else
            return a + f2(a-1, b);
    }

    public static int f2( int p, int q )
    {
        if( p < q )
            return p + q;
        else
            return p + f1(p-2, q);
    }

    public static String prepare(String s)
    {
        int k = s.length() / 2;
        if(k <= 1)
            return s;
        return s.charAt(k - 1) + prepare(s.substring(0, k - 1) + s.substring(k + 1, 2*k)) + s.charAt(k);
    }

    public static boolean isProcessedX(int n, int[] v)
    {
        if(n >= 2 && isProcessedX(n-1, v))
        {
            v[n-1] = v[n-2];
            return true;
        }
   else
        return false;
    }

    public static void disarray(int[] a, int n) {
        if (n > 1) {
            disarray(a, n - 1);
            a[n - 1] += a[n - 2];
        }
    }

}
