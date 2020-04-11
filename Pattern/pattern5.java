import java.util.*;
               
               public class Main{
               
               public static void main(String[] args) {
                   Scanner scn = new Scanner(System.in);
               
                    // write ur code here
                    int n = scn.nextInt();
                    // int mid = (n/2)+1;
                    // int istar = 1;
                    // int temp = n - mid;
                    // int temp2 = 1;
                    // int nstar = n-2;
                    // for(int i =1;i<=n;i++){
                       
                    //         if(i<=mid){
                    //             for(int k=temp;k>=1;k--){
                    //                 System.out.print("\t");
                    //             }
                    //             temp--;
                    //             for(int j=1;j<=istar;j++){
                    //                 System.out.print("*\t");
                    //             }
                    //             istar+=2;
                    //         }
                    //         if(i>mid){
                                
                    //             for(int p=1;p<=temp2;p++){
                    //                 System.out.print("\t");
                    //             }
                    //             temp2++;
                    //             for(int q=nstar;q>=1;q--){
                    //                 System.out.print("*\t");
                    //             }
                    //             nstar -=2;
                    //         }
                            
                    //   System.out.println(); 
                    // }
                    
                    int nrows = n;
                    int irow = 1;
                    int nstars = 1;
                    int nspaces = n/2;
                    while(irow<=nrows){
                        int ispace = 1;
                        while(ispace <=nspaces){
                            System.out.print("\t");
                            ispace++;
                        }
                    
                    //print stars
                    int istar = 1;
                    while(istar <= nstars){
                        System.out.print("*\t");
                        istar++;
                    }
                    
                    System.out.println();
                    
                    if(irow <= nrows/2){
                        nspaces--;
                        nstars++;
                        nstars++;
                    }
                    else{
                        nspaces++;
                        nstars--;
                        nstars--;

                    }
                    irow++;
                    }
                }
               }