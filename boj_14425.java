import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj_14425 {
    static int n, m;
    static class TrieNode{
        HashMap<Character, TrieNode> childNodes = new HashMap<>();
        boolean last;
    }
    static class Trie{
        TrieNode rootNode;
        Trie(){
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode currentNode = rootNode;
            for (Character c : word.toCharArray()) {
                currentNode = currentNode.childNodes.computeIfAbsent(c, o -> new TrieNode());
            }
            currentNode.last = true;
        }

        boolean contains(String word) {
            TrieNode currentNode = rootNode;
            for (Character c : word.toCharArray()) {
                currentNode = currentNode.childNodes.get(c);
                if(currentNode==null) return false;
            }
            return currentNode.last;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        int answer = 0;
        String[] input = bf.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String tmp = bf.readLine();
            trie.insert(tmp);
        }
        for (int i = 0; i < m; i++) {
            String tmp = bf.readLine();
            if (trie.contains(tmp))
                answer++;
        }
        System.out.println(answer);
    }
}