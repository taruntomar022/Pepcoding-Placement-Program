import java.util.*;
          
          public class Main{
          
          public static void main(String[] args) {
              Scanner scn = new Scanner(System.in);
          
               // write ur code here
               int n = scn.nextInt();
               int irow = 1;
               int nstar = n;
               int nspace = 0;
               
               while(irow<=nrow){
                   
                   int ispace = 1;
                   while(ispace<=nspace){
                       System.out.print("\t");
                       ispace++;
                   }
                   int istar = 1;
                   while(istar<=nstar){
                       System.out.print("*\t");
                       istar++;
                   }
                   System.out.println();
                   irow++;
                   nspace++;
                   nstar--;
               }
          
           }
          }