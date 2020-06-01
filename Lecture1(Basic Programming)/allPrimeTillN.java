//  1. You've to print all prime numbers between a range. 
//  2. Take as input "low", the lower limit of range
//  3. Take as input "high", the higher limit of range
//  4. For the range print all the primes numbers between low and high (both included)

import java.util.*;
   public class Main{
       public static void main(String[] args) {
           // write your code here
           Scanner scn = new Scanner(System.in);
           int ul = scn.nextInt();
           int ll = scn.nextInt();
           for(;ul<=ll;ul++){
           int isP = 1;
               for(int i =2;i*i<=ul;i++){
                   if(ul%i==0){
                       isP =0;
                   }      
               }
               if(isP==1){
                   System.out.println(ul);
               }
               
               
           }
       }
   }                              
