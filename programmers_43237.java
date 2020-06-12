package programmers;

import java.util.Arrays;
//¿¹»ê
class programmers_43237 {
	static class xy{
		long sum;
		int pivot;
		xy(long sum,int pivot){
			this.sum=sum;
			this.pivot=pivot;
		}
	}
    public int solution(int[] budgets, int m) {
		Arrays.sort(budgets);
		
		int left=0;
		int right=budgets[budgets.length-1];
		int pivot=0;
		while(right>=left) {
			long sum=0;
			pivot=(left+right)/2;
			for(int i=0;i<budgets.length;i++) {
				if(budgets[i]>pivot) sum+=pivot;
				else sum+=budgets[i];
			}
			if(sum==m) return pivot;
			else if(sum>m) right=pivot-1;
			else if(sum<m) left=pivot+1;
		}
		return right;
    }
}
