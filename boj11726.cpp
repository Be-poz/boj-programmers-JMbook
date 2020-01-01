/*#include <cstdio>
#include <cstring>
using namespace std;
int memo[1001];

int dp(int n) {
	memo[1] = 1, memo[2] = 2;
	for (int i = 3; i <= n; i++) {
		memo[i] = memo[i - 1]%10007 + memo[i - 2]%10007;
	}
	return memo[n]%10007;
}

int main() {
	int n;
	scanf("%d", &n);
	printf("%d", dp(n));
	return 0;
}*/