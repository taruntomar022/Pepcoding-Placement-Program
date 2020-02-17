// 1. You've to print first n fibonacci numbers.
//   2. Take as input "n", the count of fibonacci numbers to print.
//   3. Print first n fibonacci numbers.

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // write your code here
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int i = 0,j=1,sum;
      for(int k=1;k<=n;k++){
          if(i<10){
        System.out.println(i);
          sum = i + j;
          i=j;
          j = sum;
         }         
    }
  }
 }