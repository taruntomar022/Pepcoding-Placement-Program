import java.io.*;
import java.util.*;

public class Main{
    public static void insert(int[] arr, Scanner scn){
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int arr1[] = new int[n1]; 
    insert(arr1,scn);
    
    int n2 = scn.nextInt();
    int arr2[] = new int[n2];
    insert(arr2,scn);
    
    diff(arr1,arr2);
}

public static void diff(int arr1[], int arr2[]){
    int size1 = arr1.length;
    int size2 = arr2.length;
    int borrow = 0;
    int i = size1-1;
    int j = size2-1;
    int idx = size2-1;
    int[] narr = new int[size2];
    while(i>=0||j>=0){
        int d1 = i < 0 ? 0 : arr1[i];
        int d2 = j < 0 ? 0 : arr2[j];
        int sub = d2 - d1 - borrow;
          if(sub<0){
           sub = sub + 10;
           borrow = 1;
          }
        else{
            borrow = 0;
        } 
        narr[idx] = sub;
        idx--;
        i--;
        j--;
    }
    
    for(int k=0;k<size2;k++){
        System.out.println(narr[k]);
    }
    
}

}