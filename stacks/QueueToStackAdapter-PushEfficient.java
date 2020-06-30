import java.io.*;
import java.util.*;

public class Main {

    public static class QueueToStackAdapter {
        Queue < Integer > mainQ;
        Queue < Integer > helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque < > ();
            helperQ = new ArrayDeque < > ();
        }

        int size() {
            return mainQ.size();
        }
        void push(int val) {
            mainQ.add(val);
        }
        int pop() {
            int n = mainQ.size();
            if (n > 0) {
                // remove n-1 elements
                while(mainQ.size()>1){
                    helperQ.add(mainQ.remove());
                }
                // return top most element
                int res = mainQ.remove();
                //---------method 1 -----------------
                // to add elements back from helper Queue to main Q
                // while(helperQ.size()>0){
                //     mainQ.add(helperQ.remove());
                // }
                
                // ------method 2--------------
                // to swap helper Q and mainQ
                Queue<Integer> tempQ = mainQ;
                mainQ = helperQ;
                helperQ = tempQ;
                return res;
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }
        int top() {
            int n = mainQ.size();
            if (n > 0) {
                while(mainQ.size()>1){
                    helperQ.add(mainQ.remove());
                }
                int res = mainQ.remove();
                helperQ.add(res);
                while(helperQ.size()>0){
                    
                    mainQ.add(helperQ.remove());
                }
                return res;
            } else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            str = br.readLine();
        }
    }
}