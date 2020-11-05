/*#include <cstdio>
#include <queue>
using namespace std;

int path[101][101];
int visit[101];
int cnt = 0;
int angle, line;

void dfs(int n) {
	visit[n] = 1;
	for (int i = 1; i <= angle; i++) {
		if (visit[i] == 1 || path[n][i] == 0) continue;
		dfs(i);
		cnt++;
	}
}

void bfs(int n) {
	queue<int> q;
	q.push(n);
	visit[n] = 1;
	while (!q.empty()) {
		n = q.front();
		q.pop();
		for (int i = 1; i <= angle; i++) {
			if (visit[i] == 1 || path[n][i] == 0) continue;
			q.push(i);
			visit[i] = 1;
			cnt++;
		}
	}
}

int main(){
	int a, b;
	scanf("%d", &angle);
	scanf("%d", &line);
	while (line--) {
		scanf("%d %d", &a, &b);
		path[a][b] = 1;
		path[b][a] = 1;
	}
	bfs(1);
	printf("%d", cnt);
	return 0;
}*/