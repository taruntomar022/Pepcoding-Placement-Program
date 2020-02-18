import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int c = scn.nextInt();
//   int h =0;
//     int p;
//     int temp;
//     int val = 0;
//     if(a>b && a>c){
//         h = a;
//         p = h*h;
//         temp = b*b+c*c;
//         if(p == temp){
//             val = 1;
//         }
        
        
//     }
//     if(b>c && b>a){
//          h = b;
//          p = h*h;
//         temp = a*a+c*c;
//         if(p == temp){
//             val = 1;
//         }
//     }
//     if(c>a && c>b){
//          h = c;
//          p = h*h;
//         temp = b*b+a*a;
//         if(p == temp){
//             val = 1;
//         }
//     }
    
    
//     if(val == 1){
//         System.out.println("true");
        
//     }
//     else{
//         System.out.println("false");   
//     }

    boolean result = false;
    result = result || ((a*a) == (b*b) + (c*c));
    result = result || ((b*b) == (a*a) + (c*c));
    result = result || ((c*c) == (a*a) + (b*b));
    System.out.println(result);
    
    }
   
  }