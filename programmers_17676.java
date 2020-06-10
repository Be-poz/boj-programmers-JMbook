package programmers;

import java.util.ArrayList;
//추석 트래픽
public class programmers_17676 {
	
	static class xy{
		int start;
		int end;
		xy(int x, int y){
			start=x;
			end=y;
		}
	}
	
	static String lines[]= {"2016-09-15 20:59:57.421 0.351s","2016-09-15 20:59:58.233 1.181s","2016-09-15 20:59:58.299 0.8s","2016-09-15 20:59:58.688 1.041s","2016-09-15 20:59:59.591 1.412s","2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s","2016-09-15 21:00:00.748 2.31s","2016-09-15 21:00:00.966 0.381s","2016-09-15 21:00:02.066 2.62s"};
	public static void main(String[] args) {
		ArrayList<xy> list=new ArrayList<>();
		calculate_Time(list,lines);
		int answer=solve(list);
		System.out.println(answer);
	}
	
	public static void calculate_Time(ArrayList<xy> list,String lines[]) {
		for(int i=0;i<lines.length;i++) {
			String log[]=lines[i].split(" ");
			String time[]=log[1].split(":");
			String processing_Time=log[2].substring(0,log[2].length()-1);
			double process_Time=Double.parseDouble(processing_Time)*1000;
			double end_Time=Double.parseDouble(time[0])*3600*1000+Double.parseDouble(time[1])*60*1000
							+Double.parseDouble(time[2])*1000;
			double start_Time=end_Time-process_Time+1;
			list.add(new xy((int)start_Time,(int)end_Time));
		}
	}
	
	public static int solve(ArrayList<xy> list) {
		int max=0;
		for(int i=0;i<list.size();i++) {
			xy temp=list.get(i);
			int st1=temp.start-999;
			int et1=temp.start;
			int st2=temp.end;
			int et2=temp.end+999;
			int cnt1=0;
			int cnt2=0;
			for(int j=0;j<list.size();j++) {
				xy temp2=list.get(j);
				int start_time=temp2.start;
				int end_time=temp2.end;
				if((st1>=start_time&&st1<=end_time)||(et1>=start_time&&et1<=end_time)||(st1<=start_time&&et1>=end_time)) cnt1++;
				if((st2>=start_time&&st2<=end_time)||(et2>=start_time&&et2<=end_time)||(st2<=start_time&&et2>=end_time)) cnt2++;
			}
			max=Math.max(max,Math.max(cnt1,cnt2));
		}
		return max;
	}
	
}
