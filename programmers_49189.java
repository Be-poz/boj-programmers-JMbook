package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//가장 먼 노드
public class programmers_49189 {
	static int [][]vertex= {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
	static int n=6;
	public static void main(String[] args) {
		Queue<Integer> que=new LinkedList<>();
		boolean ver[][]=new boolean[n+1][n+1];
		for(int i=0;i<vertex.length;i++) {
			int a=vertex[i][0];
			int b=vertex[i][1];
			ver[a][b]=true;ver[b][a]=true;
		}
		int distance[]=new int[n+1];
		distance[0]=-1;
		distance[1]=-1;
		que.add(1);
		int idx=1;
		while(!que.isEmpty()) {
			int size=que.size();
			for(int m=0;m<size;m++){
				int x=que.poll();
				for(int i=1;i<ver[x].length;i++) {
					if(ver[x][i]==true&&distance[i]==0) {
						distance[i]=idx;
						que.add(i);
					}
				}
			}
			idx++;
		}
		Arrays.sort(distance);
		int cnt=0;
		for(int i=0;i<distance.length;i++) {
			if(distance[i]==distance[distance.length-1]) cnt++;
		}
		System.out.println(cnt);
	}
}


//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//class Solution {
//    public int solution(int n, int[][] vertex) {
//		Queue<Integer> que=new LinkedList<>();
//		boolean ver[][]=new boolean[n+1][n+1];
//		for(int i=0;i<vertex.length;i++) {
//			int a=vertex[i][0];
//			int b=vertex[i][1];
//			ver[a][b]=true;ver[b][a]=true;
//		}
//		int distance[]=new int[n+1];
//		distance[0]=-1;
//		distance[1]=-1;
//		que.add(1);
//		int idx=1;
//		while(!que.isEmpty()) {
//			int size=que.size();
//			for(int m=0;m<size;m++){
//				int x=que.poll();
//				for(int i=1;i<ver[x].length;i++) {
//					if(ver[x][i]==true&&distance[i]==0) {
//						distance[i]=idx;
//						que.add(i);
//					}
//				}
//			}
//			idx++;
//		}
//		Arrays.sort(distance);
//		int cnt=0;
//		for(int i=0;i<distance.length;i++) {
//			if(distance[i]==distance[distance.length-1]) cnt++;
//		}
//		return cnt;
//    }
//}