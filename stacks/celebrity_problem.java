import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()>1){
            int c1 = st.pop();
            int c2 = st.pop();
            if(arr[c1][c2] == 1){
                st.push(c2);
            }else{
                st.push(c1);
            }
        }
        int res = st.pop();
        boolean flag = true;
        for(int i=0;i<n;i++){
            if(i!=res){
                if(arr[i][res]==0 || arr[res][i]==1){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println(res);
        }else{
            System.out.println("none");
        }
        
    }

}