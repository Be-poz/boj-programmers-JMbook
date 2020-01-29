/*#include <cstdio>
#include <queue>
#include <string>
#include <vector>
using namespace std;
int arr[200][200];
int visit[200];
int group = 0;
queue<int> q;
void bfs(int start,int n) {
	q.push(start);
	while (!q.empty()) {
		int x = q.front();
		visit[x] = 1;
		q.pop();
		for (int i = 0; i < n; i++) {
			if (arr[x][i] != 0 && visit[i] == 0) q.push(i);
		}
	}
}

int solution(int n, vector<vector<int>>computers) {
	int answer = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			arr[i][j] = computers[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visit[i] == 0 && arr[i][j] != 0) {
				bfs(i,n);
				group++;
			}
		}
	}
	answer = group;
	return answer;
}

int main() {
	int n = 3;
	vector<vector<int> > computers(n,vector<int>(3,0));
	computers[0][0] = 1;
	computers[0][1] = 1;
	computers[0][2] = 0;
	computers[1][0] = 1;
	computers[1][1] = 1;
	computers[1][2] = 1;
	computers[2][0] = 0;
	computers[2][1] = 1;
	computers[2][2] = 1;
	printf("%d", solution(n, computers));
	return 0;
}*/