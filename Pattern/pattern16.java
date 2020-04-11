import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int n = scn.nextInt();
           int irow = 1;
           int nrow = n;
           int nspace = 2*n-3;
           int nstar = 1;
           while(irow<=nrow){
               int val = 1;
               int istar = 1;
               
            //print numbers
            while(istar<=nstar){
                System.out.print(val+"\t");
                istar++;
                val++;
            }
            
           
           //print spaces
           int ispace = 1;
           while(ispace<=nspace){
               System.out.print("\t");
               ispace++;
           }
           //print numbers
           int lstar = 1;
           int sub = irow==nrow?val-2:val-1;
           while(lstar<=nstar){
               if(lstar<n){
                   System.out.print(sub+"\t");
               }
               sub--;
               lstar++;
           }
            
            System.out.println(); 
            nstar++;
            nspace-=2;
            irow++;
           }
           
      
       }
      }