/*#include <stdio.h>
using namespace std;
int array[1001] = { 0 };
int dp[1001] = { 0 };
int dp2[1001] = { 0 };
int n=0, max=1, temp=1;
bool check = false;

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &array[i]);
	}
	for (int i = 1; i <= n; i++) {
		check = false, temp = 1, max = 1;
		dp[i] = 1;
		for (int j = 1; j < i; j++) {
			if (array[i] > array[j]) {
				temp = dp[j];
				check = true;
			}
			if (temp > max) max = temp;
		}
		if (check == true) {
			dp[i] = max + 1;
		}
	}

	for (int i = n; i >= 1; i--) {
		check = false, temp = 1, max = 1;
		dp2[i] = 1;
		for (int j = n; j > i; j--) {
			if (array[i] > array[j]) {
				temp = dp2[j];
				check = true;
			}
			if (temp > max) max = temp;
		}
		if (check == true) {
			dp2[i] = max + 1;
		}
	}
	max = dp[1] + dp2[1];
	for (int i = 1; i < n; i++) {
		temp = dp[i] + dp2[i];
		if (temp > max) {
			max = temp;
		}
	}
	printf("%d", max - 1);
	
	return 0;
}*/