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
        peqs(arr,0,0,new ArrayList<>(),0,new ArrayList<>());
        
    }
    
    public static void peqs(int arr[],int vidx,int setsum1,ArrayList<Integer> set1,int setsum2,ArrayList<Integer> set2){
        if(vidx==arr.length){
            if(setsum1 == setsum2){
                System.out.println(set1 +" .&. "+set2);
            }
            return;
        }
        
        
        //when element is included in set1
        set1.add(arr[vidx]);
        peqs(arr,vidx+1,setsum1+arr[vidx],set1,setsum2,set2);
        set1.remove(set1.size()-1);
        //when element is included in set2
        set2.add(arr[vidx]);
        peqs(arr,vidx+1,setsum1,set1,setsum2+arr[vidx],set2);
        set2.remove(set2.size()-1);
    }
    
    
    
}