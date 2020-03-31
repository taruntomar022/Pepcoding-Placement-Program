import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // printStairPathsPost(n,"");
        printStairPathsPre(n,"");
        
    }
    // Reactive or postactive approach
    public static void printStairPathsPost(int n, String path) {
        if(n<0){
            return;
        }
        if(n==0){
            //all stairs are climbed
            System.out.println(path);
            return;
        }
        // 1 length step
        printStairPathsPost(n-1,path+"1");
        // 2 length step
        printStairPathsPost(n-2,path+"2");
        // 3 length step
        printStairPathsPost(n-3,path+"3");
        
        return;
    }
    
    //preactive approach
    public static void printStairPathsPre(int n, String path) {
        // if(n<0){
        //     return;
        // }
        if(n==0){
            //all stairs are climbed
            System.out.println(path);
            return;
        }
        // 1 length step
        if(n-1>=0){
            printStairPathsPre(n-1,path+"1");
            // 2 length step
            if(n-2>=0){ 
                printStairPathsPre(n-2,path+"2");
                // 3 length step
                if(n-3>=0){
                    printStairPathsPre(n-3,path+"3");
                }
            }
        }
        
        return;
    }
    

}