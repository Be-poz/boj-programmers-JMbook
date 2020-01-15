/*#include <cstdio>
#include <cstring>
#include <queue>
using namespace std;
int n;
int line[101][101];
int result[101][101];
int visit[101];
queue<int>q;
void bfs(int start) {
	q.push(start);
	int point = q.front();
	while (!q.empty()) {
		int start = q.front();
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (line[start][i] == 1&&visit[i]==0) {
				q.push(i);
				result[point][i] = 1;
				visit[i] = 1;
			}
		}
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%d", &line[i][j]);
		}
	}
	for (int i = 1; i <= n; i++) {
		bfs(i);
		memset(visit, 0, sizeof(visit));
	}
	for (int i = 1; i <= n; i++) {
		for(int j=1;j<=n;j++){
			printf("%d ", result[i][j]);
		}
		printf("\n");
	}
}*/