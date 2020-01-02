/*#include <cstdio>
#include <algorithm>
using namespace std;

int memo[1001] = { 0 };
int card[1001] = { 0 };

int dp(int n) {
	int temp = 0;
	memo[1] = card[1];
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= i; j++) {
			temp = max(temp, memo[j] + card[i - j]);
		}
		memo[i] = temp;
	}
	temp = 0;
	for (int i = 1; i <= n; i++) {
		if (memo[i] > temp) temp = memo[i];
	}
	return temp;
}

int main() {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &card[i]);
	}
	printf("%d", dp(n));
	return 0;
}*/