/*#include <cstdio>
#include <queue>
using namespace std;
int graph[1001][1001];
int visit[1001];
int cnt = 0;
int n, m;
queue<int> q;
void bfs(int start) {
	q.push(start);
	visit[start] = 1;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (graph[x][i] == 1 && visit[i] == 0) {
				q.push(i);
				visit[i] = 1;
			}
		}
	}
}

int main(){
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		graph[a][b] = 1;
		graph[b][a] = 1;
	}
	for (int i = 1; i <= n; i++) {
		if (visit[i] == 0) {
			bfs(i);
			cnt++;
		}
	}
	printf("%d", cnt);
	return 0;
}*/