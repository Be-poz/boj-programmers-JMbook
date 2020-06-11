package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//디스크 컨트롤러
public class programmers_42627 {
	static class xy{
		int start;
		int time;
		xy(int start,int time){
			this.start=start;
			this.time=time;
		}
	}
	
	static int [][]jobs= {{1,9},{1,4},{1,5},{1,7},{1,3}};
	public static void main(String [] args) {
		int answer=0;
		Arrays.sort(jobs,new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) return 1;
				else if(o1[0]<o2[0]) return -1;
				else if(o1[0]==o2[0]) {
					if(o1[1]>o2[1]) return 1;
					else return -1;
				}
				return 0;
			}
		});
		ArrayList<xy> list=new ArrayList<>();
		for(int i=0;i<jobs.length;i++) {
			list.add(new xy(jobs[i][0],jobs[i][1]));
		}
		
		int now=0;
		while(list.size()!=0) {
			PriorityQueue<xy> que=new PriorityQueue<>(new Comparator<xy>() {
				@Override
				public int compare(xy o1, xy o2) {
					int time1=o1.time;
					int time2=o2.time;
					if(time1>time2) return 1;
					else if(time1<time2) return -1;
					else return 0;
				}
			});
			for(int i=0;i<list.size();i++) {
				xy temp=list.get(i);
				if(temp.start<=now) {
					que.offer(new xy(temp.start,temp.time));
				}
			}
			if(que.size()==0) {
				que.offer(new xy(list.get(0).start,list.get(0).time));
				now=list.get(0).start;
			}
			xy temp=que.poll();
			now+=temp.time;
			answer+=now-temp.start;
			for(int i=0;i<list.size();i++) {
				xy aa=list.get(i);
				if(aa.start==temp.start&&aa.time==temp.time) {
					list.remove(i);
					break;
				}
			}
		}
		System.out.println(answer/jobs.length);
	}
}


//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
//class Solution {
//	static class xy{
//		int start;
//		int time;
//		xy(int start,int time){
//			this.start=start;
//			this.time=time;
//		}
//	}
//    public int solution(int[][] jobs) {
//		Arrays.sort(jobs,new Comparator<int []>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if(o1[0]>o2[0]) return 1;
//				else if(o1[0]<o2[0]) return -1;
//				else if(o1[0]==o2[0]) {
//					if(o1[1]>o2[1]) return 1;
//					else return -1;
//				}
//				return 0;
//			}
//		});
//		int answer=0;
//		ArrayList<xy> list=new ArrayList<>();
//		for(int i=0;i<jobs.length;i++) {
//			list.add(new xy(jobs[i][0],jobs[i][1]));
//		}
//		
//		int now=0;
//		while(list.size()!=0) {
//			PriorityQueue<xy> que=new PriorityQueue<>(new Comparator<xy>() {
//				@Override
//				public int compare(xy o1, xy o2) {
//					int time1=o1.time;
//					int time2=o2.time;
//					if(time1>time2) return 1;
//					else if(time1<time2) return -1;
//					else return 0;
//				}
//			});
//			for(int i=0;i<list.size();i++) {
//				xy temp=list.get(i);
//				if(temp.start<=now) {
//					que.offer(new xy(temp.start,temp.time));
//				}
//			}
//			if(que.size()==0) {
//				que.offer(new xy(list.get(0).start,list.get(0).time));
//				now=list.get(0).start;
//			}
//			xy temp=que.poll();
//			now+=temp.time;
//			answer+=now-temp.start;
//			for(int i=0;i<list.size();i++) {
//				xy aa=list.get(i);
//				if(aa.start==temp.start&&aa.time==temp.time) {
//					list.remove(i);
//					break;
//				}
//			}
//		}
//		return answer/jobs.length;
//    }
//}