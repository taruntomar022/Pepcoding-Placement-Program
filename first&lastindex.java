import java.io.*;
import java.util.*;

public class Main{
    
    public static void insert(int[] arr, Scanner scn){
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }

public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    insert(arr,scn);
    int searchele = scn.nextInt();
    search(arr,searchele);   
    }
public static void search(int []arr,int searchele){
    int first = -1;
    int last = -1;
    for(int i=0;i<arr.length;i++){
        if(arr[i]==searchele){
            if(first==-1){
                first = i;
                last = i;
            }
            else{
                last = i;
            }
        }
    }
    System.out.println(first);
    System.out.println(last);
}
}