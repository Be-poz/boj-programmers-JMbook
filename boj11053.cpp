/*#include <stdio.h>
using namespace std;

int dp[1001];
int array[1001] = { 0 };
int n; int max = 1; int temp = 1; int maxT = 1; int check = 0;
int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &array[i]);
	}
	for (int i = 0; i < 1001; i++) {
		dp[i] = 1;
	}
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j < i; j++) {
			if (array[j] < array[i]) {
				temp = dp[j];
				check=1;
			}
			if (temp > max) max = temp;
		}
		if (check != 0) {
			if ((max + 1) > maxT) maxT = max + 1;
			dp[i] = max + 1;
			max = 1;
		}
		check = 0;
		temp = 1;
	}
	printf("%d", maxT);
	return 0;
}*/