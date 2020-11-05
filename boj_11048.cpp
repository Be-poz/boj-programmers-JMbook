/*#include <cstdio>
#include <algorithm>
using namespace std;

int memo[1001][1001];
int candy[1001][1001];
int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &candy[i][j]);
		}
	}
	memo[1][1] = candy[1][1];
	for (int i = 2; i <= m; i++) {
		memo[1][i] = memo[1][i - 1] + candy[1][i];
	}
	for (int i = 2; i <= n; i++) {
		memo[i][1] = memo[i-1][1] + candy[i][1];
	}
	for (int i = 2; i <= n; i++) {
		for (int j = 2; j <= m; j++) {
			memo[i][j] = max(max(memo[i - 1][j - 1], memo[i][j - 1]), memo[i - 1][j]) + candy[i][j];
		}
	}
	printf("%d", memo[n][m]);
	return 0;
}*/