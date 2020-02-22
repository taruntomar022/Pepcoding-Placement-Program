import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       int result = 0;
       int pow =1;
        int borrow = 0;
       while(n1!=0||n2!=0){
           
           int div1 = n1%10;
           int div2 = n2%10;
           int sub = div2 - div1 -borrow;
          if(sub<0){
           sub = sub + b;
           borrow = 1;
          }
        else{
            borrow = 0;
        }        
           result = result + (sub*pow);
           pow = pow*10;
           n1 = n1/10;
           n2 = n2/10;
       }
       return result;
   }
  
  }