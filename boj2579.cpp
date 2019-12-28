/*#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;

int memo[301];
int stair[301] = { 0 };

int dp(int n) {
	memo[1] = stair[1];
	memo[2] = stair[1] + stair[2];
	memo[3] = stair[3] + max(stair[1], stair[2]);
	for (int i = 4; i <= n; i++) {
		memo[i] = max(memo[i - 2] + stair[i], memo[i - 3] + stair[i - 1] + stair[i]);
	}
	return memo[n];
}

int main() {
	memset(memo, -1, sizeof(memo));
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &stair[i]);
	}
	printf("%d", dp(n));
	return 0;
}*/