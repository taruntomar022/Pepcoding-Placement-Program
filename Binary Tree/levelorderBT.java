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

  // using count 
  public static void levelOrder1(Node node){
      Queue<Node> que = new ArrayDeque<>();
      if(node != null){
          que.add(node);
      }
      
      while(que.size()>0){
          int count = que.size();
          for(int i=0;i<count ;i++){
              // remove
              node = que.remove();
              // print
              System.out.print(node.data + " ");
              // add
              if(node.left != null){
                  que.add(node.left);
              }
              if(node.right != null){
                  que.add(node.right);
              }
          }
          System.out.println();
      }
  }

// using main queue and child queue approach
    public static void levelOrder2(Node node){
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();
        mainQ.add(node);
        while(mainQ.size()>0){
            // remove
            node = mainQ.remove();
            // print
            System.out.print(node.data +" ");
            // add
            if(node.left != null){
                childQ.add(node.left);
            }
            if(node.right != null){
                childQ.add(node.right);
            }
            if(mainQ.size()==0){
                System.out.println();
                mainQ = childQ;
                childQ = new ArrayDeque<>();
            }
        }
    }
    
    // using null pointer
    public static void levelOrder3(Node node){
        Queue<Node> que = new ArrayDeque<>();
        if(node != null){
            que.add(node);
            que.add(new Node(Integer.MIN_VALUE,null,null));
        }
        while(que.size()>0){
            // remove
            node = que.remove();
            // print
            if(node.data == Integer.MIN_VALUE){
                System.out.println();
                if(que.size()>0){
                    que.add(new Node(Integer.MIN_VALUE,null,null));
                }
            }
            else{
                System.out.print(node.data + " ");
                // add
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
        }
    }

    public static void levelOrder4(Node node){
        Queue<Pair> que = new ArrayDeque<>();
            int level = 1;
        if(node != null){
            que.add(new Pair(node,1));
        }
        while(que.size()>0){
            // remove 
            Pair pb = que.remove();
            if(pb.state > level){
                System.out.println();
                level = pb.state;
            }
            System.out.print(pb.node.data+" ");
            // add
            if(pb.node.left != null){
                que.add(new Pair(pb.node.left, level + 1));
            }
            if(pb.node.right != null){
                que.add(new Pair(pb.node.right, level + 1));
            }
        }
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
    levelOrder4(root);
  }

}