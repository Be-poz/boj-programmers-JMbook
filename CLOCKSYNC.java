package programmers;

import java.util.Scanner;

public class CLOCKSYNC {
	static int INF=987654321;
	static int c;
	static int button[][]= {{0,1,2},{3,7,9,11},{4,10,14,15},{0,4,5,6,7},{6,7,8,10,12},{0,2,14,15},
							{3,14,15},{4,5,7,14,15},{1,2,3,4,5},{3,4,5,9,13}};
	static int time[]=new int[16];
	
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		c=sc.nextInt();
		for(int i=0;i<15;i++) {
			time[i]=sc.nextInt();
		}
		for(int i=0;i<c;i++) {
			System.out.println(solve(time,0));
		}
		sc.close();
	}
	
	public static boolean isSet(int time[]) {
		for(int i=0;i<15;i++) {
			if(time[i]!=12) return false;
		}
		return true;
	}
	
	public static int solve(int time[],int btn_num) {
		int ret=INF;
		if(btn_num==10) return isSet(time)?0:INF;
		for(int i=0;i<4;i++) {
			for(int j=0;j<button[btn_num].length;j++) {
				time[button[btn_num][j]]+=3*i;
				if(time[button[btn_num][j]]>12) time[button[btn_num][j]]-=12;
			}
			ret=Math.min(i+solve(time,btn_num+1),ret); 
			for(int j=0;j<button[btn_num].length;j++) {
				time[button[btn_num][j]]-=3*i;
				if(time[button[btn_num][j]]<=0) time[button[btn_num][j]]+=12;
			}
		}
		return ret;
	}
}
