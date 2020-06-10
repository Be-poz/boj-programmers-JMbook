package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
//야근 지수
public class programmers_12927 {
	static int [] works= {2,1,2};
	static int n=1;
	public static void main(String[] args) {
		PriorityQueue<Integer> que=new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0;i<works.length;i++) {
			que.offer(works[i]);
		}
		while(n>0) {
			int num=que.poll();
			if(num==0) {
				System.out.println(0);
				return;
			}
			que.offer(num-1);
			n--;
		}
		int sum=0;
		int size=que.size();
		for(int i=0;i<size;i++) {
			int num=que.poll();
			sum+=Math.pow(num, 2);
		}
		System.out.println(sum);
		return;
	}
}


//import java.util.Comparator;
//import java.util.PriorityQueue;
//class Solution {
//    public long solution(int n, int[] works) {
//		PriorityQueue<Integer> que=new PriorityQueue<>(Comparator.reverseOrder());
//		for(int i=0;i<works.length;i++) {
//			que.offer(works[i]);
//		}
//		for(int i=0;i<n;i++){
//            int num=que.poll();
//            if(num==0) return 0;
//            que.offer(num-1);
//        }
//        long sum=0;
//		int size=que.size();
//		for(int i=0;i<size;i++) {
//			sum+=Math.pow(que.poll(), 2);
//		}
//		return sum;
//    }
//}
