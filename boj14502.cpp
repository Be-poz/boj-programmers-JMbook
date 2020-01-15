/*#include <cstdio>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;
int n, m;
int result = 0;
int map[8][8];
int bx[4] = { 1,-1,0,0 };
int by[4] = { 0,0,1,-1 };

vector<pair<int, int> > virus;

void copyMap(int(*src)[8], int(*dest)[8]) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			dest[i][j] = src[i][j];
		}
	}
}

void bfs() {
	int copy[8][8];
	copyMap(map,copy);
	queue<pair<int, int> > q;
	for (int i = 0; i < virus.size(); i++) {
		q.push(virus[i]);
	}
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int xx = x + bx[i];
			int yy = y + by[i];
			if (xx >=0 && xx < n && yy >= 0 && yy < m) {
				if (copy[xx][yy] == 0) {
					copy[xx][yy] = 2;
					q.push(make_pair(xx, yy));
				}
			}
		}
	}
	int tmp = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (copy[i][j] == 0) tmp++;
		}
	}
	result = max(result, tmp);
}

void dfs(int x, int wall_cnt) {
	if (wall_cnt == 3) {
		bfs();
		return;
	}
	for (int i = x; i <n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				map[i][j] = 1;
				dfs(i, wall_cnt + 1);
				map[i][j] = 0;
			}
		}
	}
}


int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <m; j++) {
			scanf("%d", &map[i][j]);
			if (map[i][j] == 2) {
				virus.push_back(make_pair(i, j));
			}
		}
	}
	dfs(0, 0);
	printf("%d", result);
	return 0;
}*/