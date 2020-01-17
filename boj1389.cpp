/*#include <cstdio>
#include <vector>
#include <utility>
#include <cstring>
#include <queue>
#include <algorithm>
using namespace std;
int user[100][100];
int kevin[100];
int visit[100];
int weight[100];
int u,line;
vector<pair<int, int> >vp;
queue<int> q;
int z;

bool cmp(pair<int,int> a, pair<int,int> b) {
	if (a.second == b.second) return a.first < b.first;
	else return a.second < b.second;
}

void bfs(int start) {
	q.push(start);
	visit[start] = 1;
	while (!q.empty()) {
		int x = q.front();
		kevin[z] += weight[x];
		q.pop();
		for (int i = 0; i < u; i++) {
			if (user[x][i] == 1 && visit[i] == 0) {
				q.push(i);
				weight[i] = weight[x] + 1;
				visit[i] = 1;
			}
		}
	}
}

int main() {
	scanf("%d %d", &u, &line);
	while (line--) {
		int a, b;
		scanf("%d %d", &a, &b);
		user[a-1][b-1] = 1;
		user[b-1][a-1] = 1;
	}
	for (z = 0; z < u; z++) {
		weight[z] = 1;
		bfs(z);
		vp.push_back(make_pair(z, kevin[z]));
		memset(visit, 0, sizeof(visit));
		memset(weight, 0, sizeof(weight));
	}
	sort(vp.begin(), vp.end(), cmp);
	printf("%d", vp[0].first+1);
	return 0;
}*/