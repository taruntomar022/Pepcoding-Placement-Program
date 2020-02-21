import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int n = scn.nextInt();
           int nrows = n;
                    int irow = 1;
                    int nstars = 1;
                    int nspaces = n/2;
                    int init_val =1;
                    while(irow<=nrows){
                        int ispace = 1;
                        while(ispace <=nspaces){
                            System.out.print("	");
                            ispace++;
                        }
                    
                    //print stars
                    int istar = 1;
                    int val = init_val;
                    while(istar <= nstars){
                        
                        System.out.print(val+"	");
                        if(istar<nstars/2+1){
                            val++;
                        }
                        else{
                            val --;
                        }
                        istar++;
                        
                    }
                    
                    System.out.println();
                    
                    if(irow <= nrows/2){
                        nspaces--;
                        init_val++;
                        nstars++;
                        nstars++;
                    }
                    else{
                        nspaces++;
                        nstars--;
                        init_val--;
                        nstars--;

                    }
                    irow++;
                    }
      
       }
      }