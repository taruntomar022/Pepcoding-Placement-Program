import java.io.*;
import java.util.*;

public class Main {
  public static class Node { 
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

    public static boolean find(Node node, int val){
        if(node == null){
            return false;
        }
        if(node.data == val){
            return true;
        }
        if(node.data < val){
            return find(node.right, val);
        }
        else if(node.data > val){
            return find(node.left, val);
        }
        return false;
    }

  public static void tsp(Node root, Node node,int data){
       if(node == null){
           return;
       }
      
      tsp(root, node.left, data);
      int val = node.data;
      // complement value
      int cval = data - val;
      // prevents duplicacy
      if(node.data < cval){
          if(find(root,cval)){
              System.out.println(val+" "+cval);
          }
      }
      tsp(root, node.right, data);
  }

  static ArrayList<Integer> res = new ArrayList<>();
  public static void fillList(Node node){
      if(node == null){
          return;
      }
      
      fillList(node.left);
      res.add(node.data);
      fillList(node.right);
  }
 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());
    
    Node root = construct(arr);
    // write your code here
    // tsp(root,root,data);
    fillList(root);
    int sum = 0;
    int lo = 0;
    int hi = res.size()-1;
    while(lo<hi){
        sum = res.get(lo) + res.get(hi);
        if(sum == data){
            System.out.println(res.get(lo) +" "+ res.get(hi));
            lo++;
            hi--;
        }
        else if(sum < data){
            lo++;
        }else{
            hi--;
        }
    }
  }

}
