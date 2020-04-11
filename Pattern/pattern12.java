import java.util.*;
     
     public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
     
          // write ur code here
          int a =1;
          int n = scn.nextInt();
          int p = 0,q=1,sum=0;
          for(int i =0;i<n;i++){
              for(int j=0;j<=i;j++){
                  System.out.print(p+"\t");
                  sum = p + q;
                    p=q;
                    q = sum;
                    
              }
              System.out.println();
          }
     
      }
     }