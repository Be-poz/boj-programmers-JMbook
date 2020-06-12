package programmers;

//Á¤¼ö »ï°¢Çü
public class programmers_43105 {
	static int [][]triangle= {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
	public static void main(String []args) {
		int [][]memo=new int[triangle.length][triangle.length];
		memo[0][0]=triangle[0][0];
		for(int i=1;i<triangle.length;i++) {
			for(int j=0;j<i+1;j++) {
				if(j==0) {
					memo[i][0]=memo[i-1][0]+triangle[i][0];
					continue;
				}
				if(j==i) {
					memo[i][i]=memo[i-1][i-1]+triangle[i][i];
					continue;
				}
				memo[i][j]=Math.max(memo[i-1][j-1],memo[i-1][j])+triangle[i][j];
			}
		}
		int answer=0;
		for(int i=0;i<triangle.length;i++) {
			answer=Math.max(answer,memo[triangle.length-1][i]);
		}
		System.out.println(answer);
	}
}
