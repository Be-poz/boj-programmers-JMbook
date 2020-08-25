import java.util.LinkedList;
import java.util.Queue;

public class boj_17679 {
    public static void main(String[] args) {
        String[] board={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4,5,board));
    }

    static int solution(int m, int n, String[] board) {
        int answer=0;
        char[][] boardtmp = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardtmp[i][j] = board[i].charAt(j);
            }
        }
        while (possible(boardtmp)) {
            answer+=delete(boardtmp,m,n);
        }
        return answer;
    }

    static boolean possible(char[][] board) {
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if(board[i][j]=='0') continue;
                char mark=board[i][j];
                char markRight=board[i][j+1];
                char markDown=board[i+1][j];
                char markDiagonal=board[i+1][j+1];
                if(mark==markRight&&mark==markDown&&mark==markDiagonal)
                    return true;
            }
        }
        return false;
    }

    static int delete(char[][] board,int m,int n) {
        int[][] check = new int[m][n];
        int cnt=0;
        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if(board[i][j]=='0') continue;
                char mark=board[i][j];
                char markRight=board[i][j+1];
                char markDown=board[i+1][j];
                char markDiagonal=board[i+1][j+1];
                if(mark==markRight&&mark==markDown&&mark==markDiagonal){
                    check[i][j]=1;check[i][j+1]=1;check[i+1][j]=1;check[i+1][j+1]=1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if(check[j][i]==0){
                    que.add(board[j][i]);
                }else cnt++;
            }
            int len=que.size();
            for (int j = 0; j < len;j++) {
                board[m-1-j][i]=que.poll();
            }
            for (int j = 0; j < m - len; j++) {
                board[j][i]='0';
            }
        }
        return cnt;
    }
}
