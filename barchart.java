import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    
    for(int j=0;j<n;j++){
        if(arr[j]>max){
            max = arr[j];
        }
    }
    int countlevel = max;
    for(int i=0;i<max;i++){
        for(int j=0;j<arr.length;j++){
            if(arr[j]>=countlevel){
                System.out.print("*\t");
            }
            else{
                System.out.print("\t");
            }
        }
        countlevel--;
        System.out.println();
    }
 }

}