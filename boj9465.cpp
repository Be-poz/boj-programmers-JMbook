/*#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
int stck[2][100001];
int memo[2][100001];

int dp(int n) {
	memo[0][1] = stck[0][1], memo[1][1] = stck[1][1];
	memo[0][2] = memo[1][1] + stck[0][2], memo[1][2] = memo[0][1] + stck[1][2];
	for (int i = 3; i <= n; i++) {
		memo[0][i] = max(memo[1][i - 2], memo[1][i - 1]) + stck[0][i];
		memo[1][i] = max(memo[0][i - 2], memo[0][i - 1]) + stck[1][i];
	}
	return max(memo[0][n], memo[1][n]);
}

int main() {
	memset(stck, -1, sizeof(stck));
	int T;
	int n;
	scanf("%d", &T);
	for (int i = 1; i <= T; i++) {
		scanf("%d", &n);
		for (int j = 1; j <= 2*n; j++) {
			if(j<=n) scanf("%d", &stck[0][j]);
			else scanf("%d", &stck[1][j-n]);
		}
		printf("%d\n", dp(n));
	}
	return 0;
}*/