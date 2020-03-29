import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int pow = power(x,n);
        System.out.println(pow);
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        
        int powerNb2 = power(x,n/2);
        int powerN = powerNb2*powerNb2;
        
        if(n%2!=0){
            powerN = x*powerN;
        }
        return powerN;
    }

}