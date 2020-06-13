package programmers;

import java.util.Arrays;

//입국심사
import java.util.Arrays;
class programmers_43238 {
    public long solution(int n, int[] times) {
		Arrays.sort(times);
		long left=1;
		long right=(long)times[times.length-1]*n;
		long pivot=0;
		long sum=0;
		long answer=right;
		while(right>=left) {
			sum=0;
			pivot=(left+right)/2;
			for(int time:times) {
				sum+=pivot/time;
			}
			if(sum<n) left=pivot+1;
			else {
				if(answer>pivot) answer=pivot;
				right=pivot-1;
			}
		}
		return answer;
    }
}