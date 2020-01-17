/*#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int n, m, k;
int group_id = 0;
int group[3000];
int map[100][100];
int visit[100][100];
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };
queue<pair<int, int> >q;

void bfs(int y, int x) {
	q.push(make_pair(x, y));
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >= 0 && xx < n&&yy >= 0 && yy < m) {
				if (map[yy][xx] == 0 && visit[yy][xx] == 0) {
					q.push(make_pair(xx, yy));
					visit[yy][xx] = 1;
					group[group_id]++;
				}
			}
		}
	}
}

int main() {
	scanf("%d %d %d", &m, &n, &k);
	for (int i = 0; i < k; i++) {
		int lx, ly, rx, ry;
		scanf("%d %d %d %d", &lx, &ly, &rx, &ry);
		for (int i = ly; i < ry; i++) {
			for (int j = lx; j < rx; j++) {
				map[i][j] = 1;
			}
		}
	}
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j] == 0 && visit[i][j] == 0) {
				visit[i][j] = 1;
				group[group_id]++;
				bfs(i, j);
				group_id++;
			}
		}
	}
	printf("%d\n", group_id);
	sort(group, group + group_id);
	for (int i = 0; i < group_id; i++) {
		printf("%d ", group[i]);
	}
	return 0;
}*/