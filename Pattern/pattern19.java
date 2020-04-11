//printing swastik pattern

import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int n = scn.nextInt();
           int m = (n/2)+1;
           for(int i=1;i<=n;i++){
               for(int j=1;j<=n;j++){
                   if(i==m||j==m){
                       System.out.print("*\t");
                   }
                   else if((j<=m&&i==1)||(j>=m&&i==n)){
                       System.out.print("*\t");
                   }
                   else if((i<=m&&j==n)||(i>=m&&j==1)){
                       System.out.print("*\t");
                   }
                   else{
                       System.out.print("\t");
                   }   
                  }
               System.out.println();
           }
           
      
       }
      }