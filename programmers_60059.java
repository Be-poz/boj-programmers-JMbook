package programmers;

//ÀÚ¹°¼è¿Í ¿­¼è
public class programmers_60059 {
	static int lock_len=0;
	public static void main(String [] args) {
		int lock[][]= {{1,1,1,1},{0,1,0,1},{0,0,1,1},{1,1,1,1}};
		int key[][]= {{0,1,0},{0,0,1},{0,1,1}};
		int board[][]=new int[lock.length*3][lock.length*3];
		lock_len=lock.length;
		for(int i=0;i<lock_len;i++) {
			for(int j=0;j<lock_len;j++) {
				board[i+lock_len][j+lock_len]=lock[i][j];
			}
		}
		boolean answer=false;
		for(int i=0;i<4;i++) {
			answer=solve(key,board);
			if(answer==true) break;
			rotate(key);
		}
		System.out.println(answer);
	}
	
	public static boolean solve(int [][] key, int [][] board) {
		int [][]temp=new int[board.length][board.length];
		for(int i=0;i<board.length;i++) {
			temp[i]=board[i].clone();
		}
		for(int i=lock_len-key.length+1;i<=lock_len*2-1;i++) {
			for(int j=lock_len-key.length+1;j<=lock_len*2-1;j++) {
				for(int a=0;a<key.length;a++) {
					for(int b=0;b<key.length;b++) {
						if((a+i>=lock_len&&a+i<=lock_len*2-1)&&
								(b+j>=lock_len&&b+j<=lock_len*2-1))
							temp[a+i][b+j]+=key[a][b];
					}
				}
				if(check(temp)==true) return true;
				for(int m=0;m<board.length;m++) {
					temp[m]=board[m].clone();
				}
			}
		}
		return false;
	}
	
	public static boolean check(int [][] temp) {
		for(int i=lock_len;i<=lock_len*2-1;i++) {
			for(int j=lock_len;j<=lock_len*2-1;j++) {
				if(temp[i][j]==0||temp[i][j]==2) return false;
			}
		}
		return true;
	}
	
	
	public static void rotate(int [][]key) {
		int [][]temp=new int[key.length][key.length];
		for(int i=0;i<key.length;i++) {
			for(int j=key.length-1;j>=0;j--) {
				temp[i][key.length-1-j]=key[j][i];
			}
		}
		for(int i=0;i<key.length;i++) {
			for(int j=0;j<key.length;j++) {
				key[i][j]=temp[i][j];
			}
		}
	}
}


//class Solution {
//    static int lock_len=0;
//    public boolean solution(int[][] key, int[][] lock) {
//		int board[][]=new int[lock.length*3][lock.length*3];
//		lock_len=lock.length;
//		for(int i=0;i<lock_len;i++) {
//			for(int j=0;j<lock_len;j++) {
//				board[i+lock_len][j+lock_len]=lock[i][j];
//			}
//		}
//		boolean answer=false;
//		for(int i=0;i<4;i++) {
//			answer=solve(key,board);
//			if(answer==true) break;
//			rotate(key);
//		}
//        return answer;
//    }
//	public static boolean solve(int [][] key, int [][] board) {
//		int [][]temp=new int[board.length][board.length];
//		for(int i=0;i<board.length;i++) {
//			temp[i]=board[i].clone();
//		}
//		for(int i=lock_len-key.length+1;i<=lock_len*2-1;i++) {
//			for(int j=lock_len-key.length+1;j<=lock_len*2-1;j++) {
//				for(int a=0;a<key.length;a++) {
//					for(int b=0;b<key.length;b++) {
//						if((a+i>=lock_len&&a+i<=lock_len*2-1)&&
//								(b+j>=lock_len&&b+j<=lock_len*2-1)){
//                            temp[a+i][b+j]+=key[a][b];    
//                        }
//						
//					}
//				}
//				if(check(temp)==true) return true;
//				for(int m=0;m<board.length;m++) {
//					temp[m]=board[m].clone();
//				}
//			}
//		}
//		return false;
//	}
//	
//	public static boolean check(int [][] temp) {
//		for(int i=lock_len;i<=lock_len*2-1;i++) {
//			for(int j=lock_len;j<=lock_len*2-1;j++) {
//				if(temp[i][j]==0||temp[i][j]==2) return false;
//			}
//		}
//		return true;
//	}
//	
//	
//	public static void rotate(int [][]key) {
//		int [][]temp=new int[key.length][key.length];
//		for(int i=0;i<key.length;i++) {
//			for(int j=key.length-1;j>=0;j--) {
//				temp[i][key.length-1-j]=key[j][i];
//			}
//		}
//		for(int i=0;i<key.length;i++) {
//			for(int j=0;j<key.length;j++) {
//				key[i][j]=temp[i][j];
//			}
//		}
//	}
//}