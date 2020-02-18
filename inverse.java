import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int multiplier=1,pos=1;
      int a = 0;
      while(n!=0){
         int value = n%10;
          multiplier = (int)Math.pow(10,value-1);
          a = a + pos*multiplier;
          n=n/10;
          pos++;
      }
      System.out.println(a);
     }
    }