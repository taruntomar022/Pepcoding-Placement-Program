//Lower Triangle Pattern 

import java.util.*;
            
            public class Main{
            
            public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
            
                 // write ur code here
                 int n = scn.nextInt();
                 int nspace = n-1;
                 int irow = 1;
                 int nrow = n;
                 int nstar = 1;
                 
                 while(irow<=nrow){
                 int ispace = 1;
                     while(ispace<= nspace ){
                         System.out.print("\t");
                         ispace++;
                     }
                 int istar = 1;
                     while(istar<=nstar){
                         System.out.print("*\t");
                     istar++;
                     }
                     System.out.println();
                     nspace--;
                     irow++;
                     nstar++;
                 }
            
             }
            }