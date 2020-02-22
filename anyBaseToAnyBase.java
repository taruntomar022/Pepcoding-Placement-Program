import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b1 = scn.nextInt();
      int b2 = scn.nextInt();
  
      int d = getValue(n, b1, b2);
      System.out.println(d);
   }
  
   public static int getValue(int n, int b1, int b2){
       // write your code here
       
       int num =0,pow=1;
           while(n!=0){
               int r = n%10;
               num = num +r*pow;
               pow = pow*b1;
               n = n/10;
           }
           int pow2=1;
           int num2=0;
           int num1 = num;
           while(num1!=0){
               int r1 = num1%b2;
               num2 = num2 +r1*pow2;
               pow2 = pow2*10;
               num1 = num1/b2;
           }
           return num2;
       }
           
       
   
  
   
  }