/*#include <cstdio>
using namespace std;
int arr[300][300] = { 0 };
int main() {
	int n, m,k;
	int a, b, c, d;
	int sum;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	scanf("%d", &k);
	while (k--) {
		sum = 0;
		scanf("%d %d %d %d", &a, &b, &c, &d);
		for (int i = a - 1; i <= c - 1; i++) {
			for (int j = b - 1; j <= d - 1; j++) {
				sum += arr[i][j];
			}
		}
		printf("%d\n", sum);
	}
	return 0;
}*/