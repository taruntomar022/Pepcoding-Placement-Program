import java.util.*;
     
     public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
     
          // write ur code here
          int n = scn.nextInt();
          
          for(int i =0;i<n;i++){
              int val = 1;
              for(int j=0;j<=i;j++){
                  System.out.print(val+"\t");
                  val = ((i-j)*val)/(j+1);
              }
              System.out.println();
          }
     
      }
     }