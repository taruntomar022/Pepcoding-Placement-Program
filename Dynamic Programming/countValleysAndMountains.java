import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int ans = binCoeff(2*n,n);
    ans = ans/(n+1);
    System.out.println(ans);
 }
 
 public static int binCoeff(int n,int k){
     int res = 1;
     if(k>n-k){
         k = n-k;    // since C(n,k) = C(n,n-k)
     }
     
     for(int i=0;i<k;i++){
         res *= n-i;
         res /= i+1;
     }     
     
     return res;
 }

}