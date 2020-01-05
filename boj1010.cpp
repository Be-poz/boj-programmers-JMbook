/*#include <cstdio>
using namespace std;

long long dp(long long n, long long m) {
	int cnt = 0;
	if (m - n < n) n = m - n;
	long long res = 1, res2 = 1;
	for (int i = m; cnt < n; i--) {
		res *= i;
		cnt++;
	}
	for (int i = 1; i <= n; i++) {
		res2 *= i;
	}
	return res / res2;
}

int main() {
	int T;
	int n,m;
	scanf("%d", &T);
	while (T--) {
		scanf("%d %d", &n, &m);
		printf("%lld\n", dp(n, m));
	}
	return 0;
}*/