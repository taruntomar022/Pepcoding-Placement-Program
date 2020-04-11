//upper triangle using stars

import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int n = scn.nextInt();
           int nrow = n;
           int irow = 1;
           int nstar = n;
           while(irow<=nrow){
           int istar = 1;
               while(istar<=nstar){
                   System.out.print("*\t");
                   istar++;
               }
               
               System.out.println();
               irow++;
               nstar--;
           }
       }
      }