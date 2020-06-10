package programmers;

import java.util.Arrays;
import java.util.Comparator;

//º∂ ø¨∞·«œ±‚
public class programmers_42861 {
	static int n=4;
	static int costs[][]= {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
	static int parent[];
	public static void main(String[] args) {
		int answer=0;
		parent=new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=-1;
			System.out.println(parent[i]);
		}
		Arrays.sort(costs,new Comparator<int []>() {

			@Override
			public int compare(int [] o1, int [] o2) {
				if(o1[2]>o2[2]) return 1;
				else return -1;
			}
		});
		for(int i=0;i<costs.length;i++) {
			int x=costs[i][0];
			int y=costs[i][1];
			if(findParent(x, y)==0) {
				union(x, y);
				answer+=costs[i][2];
			}
			else continue;
		}
		System.out.println(answer);
	}
	
	public static int find(int x) {
		if(parent[x]<0) return x;
		else {
			int y=find(parent[x]);
			parent[x]=y;
			return parent[x]=find(parent[x]);
		}
	}
	
	public static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y) return;
		if(parent[x]<parent[y]) {
			parent[x]+=parent[y];
			parent[y]=x;
		}else {
			parent[y]+=parent[x];
			parent[x]=y;
		}
	}
	
	public static int findParent(int a, int b) {
		a=find(a);
		b=find(b);
		if(a==b) return 1;
		else return 0;
	}

}


//import java.util.Arrays;
//import java.util.Comparator;
//
//class Solution {
//    static int parent[];
//    public int solution(int n, int[][] costs) {
//        int answer = 0;
//		parent=new int[n];
//		for(int i=0;i<n;i++) {
//			parent[i]=-1;
//		}
//		Arrays.sort(costs,new Comparator<int []>() {
//
//			@Override
//			public int compare(int [] o1, int [] o2) {
//				if(o1[2]>o2[2]) return 1;
//				else return -1;
//			}
//		});
//		for(int i=0;i<costs.length;i++) {
//			int x=costs[i][0];
//			int y=costs[i][1];
//			if(findParent(x, y)==0) {
//				union(x, y);
//				answer+=costs[i][2];
//			}
//			else continue;
//		}
//        return answer;
//    }
//    
//    public static int find(int x) {
//		if(parent[x]<0) return x;
//		else {
//			int y=find(parent[x]);
//			parent[x]=y;
//			return parent[x]=find(parent[x]);
//		}
//	}
//	
//	public static void union(int x,int y) {
//		x=find(x);
//		y=find(y);
//		if(x==y) return;
//		if(parent[x]<parent[y]) {
//			parent[x]+=parent[y];
//			parent[y]=x;
//		}else {
//			parent[y]+=parent[x];
//			parent[x]=y;
//		}
//	}
//	
//	public static int findParent(int a, int b) {
//		a=find(a);
//		b=find(b);
//		if(a==b) return 1;
//		else return 0;
//	}
//}