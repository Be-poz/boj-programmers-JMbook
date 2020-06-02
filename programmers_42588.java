package programmers;	
	//ž
	class programmers_42588 {
	    public int[] solution(int [] heights) {
	        int size=heights.length;
	        int[] answer = new int[size];
			for(int i=size-1;i>=0;--i) {
				int temp=heights[i];
				for(int j=i-1;j>=0;--j) {
					if(heights[j]>temp) {
						answer[i]=j+1;
						break;
					}
					if(j==0) answer[i]=0;
				}
			}
			return answer;
	    }
	}

