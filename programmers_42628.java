package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

//이중우선순위큐
public class programmers_42628 {
	static String []operations= {"I 16","D 1"};
	public static void main(String[] args) {
		PriorityQueue<Integer> max_que=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2) return -1;
				else return 1;
			}
		});
		PriorityQueue<Integer> min_que=new PriorityQueue<>();
		
		for(String op:operations) {
			String []log=op.split(" ");
			switch(log[0]) {
			case "I":
				max_que.offer(Integer.parseInt(log[1]));
				min_que.offer(Integer.parseInt(log[1]));
				break;
			case "D":
				if(max_que.isEmpty()&&min_que.isEmpty()) break;
				if(log[1].equals("1")) {
					int value=max_que.poll();
					min_que.remove(value);
					break;
				}else if(log[1].equals("-1")) {
					int value=min_que.poll();
					max_que.remove(value);
					break;
				}
			default: break;
			}
		}
		int []answer=new int[2];
		if(max_que.size()==0)
			answer[0]=answer[1]=0;
		else {
			answer[0]=max_que.poll();
			answer[1]=min_que.poll();
		}
		System.out.println(answer[0]+", "+answer[1]);
	}

}


//import java.util.Comparator;
//import java.util.PriorityQueue;
//class Solution {
//    public int[] solution(String[] operations) {
//		PriorityQueue<Integer> max_que=new PriorityQueue<>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(o1>o2) return -1;
//				else return 1;
//			}
//		});
//		PriorityQueue<Integer> min_que=new PriorityQueue<>();
//		
//		for(String op:operations) {
//			String []log=op.split(" ");
//			switch(log[0]) {
//			case "I":
//				max_que.offer(Integer.parseInt(log[1]));
//				min_que.offer(Integer.parseInt(log[1]));
//				break;
//			case "D":
//                if(max_que.isEmpty()&&min_que.isEmpty()) break;
//				if(log[1].equals("1")) {
//					int value=max_que.poll();
//					min_que.remove(value);
//					break;
//				}else if(log[1].equals("-1")) {
//					int value=min_que.poll();
//					max_que.remove(value);
//					break;
//				}
//			default: break;
//			}
//		}
//		int []answer=new int[2];
//		if(max_que.size()==0)
//			answer[0]=answer[1]=0;
//		else {
//			answer[0]=max_que.poll();
//			answer[1]=min_que.poll();
//		}
//		return answer;
//    }
//}