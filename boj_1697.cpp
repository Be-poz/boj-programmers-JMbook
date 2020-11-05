/*#include <cstdio>
#include <queue>
using namespace std;

int loc[100001];
int visit[100001];
int n, k;
queue<int> q;

void bfs() {
	q.push(n);
	int flag = 0;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		if ((x -1) <= 100000 && !visit[x - 1]) {
			q.push(x - 1);
			visit[x - 1] = 1;
			loc[x - 1] = loc[x] + 1;
		}
		if ((x + 1) <= 100000 && !visit[x + 1]) {
			q.push(x + 1);
			visit[x + 1] = 1;
			loc[x + 1] = loc[x] + 1;
		}
		if ((x * 2) <= 100000&&visit[x*2]==0) {
			q.push(x * 2);
			loc[x * 2] = loc[x] + 1;
			visit[x * 2] = 1;
		}
		if ((x - 1) == k || (x + 1) == k || (x * 2) == k) {
			printf("%d", loc[k]);
			flag = 1;
			break;
		}
		if (flag) break;
	}
}

int main() {
	scanf("%d %d", &n, &k);
	loc[n] = 0;
	visit[n] = 1;
	bfs();
	return 0;
}*/