import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn = new Scanner(System.in);
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
      int temp;
      int gcd=0;
      if(n1>n2){
          temp = n2;
      }
      else{
          temp = n1;
      }
      for(int i =temp;i>0;i--){
          if(n1%i==0 && n2%i==0){
              gcd = i;
              break;
          }
      }
      int lcm = (n1*n2)/gcd;
      System.out.println(gcd);
      System.out.println(lcm);
      
     }
    }