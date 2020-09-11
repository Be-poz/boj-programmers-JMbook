import java.util.Scanner;
import java.util.TreeMap;

public class boj_14725 {
    static Scanner sc = new Scanner(System.in);

    static class TrieNode{
        TreeMap<String, TrieNode> childNodes = new TreeMap<>();
    }

    static class Trie{
        TrieNode rootNode;
        Trie(){
            rootNode = new TrieNode();
        }

        void insert(String[] words) {
            TrieNode thisNode = rootNode;
            for (String word : words) {
                thisNode = thisNode.childNodes.computeIfAbsent(word, c -> new TrieNode());
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        Trie trie = new Trie();
        while (n-- > 0) {
            int m = sc.nextInt();
            String[] tmp=sc.nextLine().split(" ");
            String[] tokens = new String[tmp.length - 1];
            if (tmp.length - 1 >= 0) System.arraycopy(tmp, 1, tokens, 0, tmp.length - 1);
            trie.insert(tokens);
        }

        TrieNode currentNode = trie.rootNode;
        for (String key:currentNode.childNodes.keySet()) {
            System.out.println(key);
            show(currentNode.childNodes.get(key), 2);
        }
    }

    public static void show(TrieNode currentNode, int depth) {
        for (String key : currentNode.childNodes.keySet()) {
            for (int i = 1; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);
            show(currentNode.childNodes.get(key), depth + 1);
        }
    }
}
