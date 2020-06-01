// 1. You've to check whether a given number is prime or not.
// 2. Take a number "t" as input representing count of input numbers to be tested.
// 3. Take a number "n" as input "t" number of times.
// 4. For each input value of n, print "prime" if the number is prime and "not prime" otherwise.

import java.util.*;
  
  public class Main{
    
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
     
      while(n!=0){
          int a = scn.nextInt();
          int isPrime = 1;
          for(int i =2;i*i<=a;i++){
              if(a % i ==0){
                  isPrime = 0;
              }
          }
          if(isPrime == 1){
              System.out.println("prime");
          }
          else{
              System.out.println("not prime");
          }
          n = n-1;
      }         
   }
  }
