/*#include <stdio.h>
using namespace std;

int main() {
	int dp[101][10] = { 0 };
	int n,sum=0;
	scanf("%d", &n);
	for (int i = 1; i < 10; i++) {
		dp[1][i] = 1;
		if (i == 9) {
			dp[2][i] = 1;
		}
		else {
			dp[2][i] = 2;
		}
	}
	for (int i = 3; i < 101; i++) {
		for (int j = 1; j < 10; j++) {
			if (j == 1) {
				dp[i][j] = (dp[i - 2][j]+ dp[i - 1][j + 1])% 1000000000;
			}
			else if (j == 9) {
				dp[i][j] = (dp[i - 1][j - 1])% 1000000000;
			}
			else {
				dp[i][j] = (dp[i - 1][j - 1]+ dp[i - 1][j + 1])% 1000000000;
			}
		}
	}
	for (int i = 1; i < 10; i++) {
		sum += dp[n][i];
		sum %= 1000000000;
	}
	printf("%d", sum);
	return 0;
}*/