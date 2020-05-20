import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        peqs(arr,0,0,"",0,"");
        
    }
    
    public static void peqs(int arr[],int vidx,int setsum1,String set1,int setsum2, String set2){
        if(vidx==arr.length){
            if(setsum1 == setsum2){
                System.out.println(set1 +" .&. "+set2);
            }
            return;
        }
        
        
        //when element is included in set1
        peqs(arr,vidx+1,setsum1+arr[vidx],set1+arr[vidx]+" ",setsum2,set2);
        //when element is included in set2
        peqs(arr,vidx+1,setsum1,set1,setsum2+arr[vidx],set2+arr[vidx]+" ");
    }
    
    
    
}