import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int total_sum = 0;
       int pow =1;
       int carry = 0;
       while(n1!=0||n2!=0||carry!=0){
           
           int div1 = n1%10;
           int div2 = n2%10;
          
           int sum = div1 + div2 +carry;
        //   carry = 0;
        //   if(sum>=b){
        //       carry = 1;
        //       sum = sum%b;
        //   }
           carry = sum/b;
           sum = sum%b;
           
           
           total_sum = total_sum + sum*pow;
           pow = pow*10;
           n1 = n1/10;
           n2 = n2/10;
       }
       return total_sum;
   }
  
  }