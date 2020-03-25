import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int[] narr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    int last = n-1;
    int temp;
    for(int j=0;j<n/2;j++){
        temp = arr[j];
        arr[j] = arr[last];
        arr[last] = temp;
        last--;
    }
    for(int k=0;k<n;k++){
        System.out.print(arr[k]+" ");
    }
 }

}