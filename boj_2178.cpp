/*#include <cstdio>
#include <utility>
#include <queue>
using namespace std;
int map[101][101];
int visit[101][101];
int bx[4] = { 0,1,0,-1 };
int by[4] = { 1,0,-1,0 };
int n, m;
int cnt=0;

int bfs(int x, int y) {
	int a, b;
	queue<pair<int,int> > q;
	visit[x][y] = 1;
	q.push(make_pair(x, y));
	cnt++;
	while (!q.empty()) {
		a = q.front().first;
		b = q.front().second;
		q.pop();
		if (a == n && b == m) return map[n][m];
		for (int i = 0; i < 4; i++) {
			int na = a + bx[i];
			int nb = b + by[i];
			if (na > 0 && na <= n&&nb>0 && nb <= m) {
				if (visit[na][nb] == 1 || map[na][nb] == 0) continue;
				map[na][nb] = map[a][b]+1;
				visit[na][nb] = 1;
				q.push(make_pair(na, nb));
			}
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%1d", &map[i][j]);

		}
	}
	printf("%d", bfs(1,1));
	return 0;
}*/