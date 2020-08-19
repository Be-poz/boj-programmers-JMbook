import java.util.Scanner;

public class boj_12100 {
    static int n=0;
    static int[][] board;
    static int maxValue=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        board=new int[n][n];
        int []order=new int[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=sc.nextInt();
            }
        }
        tracking(board,order,0);
        System.out.println(maxValue);
    }

    static void tracking(int[][] board,int[] order, int r) {
        if (r == 5) {
            int [][]temp=new int[n][n];
            for (int i = 0; i < n; i++) {
                temp[i]=board[i].clone();
            }
            for (int i = 0; i < 5; i++) {
                if(order[i]==0) right(temp);
                if(order[i]==1) left(temp);
                if(order[i]==2) up(temp);
                if(order[i]==3) down(temp);
            }
            maxValue=Math.max(maxValue,whatsmax(temp));
            return;
        }
        for (int i = 0; i < 4; i++) {
            order[r]=i;
            tracking(board,order,r+1);
        }
    }

    static void right(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int idx=0;
            int stack=0;
            int prev_value=0;
            int []arr=new int[board.length];
            for (int j = board.length - 1; j >= 0; j--) {
                if(board[i][j]!=0) arr[idx++]=board[i][j];
            }
            idx=board.length-1;
            for (int j = 0; j < arr.length; j++) {
                if(stack==0){
                    if(j==arr.length-1){
                        board[i][idx--]=arr[j];
                        break;
                    }
                    prev_value=arr[j];
                    stack=1;
                }
                else if(stack==1){
                    if(prev_value==arr[j]){
                        board[i][idx--]=prev_value*2;
                        stack=0;
                    }else{
                        board[i][idx--]=prev_value;
                        if(j==arr.length-1){
                            board[i][idx--]=arr[j];
                        }
                        prev_value=arr[j];
                    }
                }
            }
            for(int j=0;j<=idx;j++)
                board[i][j]=0;
        }
    }

    static void left(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int idx=0;
            int stack=0;
            int prev_value=0;
            int []arr=new int[board.length];
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]!=0) arr[idx++]=board[i][j];
            }
            idx=0;
            for (int j = 0; j < arr.length; j++) {
                if(stack==0){
                    if(j==arr.length-1){
                        board[i][idx++]=arr[j];
                        break;
                    }
                    prev_value=arr[j];
                    stack=1;
                }
                else if(stack==1){
                    if(prev_value==arr[j]){
                        board[i][idx++]=prev_value*2;
                        stack=0;
                    }else{
                        board[i][idx++]=prev_value;
                        if(j==arr.length-1){
                            board[i][idx++]=arr[j];
                            break;
                        }
                        prev_value=arr[j];
                    }
                }
            }
            for(int j=board.length-1;j>=idx;j--)
                board[i][j]=0;
        }
    }

    static void down(int[][] board) {
        for (int j = 0; j < board.length; j++) {
            int idx=0;
            int stack=0;
            int prev_value=0;
            int []arr=new int[board.length];
            for (int i = board.length - 1; i >= 0; i--) {
                if(board[i][j]!=0) arr[idx++]=board[i][j];
            }
            idx=board.length-1;
            for (int i = 0; i < arr.length; i++) {
                if(stack==0){
                    if(i==arr.length-1){
                        board[idx--][j]=arr[i];
                        break;
                    }
                    prev_value=arr[i];
                    stack=1;
                }
                else if(stack==1){
                    if(prev_value==arr[i]){
                        board[idx--][j]=prev_value*2;
                        stack=0;
                    }else{
                        board[idx--][j]=prev_value;
                        if(i==arr.length-1){
                            board[idx--][j]=arr[i];
                            break;
                        }
                        prev_value=arr[i];
                    }
                }
            }
            for(int i=0;i<=idx;i++)
                board[i][j]=0;
        }
    }

    static void up(int[][] board) {
        for (int j = 0; j < board.length; j++) {
            int idx=0;
            int stack=0;
            int prev_value=0;
            int []arr=new int[board.length];
            for (int i = 0; i <board.length; i++) {
                if(board[i][j]!=0) arr[idx++]=board[i][j];
            }
            idx=0;
            for (int i = 0; i < arr.length; i++) {
                if(stack==0){
                    if(i==arr.length-1){
                        board[idx++][j]=arr[i];
                        break;
                    }
                    prev_value=arr[i];
                    stack=1;
                }
                else if(stack==1){
                    if(prev_value==arr[i]){
                        board[idx++][j]=prev_value*2;
                        stack=0;
                    }else{
                        board[idx++][j]=prev_value;
                        if(i==arr.length-1){
                            board[idx++][j]=arr[i];
                            break;
                        }
                        prev_value=arr[i];
                    }
                }
            }
            for(int i=board.length-1;i>=idx;i--)
                board[i][j]=0;
        }
    }

    static int whatsmax(int[][] temp) {
        int tmp=0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                tmp=Math.max(tmp,temp[i][j]);
            }
        }
        return tmp;
    }
}
