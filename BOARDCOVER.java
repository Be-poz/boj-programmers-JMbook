package programmers;

import java.util.Scanner;

public class BOARDCOVER {
	static int coverType[][][]={
			{{0,0},{1,0},{0,1}},{{0,0},{0,1},{1,1}},
			{{0,0},{1,0},{1,1}},{{0,0},{1,0},{1,-1}}
	};
	static int c,h,w;
	static int board[][]=new int[20][20];
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("케이스의 수 : ");
		int c=scanner.nextInt();
		int result[]=new int[c];
		for(int i=0;i<c;i++) {
			System.out.println("가로 세로의 수 : ");
			h=scanner.nextInt();
			w=scanner.nextInt();
			for(int j=0;j<h;j++) {
				String color=scanner.next();
				for(int length=0;length<color.length();length++) {
					board[j][length]=color.charAt(length)=='#'?1:0;
				}
			}
			result[i]=doBoardCover(board);
		}
		for(int i=0;i<c;i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}
	
	static int doBoardCover(int board[][]) {
		int y=-1,x=-1;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(board[i][j]==0) {
					y=i;
					x=j;
					break;
				}
			}
			if(y!=-1) break;
		}
		if(y==-1) return 1;
		int ret=0;
		for(int type=0;type<4;type++) {
			if(set(board,y,x,type,1))
				ret+=doBoardCover(board);
			set(board,y,x,type,-1);
		}
		return ret;
	}
	
	static boolean set(int board[][],int y, int x, int type, int delta) {
		boolean ok=true;
		for(int i=0;i<3;i++) {
			int ny=y+coverType[type][i][0];
			int nx=x+coverType[type][i][1];
			if(ny<0||ny>=h||nx<0||nx>=w) {
				ok=false;
			}else if((board[ny][nx]+=delta)>1) {
				ok=false;
			}
		}
		return ok;
	}
	
}
