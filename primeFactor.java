import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int temp = n;
      for(int i = 2;i*i<=n;i++){
          while(temp%i == 0){
              System.out.print(i+" ");
              temp /= i;
          }
          
      }
      if(temp!=1){
          System.out.println(temp);
      }
     }
    }