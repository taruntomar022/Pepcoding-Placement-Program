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
    int searchele = scn.nextInt();
    int count = 0;
    int pos=-1;
    for(int j=0;j<n;j++){
        if(searchele == arr[j]){
            count ++;
            pos = j;
        }
        
    }
    if(count>1){
        System.out.print(pos);
    }
    else{
        System.out.print(pos);
    }
 }

}