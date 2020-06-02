package programmers;

import java.util.Stack;

//크래인 인형뽑기 게임
public class programmers_64061 {
	static Stack<Integer> basket=new Stack<>();
	static int index=0;
	public static void main(String[] args) {
		int board[][]= {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int moves[]= {1,5,3,5,1,2,1,4};
		int len=board[0].length;
		int m_cnt=moves.length;
		int result=0;
		for(int i=0;i<m_cnt;++i) {
			result+=crain(moves[i]-1,len,board);
		}
		System.out.println(result);
	}
	
	public static int crain(int loc,int len,int board[][]) {
		for(int i=0;i<len;i++) {
			if(board[i][loc]==0) continue;
			else {
				if(basket.empty()==false&&basket.peek()==board[i][loc]) {
					basket.pop();
					board[i][loc]=0;
					return 2;
				}
				basket.push(board[i][loc]);
				board[i][loc]=0;
				return 0;
			}
		}
		return 0;
	}
}