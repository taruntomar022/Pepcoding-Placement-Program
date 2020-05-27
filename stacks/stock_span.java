import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = scn.nextInt();
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
    int []ans = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    for(int i=0;i<arr.length;i++){
        while(st.size()>0&&arr[st.peek()]<arr[i]){
            st.pop();
        }
        if(st.size()==0){
            ans[i] = i+1;
        }else{
            ans[i] = i - st.peek();
        }
        st.push(i);
    }
    return ans;
 }

}