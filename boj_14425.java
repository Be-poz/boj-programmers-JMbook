import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj_14425 {
    static class Trie{
        private final TrieNode rootNode;

        Trie(){
            rootNode=new TrieNode();
        }

        void insert(String word) {
            TrieNode currentNode = rootNode;
            for (char c : word.toCharArray()) {
                if (currentNode.getChildNode().containsKey(c)) {
                    currentNode = currentNode.getChildNode().get(c);
                } else {
                    currentNode.getChildNode().put(c,new TrieNode());
                    currentNode=currentNode.getChildNode().get(c);
                }
            }
            currentNode.setLastChar();
        }

        boolean contain(String word) {
            TrieNode currentNode=rootNode;
            for (char c : word.toCharArray()) {
                if (currentNode.getChildNode().get(c) != null) {
                    currentNode=currentNode.getChildNode().get(c);
                }else return false;
            }
            return currentNode.isLastChar();
        }
    }

    static class TrieNode{
        private boolean lastChar;
        private final Map<Character, TrieNode> childNode = new HashMap<>();

        boolean isLastChar(){
            return lastChar;
        }

        void setLastChar(){
            this.lastChar = true;
        }

        Map<Character,TrieNode> getChildNode(){
            return childNode;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer=0;
        Trie trie=new Trie();
        int n=sc.nextInt();
        int m=sc.nextInt();
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            trie.insert(tmp);
        }
        for (int i = 0; i < m; i++)
            if(trie.contain(sc.next())) answer++;
        System.out.println(answer);
    }
}
