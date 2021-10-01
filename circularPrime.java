import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count=0;
        for(int i=1; i<=n; i++)
        {
            if(checkCircular(i))
            {
                count++;
            }
        }
        System.out.println(count);
    }
    

   static boolean isPrime(int x)
    {
        if(x<=1){
        return false;
        }
        if(x<=3){
        return true;
        }
        if(x%2==0||x%3==0){
            return false;
        }
        
        for(int i=5; i*i<=x; i=i+6)
        {
            if(x%i==0||x%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    static boolean checkCircular(int y)
    {
        int count=0, temp = y;
        while(temp>0)
        {
            count++;
            temp/=10;
        }
        int n = y;
        while(isPrime(n)){
            int rem = n%10, div = n/10;
            
            n = (int)((Math.pow(10, count - 1)) * rem) + div;
            if(n==y) return true;
        }
        //if(n==y) return true;
        return false;
    }
}