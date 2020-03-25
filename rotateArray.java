import java.io.*;
import java.util.*;


public class Main{
  

public static void main(String[] args)  {
    Scanner scn =  new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    
    for(int i=0;i<arr.length;i++){
          arr[i] = scn.nextInt();
      }
    int k = scn.nextInt();
    k = k%n;
    if(k<0){
        k += n;
    }
    int rotation = n - k;
    int[] narr = new int[n]; 
    int pos = 0;
    for(int j=rotation;j<n;j++){
        narr[pos] = arr[j];
        pos++;
    }
    
    for(int h=0;h<rotation;h++){
        narr[pos] = arr[h];
        pos++;
    }
     for(int i=0;i<n;i++){
        System.out.print(narr[i]+" ");
    }
 }

}