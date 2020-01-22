/*#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
int cnt = 0;
int sum = 0;
int ttarget;
int vsize;

void dfs(int start,vector<int> v[20]) {
	for (int j = 0; j < 2; j++) {
		sum += v[start][j];
		if (start + 1 < vsize) dfs(start + 1, v);
		if (start == vsize - 1 && sum == ttarget) cnt++;
		sum -= v[start][j];
	}
}


int solution(vector<int> numbers, int target){
	ttarget = target;
	int answer = 0;
	vsize = numbers.size();
	vector<int> v[20];
	for (int i = 0; i < vsize; i++) {
		v[i].push_back(numbers[i]);
		v[i].push_back((-1)*numbers[i]);
	}
	dfs(0,v);
	answer = cnt;
	return answer;
}*/