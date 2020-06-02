package programmers;

import java.util.ArrayList;
import java.util.Comparator;

//½ÇÆÐÀ²
public class programmers_42889 {
	static int stages[]= {1,2,3,4,5,6,7};
	static int n=8;
	
	static class ab{
		int idx;
		double por;
		ab(double por,int idx){
			this.idx=idx;
			this.por=por;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ab> list=new ArrayList<>();
		int result[]=new int[n+1];
		int []lvl=new int[n+1];
		int answer[]=new int[n];
		for(int i=0;i<stages.length;++i) {
			lvl[stages[i]-1]++;
		}
		result[0]=stages.length;
		for(int i=1;i<n;++i) {
			result[i]=result[i-1]-lvl[i-1];
		}
		for(int i=0;i<n;i++) {
			double por;
			if(lvl[i]==0) por=0;
			else por=(double)lvl[i]/(double)result[i];
			list.add(new ab(por, i));
		}
		list.sort(new Comparator<ab>() {

			@Override
			public int compare(ab o1, ab o2) {
				double por1=o1.por;
				double por2=o2.por;
				if(por1==por2) return 0;
				else if(por1<por2) return 1;
				else if(por1>por2) return -1;
				return 0;
			}
			
		});
		for(int i=0;i<n;++i) {
			answer[i]=list.get(i).idx+1;
			System.out.println(answer[i]);
		}
	}

}
