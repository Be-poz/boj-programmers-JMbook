/*#include <stdio.h>
#include <algorithm>
using namespace std;
int n;
int maxT[10001] = { 0 };
int dp[10001] = { 0 };

void solve() {
	maxT[1] = dp[1], maxT[2] = dp[2] + dp[1];
	for (int i = 3; i <= n; i++) {
		maxT[i] = max(maxT[i - 1], maxT[i - 2] + dp[i]);
		maxT[i] = max(maxT[i], maxT[i - 3] + dp[i - 1] + dp[i]);
	}
	printf("%d", maxT[n]);
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &dp[i]);
	}
	solve();
	return 0;
}*/