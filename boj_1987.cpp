/*#include <cstdio>
#include <map>
#include <algorithm>
using namespace std;
char area[20][20];
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };
int max_cnt = 0;
int cnt = 0;
int r, c;
map<char, int> m;

void dfs(int x, int y) {
	max_cnt = max(cnt, max_cnt);
	for (int i = 0; i < 4; i++) {
		int xx = x + dx[i];
		int yy = y + dy[i];
		if (xx >= 0 && xx < r&&yy >= 0 && yy < c&&m[area[xx][yy]] == 0) {
			cnt++;
			m[area[xx][yy]]++;
			dfs(xx, yy);
			cnt--;
			m[area[xx][yy]]--;
		}
	}
}

int main() {
	scanf("%d %d", &r, &c);
	for (int i = 0; i < r; i++) {
		getchar();
		for (int j = 0; j < c; j++) {
			scanf("%1c", &area[i][j]);
		}
	}
	m[area[0][0]]++;
	cnt++;
	dfs(0, 0);
	printf("%d", max_cnt);
	return 0;
}*/