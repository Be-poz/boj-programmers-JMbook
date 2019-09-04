/*#include <stdio.h>
#include <cstring>
using namespace std;

long long memo[41];
long long fibo(int n) {
	/*memo[0] = 0, memo[1] = 1;
	if (memo[n] != -1) return memo[n];
	memo[n] = fibo(n - 1) + fibo(n - 2);
	return memo[n];*/
	memo[0] = 0, memo[1] = 1;
	for (int i = 2; i <= n; i++) {
		memo[i] = memo[i - 1] + memo[i - 2];
	}
	return memo[n];
}

int main() {
	int cnt,n;
	//memset(memo, -1, sizeof(memo));
	scanf("%d", &cnt);
	while (cnt--) {
		scanf("%d", &n);
		if (n == 0) printf("1 0\n");
		else if (n == 1) printf("0 1\n");
		else {
			printf("%lld %lld\n", fibo(n - 1), fibo(n));
		}
	}
	return 0;
}*/