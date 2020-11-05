/*#include <stdio.h>
long long memo[1000002];
long long fibo(int n) {
	memo[0] = 0, memo[1] = 1;
	for (int i = 2; i <= n; i++) {
		memo[i] = (memo[i - 1] + memo[i - 2])%15746;
	}
	return memo[n];
}

int main() {
	int num;
	long long result;
	scanf("%d", &num);
	result = fibo(num + 1);
	printf("%lld", result);

	return 0;
}*/