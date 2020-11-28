import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2263 {
    static int[] idxInfo;
    static int[] inOrder;
    static int[] postOrder;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        idxInfo = new int[n + 1];
        inOrder = new int[n + 1];
        postOrder = new int[n + 1];

        String[] inorder = br.readLine().split(" ");
        String[] postorder = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            inOrder[i] = Integer.parseInt(inorder[i - 1]);
            postOrder[i] = Integer.parseInt(postorder[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            idxInfo[inOrder[i]] = i;
        }

        solve(1, n, 1, n);
    }

    public static void solve(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return;
        }
        int root = postOrder[pe];
        System.out.print(root + " ");
        int idx = idxInfo[root];
        int diff = idx - is;
        solve(is, idx - 1, ps, ps + diff - 1);
        solve(idx + 1, ie, ps + diff, pe - 1);
    }
}
