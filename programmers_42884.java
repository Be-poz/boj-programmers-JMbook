package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//단속 카메라
public class programmers_42884 {
	static class se{
		int start;
		int end;
		se(int a,int b){
			start=a;
			end=b;
		}
	}
	static int [][]routes= {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
	public static void main(String []args) {
		ArrayList<se> list=new ArrayList<>();
		Arrays.sort(routes,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) return 1;
				else return -1;
			}
		});
		list.add(new se(routes[0][0],routes[0][1]));
		for(int i=1;i<routes.length;i++) {
			boolean flag=false;
			int a=routes[i][0];
			int b=routes[i][1];
			for(int j=0;j<list.size();j++) {
				se temp=list.get(j);
				int start1=temp.start;
				int end1=temp.end;
				if(a>=start1&&a<=end1&&b>=end1) {
					list.remove(j);
					list.add(j,new se(a,end1));
					flag=true;
					break;
				}
				else if(b>=start1&&b<=end1&&a<start1) {
					list.remove(j);
					list.add(j,new se(start1,b));
					flag=true;
					break;
				}
				else if(a>=start1&&a<=end1&&b>=start1&&b<=end1) {
					list.remove(j);
					list.add(j,new se(a,b));
					flag=true;
					break;
				}
				else if(a<=start1&&b>=end1) {
					flag=true;
					break;
				}
			}
			if(flag==false) {
				list.add(new se(a,b));
			}
		}
		System.out.println(list.size());
	}
}









