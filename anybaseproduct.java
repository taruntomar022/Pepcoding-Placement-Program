import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    
     int num = 0, pow = 1;
     while(n1!=0){
         int r = n1%10;
         num = num + r*pow;
         pow = pow*b;
         n1 = n1/10;
     }
     int num2=0,poww=1;
     while(n2!=0){
         int rem = n2%10;
         num2 = num2 + rem*poww;
         poww = poww*b;
         n2=n2/10;
     }
     
     int n3 = num*num2;
     int num3 =0,powr=1;
           while(n3!=0){
               int remm = n3%b;
               num3 = num3 +remm*powr;
               powr = powr*10;
               n3 = n3/b;
           }
     System.out.print(num3);
     
 }

}