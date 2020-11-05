/*#include <cstdio>
#include <queue>
using namespace std;
int path[1001][1001];
int check[1001];
int n, m, v;

void dfs(int v) {
	check[v] = 1;
	printf("%d ", v);
	for (int i = 1; i <= n; i++) {
		if (check[i] == 1 || path[v][i] == 0) continue;
		dfs(i);
	}
}

void bfs(int v) {
	queue<int> q;
	q.push(v);
	check[v] = 0;
	while (!q.empty()) {
		v = q.front();
		printf("%d ", v);
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (path[v][i] == 0 || check[i] == 0) continue;
			q.push(i);
			check[i] = 0;
		}
	}
}

int main() {
	int a, b;
	scanf("%d %d %d", &n, &m, &v);
	while (m--) {
		scanf("%d %d", &a, &b);
		path[a][b] = 1;
		path[b][a] = 1;
	}
	dfs(v);
	printf("\n");
	bfs(v);
	return 0;
}*/