import java.util.*;
       
       public class Main{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
       
            // write ur code here
            int n = scn.nextInt();
            
            int irow = 1;
            int nspaces = 1;
            int nrows=n;
            int nstars = n/2+1;
            while(irow<=nrows){
                
                //print stars
                int istar = 1;
                while(istar<=nstars){
                    System.out.print("*\t");
                    istar++;
                }
                //print space
                int ispace = 1;
                while(ispace <= nspaces){
                    System.out.print("\t");
                    ispace++;
                }
                //print stars
                istar = 1;
                while(istar<=nstars){
                    System.out.print("*\t");
                    istar++;
                }
                //next line
                System.out.println();
                //preparation
                if(irow<=nrows/2){
                    nspaces++;
                    nspaces++;
                    nstars--;
                }
                else{
                    nspaces--;
                    nspaces--;
                    nstars++;
                }
                irow++;
            }
       
        }
       }