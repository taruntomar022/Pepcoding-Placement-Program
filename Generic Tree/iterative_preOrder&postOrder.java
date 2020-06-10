import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }


    private static class Pair{
        Node node;
        int state;
        Pair(Node n, int s){
            this.node = n;
            this.state = s;
        }
    }
  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  static ArrayList<Node> preOrder;
  static ArrayList<Node> postOrder;

  public static void IterativePreandPostOrder(Node node) {
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(node,-1));
    while(st.size()>0){
        Pair top = st.peek();
        Node topNode = top.node;
        int topState = top.state;
        if(top.state == -1){
            preOrder.add(topNode);
            top.state++;
        }
        else if(top.state>=0 && top.state < topNode.children.size()){
            st.push(new Pair(topNode.children.get(topState),-1));
            top.state++;
        }
        else if(topState == topNode.children.size()){ 
            Pair post = st.pop();
            postOrder.add(post.node);
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    preOrder = new ArrayList<>();
    postOrder = new ArrayList<>();
    IterativePreandPostOrder(root);
    for(int i=0;i<preOrder.size();i++){
        System.out.print(preOrder.get(i).data+" ");
    }
    System.out.println();
    for(int i=0;i<postOrder.size();i++){
        System.out.print(postOrder.get(i).data+" ");
    }
  }

}