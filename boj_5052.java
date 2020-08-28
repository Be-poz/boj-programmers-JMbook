import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj_5052 {

    static class Trie{
        TrieNode rootNode;

        Trie(){
            rootNode=new TrieNode();
        }

        void insert(String word) {
            TrieNode currentNode=rootNode;
            for (char c : word.toCharArray()) {
                if (!currentNode.getChildNode().containsKey(c)) {
                    currentNode=currentNode.addChild(c);
                } else {
                    currentNode=currentNode.getChildNode().get(c);
                }
            }
            currentNode.setIsLast(true);
        }

        int isConsistence(String word) {
            TrieNode currentNode = rootNode;
            for (char c : word.toCharArray()) {
                if (currentNode.getChildNode().containsKey(c))
                    currentNode = currentNode.getChildNode().get(c);
            }
            if(currentNode.getChildNode().size()!=0) return -1;
            else return 0;
        }

    }

    static class TrieNode{
        private boolean isLast;
        private Map<Character, TrieNode> childNode = new HashMap<>();

        void setIsLast(Boolean isLast) {
            this.isLast=isLast;
        }

        TrieNode addChild(char c) {
            TrieNode child=new TrieNode();
            getChildNode().put(c,child);
            return child;
        }

        Map<Character,TrieNode> getChildNode(){
            return this.childNode;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int v = sc.nextInt();
            boolean flag=true;
            String[] tele=new String[v];
            Trie trie=new Trie();
            for (int i = 0; i < v; i++) {
                tele[i]=sc.next();
                trie.insert(tele[i]);
            }
            for (int i = 0; i < v; i++) {
                if (trie.isConsistence(tele[i]) != 0) {
                    flag=false;
                    break;
                }
            }
            if(!flag)
                System.out.println("NO");
            else{
                System.out.println("YES");
            }
            n--;
        }
    }
}
