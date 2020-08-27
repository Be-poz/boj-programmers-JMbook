import java.util.*;

public class boj_42894 {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5}, {1, 2, 2, 2, 3, 3, 0, 0, 0, 5}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}};
        System.out.println(solution(board));
    }

    static int solution(int[][] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int color = board[i][j];
                if(color==0) continue;

                if (a(board, i, j)) {
                    if (drop(i + 1, j + 1,board) && drop(i + 1, j + 2,board)) {
                        board[i][j]=0;board[i+1][j]=0;board[i+1][j+1]=0;board[i+1][j+2]=0;
                        answer++;
                        j=-1;
                    }
                }
                else if (b(board, i, j)) {
                    if (drop(i+2,j-1,board)) {
                        board[i][j]=0;board[i+1][j]=0;board[i+2][j]=0;board[i+2][j-1]=0;
                        answer++;
                        j=-1;                    }
                }
                else if (c(board, i, j)) {
                    if (drop(i + 2, j + 1,board)) {
                        board[i][j]=0;board[i+1][j]=0;board[i+2][j]=0;board[i+2][j+1]=0;
                        answer++;
                        j=-1;
                    }
                }
                else if (d(board, i, j)) {
                    if (drop(i + 1, j - 2,board)&&drop(i+1,j-1,board)) {
                        board[i][j]=0;board[i+1][j]=0;board[i+1][j-1]=0;board[i+1][j-2]=0;
                        answer++;
                        j=-1;
                    }
                }
                else if (e(board, i, j)) {
                    if (drop(i + 1, j + 1,board) && drop(i + 1, j - 1,board)) {
                        board[i][j]=0;board[i+1][j]=0;board[i+1][j-1]=0;board[i+1][j+1]=0;
                        answer++;
                        j=-1;
                    }
                }
            }
        }
        return answer;
    }


    static boolean drop(int x, int y, int[][] board) {
        for (int i = 0; i < x; i++) {
            if(board[i][y]==0) continue;
            if(board[i][y]!=board[x][y]) return false;
        }
        return true;
    }


    static boolean a(int[][] board, int x, int y) {
        int color = board[x][y];
        return y + 2 < board.length && x + 1 < board.length && board[x + 1][y] == color && board[x + 1][y + 1] == color && board[x + 1][y + 2] == color
                && board[x][y + 1] == 0 && board[x][y + 2] == 0;
    }


    static boolean b(int[][] board, int x, int y) {
        int color=board[x][y];
        return x + 2 < board.length && y - 1 >= 0 && board[x + 1][y] == color && board[x + 2][y] == color && board[x + 2][y - 1] == color
                && board[x + 1][y - 1] == 0 && board[x][y - 1] == 0;
    }


    static boolean c(int[][] board, int x, int y) {
        int color=board[x][y];
        return x + 2 < board.length && y + 1 < board.length && board[x + 1][y] == color && board[x + 2][y] == color && board[x + 2][y + 1] == color
                && board[x][y + 1] == 0 && board[x + 1][y + 1] == 0;
    }


    static boolean d(int[][] board, int x, int y) {
        int color=board[x][y];
        return x + 1 < board.length && y - 2 >= 0 && board[x + 1][y] == color && board[x + 1][y - 1] == color && board[x + 1][y - 2] == color
                && board[x][y - 1] == 0 && board[x][y - 2] == 0;
    }


    static boolean e(int[][] board, int x, int y) {
        int color=board[x][y];
        return x + 1 < board.length && y - 1 >= 0 && y + 1 < board.length && board[x + 1][y] == color && board[x + 1][y - 1] == color && board[x + 1][y + 1] == color
                && board[x][y - 1] == 0 && board[x][y + 1] == 0;
    }
}
