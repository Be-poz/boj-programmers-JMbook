/*#include <stdio.h>

long long memo[101];
long long fibo(int n) {
	memo[0] = 0, memo[1] = 1, memo[2] = 1, memo[3] = 1, memo[4] = 2, memo[5] = 2;
	for (int i = 6; i <= n; i++) {
		memo[i] = memo[i - 1] + memo[i - 5];
	}
	return memo[n];
}

int main() {
	int n;
	int n2;
	scanf("%d", &n);
	while (n--) {
		scanf("%d", &n2);
		printf("%lld\n", fibo(n2));
	}
	return 0;
}*/