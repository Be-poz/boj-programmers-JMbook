/*#include <stdio.h>
#include <algorithm>
using namespace std;

int arr[100001] = { 0 };
int dp[100001] = { 0 };
int n,maxx;

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &arr[i]);
	}
	dp[1] = arr[1];
	for (int i = 2; i <= n; i++) {
		dp[i] = max(dp[i - 1] + arr[i], arr[i]);
	}
	maxx = dp[1];
	for (int i = 1; i <= n; i++) {
		if (dp[i] > maxx) maxx = dp[i];
	}
	printf("%d", maxx);
	return 0;
}*/