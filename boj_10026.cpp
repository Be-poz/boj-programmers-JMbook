/*#include <cstdio>
using namespace std;
char area[100][100];
int visit[100][100];
int color_visit[100][100];
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };
int n;
int normal_cnt = 0;
int color_cnt = 0;

void dfs(int x, int y) {
	char color = area[x][y];
	for (int i = 0; i < 4; i++) {
		int xx = x + dx[i];
		int yy = y + dy[i];
		if (xx >= 0 && xx < n&&yy >= 0 && yy < n&&area[xx][yy] == color && visit[xx][yy] == 0) {
			visit[xx][yy] = 1;
			dfs(xx, yy);
		}
	}
}

void color_dfs(int x, int y) {
	char color = area[x][y];
	if (color == 'R' || color == 'G') {
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >= 0 && xx < n&&yy >= 0 && yy < n&&(area[xx][yy] == 'R'||area[xx][yy]=='G') && color_visit[xx][yy] == 0) {
				color_visit[xx][yy] = 1;
				color_dfs(xx, yy);
			}
		}
	}
	else {
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >= 0 && xx < n&&yy >= 0 && yy < n&&area[xx][yy] == color && color_visit[xx][yy] == 0) {
				color_visit[xx][yy] = 1;
				color_dfs(xx, yy);
			}
		}
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		getchar();
		for (int j = 0; j < n; j++) {
			scanf("%1c", &area[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visit[i][j] == 0) {
				visit[i][j] = 1;
				dfs(i, j);
				normal_cnt++;
			}

			if (color_visit[i][j] == 0) {
				color_visit[i][j] = 1;
				color_dfs(i, j);
				color_cnt++;
			}
		}
	}
	printf("%d %d", normal_cnt, color_cnt);
	return 0;
}*/