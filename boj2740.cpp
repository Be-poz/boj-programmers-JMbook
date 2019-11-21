/*#include <stdio.h>
using namespace std;

int arr[101][101] = { 0 };
int arr2[101][101] = { 0 };
int result[101][101] = { 0 };
int main() {
	int n, m, k;
	int sum = 0;
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	scanf("%d %d", &m, &k);
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= k; j++) {
			scanf("%d", &arr2[i][j]);
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int q = 1; q <= k; q++) {
			for (int j = 1; j <= m; j++) {
				sum+= arr[i][j] * arr2[j][q];
			}
			result[i][q] = sum;
			sum = 0;
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			printf("%d ", result[i][j]);
		}
		printf("\n");
	}
	return 0;
}*/