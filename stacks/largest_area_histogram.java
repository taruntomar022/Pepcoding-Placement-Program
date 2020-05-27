import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    histogram(arr);
 }
 
 public static void histogram(int arr[]){
     Stack<Integer> st = new Stack<>();
     //right boundary 
     st.push(arr.length-1);
     int rb[] = new int[arr.length];  // stores right boundary values for each index of the array
     rb[arr.length - 1] = arr.length;
     for(int i=arr.length-2;i>=0;i--){
         while(st.size()>0&&arr[i]<=arr[st.peek()]){
             st.pop();
         }
         if(st.size()==0){
             rb[i] = arr.length;
         }else{
             rb[i] = st.peek();
         }
             st.push(i);
     }
     //left boundary
     int lb[] = new int[arr.length];  // stores left boundary values for each index of the array
     st = new Stack<>();
     st.push(0);
     lb[0] = -1;
     for(int i=1;i<arr.length;i++){
         while(st.size()>0&&arr[i]<=arr[st.peek()]){
             st.pop();
         }
         if(st.size()==0){
             lb[i] = -1;
         }else{
             lb[i] = st.peek();
         }
         st.push(i);
     }
     
     int maxArea = 0;
     for(int i=0;i<arr.length;i++){
         int width = rb[i]-lb[i]-1;
         int area = arr[i]*width;
         if(area>maxArea){
             maxArea = area;
         }
     }
     
     System.out.println(maxArea);
 }
}