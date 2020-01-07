/*#include <cstdio>
#include <algorithm>
#define inf 987654321
using namespace std;
int coin[101];
int memo[10001];
bool cmp(int a, int b) {
	return a > b;
}
int dp(int n, int k) {
	for (int i = 1; i <= k; i++) {
		memo[i] = inf;
		for (int j = 1; j <= n; j++) {
			if (i - coin[j] >= 0) memo[i] = min(memo[i], 1+memo[i - coin[j]]);
		}
	}
	if (memo[k] == inf) return -1;
	else return memo[k];
}
int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &coin[i]);
	}
	sort(coin+1, coin + n+1,cmp);
	printf("%d", dp(n, k));
	return 0;
}*/