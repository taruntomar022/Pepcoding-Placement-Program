import java.io.*;
import java.util.*;

public class Main{
  
public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int arr[] = new int[n];
      int narr[] = new int[n];
      for(int i=0;i<n;i++){
          arr[i] = scn.nextInt();
      }
      int temp;
      for(int j=0;j<n;j++){
          temp = arr[j];
          narr[temp] = j;
      }
      for(int i=0;i<n;i++){
          System.out.println(narr[i]);
      }
 }

}