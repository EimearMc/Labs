import java.util.*;

public class Frequency{
  
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        String input = scan.nextLine();
        frequency(input);
       
    }
 
    private static void frequency(String input)
    {
        int[] frequency = new int[input.length()];
 
        //convert string to char array
        char array[]=input.toCharArray();
        int[] asciiVals = (toAscii(input, array));
        Arrays.sort(asciiVals);
        
        
        //outside look selects character and counts +1
        for(int i=0; i<input.length(); i++)
        {
            frequency[i]=1;
        
            for(int j=i+1; j<input.length(); j++)
            {
                if(asciiVals[i]==asciiVals[j])
                {
                    frequency[i]++;
 
                    asciiVals[j]='0'; //set to zero to avoid double count
                 }
            }
        }
        
        sortthem(frequency, asciiVals);
    }
 
    public static int[] toAscii(String input, char[] charArray)
    {
        int[] ascii = new int[input.length()];
 
        for(int i=0; i<=charArray.length-1; i++)
        {
            ascii[i]=charArray[i];
            
        }
        return ascii;
    }
 
    
 
    private static void sortthem(int[] freq, int[] array){
        
        int n = array.length; 
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(freq[j-1] < freq[j]){  
                                 temp = array[j-1];  
                                 array[j-1] = array[j];  
                                 array[j] = temp;  
                                 
                                 temp = freq[j-1];  
                                 freq[j-1] = freq[j];  
                                 freq[j] = temp;
                         }  
                          
                 }  
         } 
 
       
        for(int i=0; i<freq.length; i++)
        {
            if(array[i]!=0){
                char c=(char)(array[i]);
                System.out.println( c +" "+freq[i]);
            }
        }
     }
}