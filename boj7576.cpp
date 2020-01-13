/*#include <cstdio>
#include <queue>
#include <cstring>
using namespace std;

queue<pair<int, int> >q;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,-1,1 };
int box[1001][1001];
int n, m;
int cnt = 0;
int m_cnt = 0;

void bfs() {
	int x, y;
	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx > 0 && xx <= n && yy > 0 && yy <= m&&box[xx][yy]==0) {
				box[xx][yy] = box[x][y] + 1;
				q.push(make_pair(xx, yy));
			}
		}
	}
}

int main() {
	scanf("%d %d", &m, &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &box[i][j]);
			if (box[i][j] == 1) {
				cnt++;
				q.push(make_pair(i, j));
			}
			if (box[i][j] == (-1)) m_cnt++;
		}
	}

	bfs();
	int max = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (box[i][j] == 0) {
				printf("-1");
				return 0;
			}
			if (box[i][j] > max) max = box[i][j];
		}
	}
	printf("%d", max-1);
	return 0;
}*/