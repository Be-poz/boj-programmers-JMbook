package programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class boj9466 {
	
	static ArrayList<Integer> student=new ArrayList<>();		//�л��� ������ �л� ��ȣ ��Ƶ�
	static ArrayList<Integer> visit=new ArrayList<>();			//dfs�� ����� ���ù��� �л��� ��Ƶ�
	//static ArrayList<Integer> done=new ArrayList<>();			//�̹� �׷��� �л����� ��Ƶ�
	static int []done2=new int[100000];
	static boolean chk=false;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++) {
			int student_num=sc.nextInt();
			for(int j=1;j<student_num+1;j++) {
				int who=sc.nextInt();
				student.add(who);
			}
			System.out.println(solve());
		}
		sc.close();
	}
	
	public static int solve() {
		int student_num=student.size();
		int cnt=0;
		for(int i=0;i<student_num;i++) {
			if(i!=0&&done2[i]!=0) continue;
			chk=false;
			visit.clear();
			visit.add(i);
			dfs(student.get(i),i);					//loc�� ���� ��ġ, start�� ���� ó�� ����� ���� ��ġ
			if(chk==true) {
				cnt+=visit.size();
				done_student();
			}
		}
		return student_num-cnt;
	}
	
	public static void dfs(int loc,int start) {
		if((loc-1)==start) {
			chk=true;
			return;
		}
		if(visit.contains(loc-1)) return;
		visit.add(loc-1);
		dfs(student.get(loc-1), start);
	}
	
	public static void done_student() {
		int size=visit.size();
		for(int i=0;i<size;i++) {
			int temp=visit.get(i);
			//done.add(temp);
			done2[temp]=1;
		}
	}
}