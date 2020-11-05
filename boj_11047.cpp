/*#include <stdio.h>
using namespace std;
int arr[10] = { 0 };

int main() {
	int N, K,cnt=0;
	scanf("%d %d", &N, &K);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = N-1; i >= 0; i--) {
		cnt += K / arr[i];
		K %= arr[i];
	}
	printf("%d", cnt);
	return 0;
}*/