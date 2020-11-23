import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5639 {

    static class Tree{
        Node root;

        void add(Node node, int data) {
            if (node == null) {
                root = new Node(data);
            } else {
                if (data > node.data) {
                    if(node.right != null) add(node.right, data);
                    else node.right = new Node(data);
                } else if(data < node.data) {
                    if(node.left != null) add(node.left, data);
                    else node.left = new Node(data);
                }
            }
        }

        void postOrder(Node node){
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            System.out.println(node.data);
        }
    }

    static class Node{
        int data;
        Node left,right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        String value = "";
        while ((value = br.readLine()) != null) {
            int data = Integer.parseInt(value);
            tree.add(tree.root, data);
        }
        tree.postOrder(tree.root);
    }
}
