import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    int max = 0;
    for(int j=0;j<n;j++){
        if(arr[j]>max){
            max= arr[j];
        }
    }
    int min = max;
    for(int k=0;k<n;k++){
        if(arr[k]<min){
            min = arr[k];
        }
    }
    
    int spandiff = max-min;
    System.out.print(spandiff);
 }

}