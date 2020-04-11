import java.util.*;
       
       public class Main{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
       
            // write ur code here
            int n = scn.nextInt();
           int nspaces = n/2;
           int nstars = 1;
           for(int i =1;i<=n;i++){
               
               //spaces
               for(int ispace = 1;ispace<=nspaces;ispace++){
                   if(i==n/2+1){
                       System.out.print("*\t");
                   }
                   else{
                       System.out.print("\t");
                   }
               }
               //stars
               for(int istar = 1;istar<=nstars;istar++){
                   System.out.print("*\t");
               }
               if(i<=n/2){
                   nstars++;
               }
               else{
                   nstars--;
               }
               System.out.println();
           }
       
        }
       }