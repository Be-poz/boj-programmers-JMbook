/*#include <cstdio>
#include <cstring>
#include <queue>
using namespace std;
int T, n, m, k;
int vege[51][51];
int visit[51][51];
int group_id = 1;
int bx[4] = { 1,-1,0,0 };
int by[4] = { 0,0,1,-1 };
queue<pair<int, int> >q;

void bfs(int x,int y) {
	q.push(make_pair(x, y));
	while (!q.empty()) {
		int a = q.front().first;
		int b = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int xx = a + bx[i];
			int yy = b + by[i];
			if (xx >= 0 && xx < n && yy >= 0 && yy < m && visit[xx][yy] == 0 && vege[xx][yy] != 0) {
				q.push(make_pair(xx, yy));
				visit[xx][yy] = 1;
				vege[xx][yy] = group_id;
			}
		}
	}
}

int main() {
	scanf("%d", &T);
	while (T--) {
		scanf("%d %d %d", &n, &m, &k);
		for (int i = 0; i < k; i++) {
			int x, y;
			scanf("%d %d", &x, &y);
			vege[x][y] = 1;
		}
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <m; j++) {
				if (vege[i][j] != 0 && visit[i][j] == 0) {
					bfs(i,j);
					group_id++;
				}
			}
		}
		printf("%d\n", group_id-1);
		memset(visit, 0, sizeof(visit));
		memset(vege, 0, sizeof(vege));
		group_id = 1;
	}
	return 0;
}*/