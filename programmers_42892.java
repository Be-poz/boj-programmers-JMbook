import java.util.*;

public class programmers_42892 {
    static class Tree{
        Tree right;
        Tree left;
        int x=0;
        int y=0;
        int index=0;
        Tree(int x,int y,int index){
            this.x=x;
            this.y=y;
            this.index=index;
        }
    }

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        solution(nodeinfo);
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer =new int[nodeinfo.length][nodeinfo.length];
        int index=0;
        Tree[] trees= new Tree[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            trees[i]=new Tree(nodeinfo[i][0],nodeinfo[i][1],++index);
        }
        Arrays.sort(trees, new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                int x1=o1.x;int x2=o2.x;int y1=o1.y;int y2=o2.y;
                if(y1<y2) return 1;
                else if(y1>y2) return -1;
                else if(y1==y2){
                    if(x1>x2) return 1;
                    else return -1;
                }
                return 0;
            }
        });
        Tree root=trees[0];
        for(int i=1;i<trees.length;i++){
            connect_Tree(root,trees[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root,list);
        for (int i = 0; i < list.size(); i++) {
            answer[0][i]=list.get(i);
        }
        System.out.println();
        list.clear();
        postOrder(root,list);
        for(int i=0;i<list.size();i++){
            answer[1][i]=list.get(i);
        }

        return answer;
    }
    public static void connect_Tree(Tree root,Tree node){
        if(root.x>node.x){
            if(root.left!=null){
                connect_Tree(root.left,node);
            }else{
                root.left=node;
            }
        }else{
            if (root.right != null) {
                connect_Tree(root.right,node);
            }else{
                root.right=node;
            }
        }
    }

    public static void preOrder(Tree root, ArrayList<Integer> list) {
        list.add(root.index);
        if (root.left != null) {
            preOrder(root.left,list);
        }
        if (root.right != null) {
            preOrder(root.right,list);
        }
    }

    public static void postOrder(Tree root, ArrayList<Integer> list) {
        if (root.left != null) {
            postOrder(root.left,list);
        }
        if (root.right != null) {
            postOrder(root.right,list);
        }
        list.add(root.index);
    }

}
