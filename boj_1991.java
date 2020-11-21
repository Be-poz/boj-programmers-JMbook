import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1991 {

    static class Tree{
        Node root;

        public void add(char element, char leftElement, char rightElement) {
            if (root == null) {
                if (element != '.') root = new Node(element);
                if (leftElement != '.') root.left = new Node(leftElement);
                if (rightElement != '.') root.right = new Node(rightElement);
            } else search(root, element, leftElement, rightElement);
        }

        private void search(Node root, char element, char leftElement, char rightElement) {
            if(root == null) return;
            else if (root.element == element) {
                if (leftElement != '.') root.left = new Node(leftElement);
                if (rightElement != '.') root.right = new Node(rightElement);
            } else {
                search(root.left, element, leftElement, rightElement);
                search(root.right, element, leftElement, rightElement);
            }
        }

        public void preorder(Node root) {
            System.out.print(root.element);
            if (root.left != null) preorder(root.left);
            if (root.right != null) preorder(root.right);
        }

        public void inorder(Node root) {
            if (root.left != null) inorder(root.left);
            System.out.print(root.element);
            if (root.right != null) inorder(root.right);
        }

        public void postorder(Node root) {
            if (root.left != null) postorder(root.left);
            if (root.right != null) postorder(root.right);
            System.out.print(root.element);
        }
    }

    static class Node{
        char element;
        Node left, right;
        Node(char element){
            this.element = element;
        }
    }

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();
        valueInsert(tree);
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }

    private static void valueInsert(Tree tree) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            tree.add(tokens[0].charAt(0), tokens[1].charAt(0), tokens[2].charAt(0));
        }
        br.close();
    }
}
