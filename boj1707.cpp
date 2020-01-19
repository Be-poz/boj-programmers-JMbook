/*#include <cstring>
#include <cstdio>
#include <vector>
using namespace std;
int k, v, e;
int clr = 1;
int visit[20000];
vector<int> vec[20000];
#define RED 1
#define BLUE 2

bool isBipartiteGraph() {
	for (int i = 0; i <v; i++) {
		int gsize = vec[i].size();
		for (int j = 0; j < gsize; j++) {
			int next = vec[i][j];
			if (visit[i] == visit[next]) {
				return 0;
			}
		}
	}
	return 1;
}

void dfs(int start) {
	if(!visit[start]) visit[start] = RED;
	int vec_size = vec[start].size();
	for (int i = 0; i < vec_size; i++) {
		if (!visit[vec[start][i]]) {
			if (visit[start] == RED) visit[vec[start][i]] = BLUE;
			else visit[vec[start][i]] = RED;
			dfs(vec[start][i]);
		}
	}
}

int main() {
	int check = 1;
	scanf("%d", &k);
	while (k--) {
		scanf("%d %d", &v, &e);
		for (int i = 0; i < e; i++) {
			int a, b;
			scanf("%d %d", &a, &b);
			vec[a - 1].push_back(b - 1);
			vec[b - 1].push_back(a - 1);
		}
		for (int i = 0; i < v; i++) {
			if (!visit[i]) dfs(i);
		}

		for (int i = 0; i < v; i++) {
			int vec_size = vec[i].size();
			for (int j = 0; j < vec_size; j++) {
				if (visit[i] == visit[vec[i][j]]) {
					check = 0;
					break;
				}
			}
		}

		if (isBipartiteGraph()) {
			printf("YES\n");
		}
		else printf("NO\n");

		for (int i = 0; i < v; i++) {
			vec[i].clear();
		}
		memset(visit, 0, sizeof(visit));
		check = 1;
	}
}*/