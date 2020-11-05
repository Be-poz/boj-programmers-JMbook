/*#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
int area[100][100];
int visit[100][100];
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int cnt = 0;
int group_id = 0;
int n;
int min_h=987654321, max_h=0;

void dfs(int x,int y,int hght) {
	for (int i = 0; i < 4; i++) {
		int xx = x + dx[i];
		int yy = y + dy[i];
		if (xx >= 0 && xx < n&&yy >= 0 && yy<n&&visit[xx][yy] == 0 && area[xx][yy]>hght) {
			visit[xx][yy] = 1;
			dfs(xx, yy, hght);
		}
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &area[i][j]);
			min_h = min(min_h, area[i][j]);
			max_h = max(max_h, area[i][j]);
		}
	}
	for (int i = min_h; i <= max_h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (area[j][k] > i&&visit[j][k] == 0) {
					visit[j][k] = 1;
					dfs(j,k,i);
					cnt++;
				}
			}
		}
		group_id = max(group_id, cnt);
		memset(visit, 0, sizeof(visit));
		cnt = 0;
	}
	if (!group_id) printf("1");
	else printf("%d", group_id);
	return 0;
}*/