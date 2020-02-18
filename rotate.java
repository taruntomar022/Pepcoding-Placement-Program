import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner scn = new Scanner(System.in);
     int number = scn.nextInt();
     int rotation = scn.nextInt();
     int temp = number;
      int count = 0;
    while(number!=0){
        count = count + 1;
        number = number/10;
    }
    int true_rotation = rotation%count;
     
     if(rotation<0){
         true_rotation +=count;
     }
     
     int div = (int)Math.pow(10,true_rotation);
     int mul = (int)Math.pow(10,count-true_rotation);
     
     int quo = temp / div;
     int rem = temp % div;
     
     int result = (rem*mul)+quo;
     System.out.println(result);
    
   }
   }
     