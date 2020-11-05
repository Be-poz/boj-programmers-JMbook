/*#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;

long long memo[91];

int dp(int n) {
	memo[1] = 1, memo[2] = 1;
	for (int i = 3; i <= n; i++) {
		memo[i] = memo[i - 1] + memo[i - 2];
	}
	return memo[n];
}

int main() {
	memset(memo, -1, sizeof(memo));
	int n;
	scanf("%d", &n);
	printf("%lld", dp(n));
	return 0;
}*/