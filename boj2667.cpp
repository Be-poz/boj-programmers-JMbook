/*#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
#include <utility>
using namespace std;

int house[26][26];
int visit[26][26];
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,-1,1 };
int groups[1000];
int group_id = 0;
int n;

void bfs(int x, int y) {
	group_id++;
	int a, b;
	queue<pair<int, int> >q;
	q.push(make_pair(x, y));
	house[x][y] = 0;
	visit[x][y] = 1;
	groups[group_id]++;
	while (!q.empty()) {
		a = q.front().first;
		b = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int xx = a + dx[i];
			int yy = b + dy[i];
			if (xx > 0 && xx <= n && yy > 0 && yy <= n) {
				if (visit[xx][yy] == 0 && house[xx][yy] != 0) {
					q.push(make_pair(xx, yy));
					visit[xx][yy] = 1;
					house[xx][yy] = 0;
					groups[group_id]++;
				}
			}
		}
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%1d", &house[i][j]);
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (house[i][j] != 0) {
				bfs(i, j);
			}
		}
	}
	printf("%d\n", group_id);
	sort(groups+1, groups+1+group_id);
	for (int i = 1; i <= group_id; i++) {
		printf("%d\n", groups[i]);
	}
	return 0;
}*/