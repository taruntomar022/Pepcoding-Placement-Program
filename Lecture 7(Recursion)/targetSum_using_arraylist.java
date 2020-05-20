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
        int tar = scn.nextInt();
        ptss(arr,tar,0,0,new ArrayList<>());
        
    }
    
    public static void ptss(int arr[],int tar,int vidx,int setsum, ArrayList<Integer> set){
        if(vidx == arr.length){
            if(setsum==tar)
                System.out.println(set);
            return;
        }
        
        
        // when the element is included
        set.add(arr[vidx]);
        ptss(arr,tar,vidx+1,setsum+arr[vidx],set);
        set.remove(set.size()-1);
        // when the element is not included
        ptss(arr,tar,vidx+1,setsum,set);
    }
}