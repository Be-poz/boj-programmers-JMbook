/*#include <cstdio>
#include <algorithm>
using namespace std;
int memo[1001];
int arr[1001];

int dp(int n) {
	int temp;
	memo[1] = arr[1];
	for (int i = 2; i <= n; i++) {
		temp = 0;
		for (int j = 1; j < i; j++) {
			if (arr[j] < arr[i]) temp = max(memo[j], temp);
		}
		memo[i] = temp + arr[i];
	}
	temp = 0;
	for (int i = 1; i <= n; i++) {
		temp = max(temp, memo[i]);
	}
	return temp;
}

int main() {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &arr[i]);
	}
	printf("%d", dp(n));
	return 0;
}*/