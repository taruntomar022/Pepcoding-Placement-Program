import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int k=0;k<n;k++){
        arr[k] = scn.nextInt();
    }
    for(int i=0;i<n;i++){
        int count = i;
        while(count<n){
            for(int j=i;j<=count;j++){
                System.out.print(arr[j]+"\t");
            }
            System.out.println();
            count++;
        }
        
    }
 }

}