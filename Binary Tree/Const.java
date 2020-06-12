import java.util.Stack;

public class Const {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static class pair{
        Node node;
        int state;

        pair(int state,Node node){
            this.node=node;
            this.state = state;
        }
    }
    public static void main(String[] args) {
        Integer[] ar = {50,25,12,null,null,30,37,null,null,null,75,62,null,70,null,null,87,null,null};
        
        Node root=new node(ar[0],null,null);

        pair rtp = new pair(root,1);

        Stack<pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while(st.size>0){
            pair top = st.peek();
            if(top.state==1){
                idx++;
                if(arr[idx]!=null){
                    top.node.left=new Node(ar[idx],null,null);
                    pair lp = new pair(top.node.left, 1);
                    st.push(lp);
                }else{
                    top.node.left=null;
                }
                top.state++;
            }else if(top.state==2){
                idx++;
                if(arr[idx]!=null){
                    top.node.right=new Node(ar[idx],null,null);
                    pair rp = new pair(top.node.left, 1);
                    st.push(rp);
                }else{
                    top.node.right=null;
                }
                top.state++;
            }else{

            }
        }

    }
    
}