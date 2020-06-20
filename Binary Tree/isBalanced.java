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
  
  // -------------------------using pair class----------------------------
  public static class bPair{
      int ht;
      boolean isBal;
  }
  public static bPair balanced(Node node){
      if(node == null){
          bPair bs = new bPair();
          bs.ht = -1;
          bs.isBal = true;
          return bs;
      }
      
      bPair lh = balanced(node.left);
      bPair rh = balanced(node.right);
      int h = Math.max(lh.ht, rh.ht);
      bPair ans = new bPair();
      ans.ht = h + 1;
      int gap = Math.abs(lh.ht - rh.ht);
      if(gap <= 1 && lh.isBal == true && rh.isBal == true){
          ans.isBal = true;
      }else{
          ans.isBal = false;
      }
      return ans;
      
  }
  // ------------------using static variable-------------------------------
  static boolean isbal = true;
  
  public static int isBalanced(Node node){
      if(node == null){
          return -1;
      }
      
      int lh = isBalanced(node.left);
      int rh = isBalanced(node.right);
      int gap = Math.abs(lh - rh);
      if(gap > 1){
          isbal = false;
      }
      
      return Math.max(lh,rh)+1;
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

    Node root = construct(arr);
    // bPair ress = balanced(root);
    // System.out.println(ress.isBal);
    
    isBalanced(root);
    System.out.println(isbal);
    
  }

}