/*#include <cstdio>
#include <algorithm>
#include <cmath>
#define inf 987654321
using namespace std;
int memo[100001] = { 0,1,2,3, };
int dp(int n) {
	int temp = 0;
	int cnt = 0;
	int value;
	for (int i = 4; i <= n; i++) {
		temp = sqrt(i);
		if (pow(temp, 2) == i) {
			memo[i] = 1;
			continue;
		}
		memo[i] = inf;
		for (int j = temp; j >= 1; j--) {
			cnt = 1 + memo[i - j*j];
			memo[i] = min(memo[i], cnt);
			if (cnt == 2) break;
		}
	}
	return memo[n];
}

int main() {
	int n;
	scanf("%d", &n);
	printf("%d", dp(n));
	return 0;
}*/