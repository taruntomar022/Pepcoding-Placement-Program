import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        pair[] pairs = new pair[arr.length];
        for(int i=0;i<arr.length;i++){
            pair cp = new pair();
            cp.st = arr[i][0];
            cp.et = arr[i][1];
            pairs[i] = cp;
        }
        Arrays.sort(pairs);
        Stack<pair> st = new Stack<>();
        st.push(pairs[0]);
        for(int i=1;i<pairs.length;i++){
            pair cp= pairs[i];
            if(st.peek().et >= cp.st){
                st.peek().et = Math.max(cp.et, st.peek().et);
            }else{
                st.push(cp);
            }
        }
        int i=0;
        pair[] ans = new pair[st.size()];
        while(st.size()>0){
            ans[i] = st.pop();
            i++;
        }
        for(int j=ans.length-1;j>=0;j--){
            System.out.println(ans[j].st + " "+ans[j].et);
        }
        
    }


    public static class pair implements Comparable<pair>{
        int st;
        int et;
        public int compareTo(pair other){
            return this.st - other.st;
        }
    }
    
}