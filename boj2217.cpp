/*#include <stdio.h>
#include <algorithm>
using namespace std;
int N[100000] = { 0 };
int main() {
	int n,maxT;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &N[i]);
	}
	sort(N, N + n);
	maxT = N[0] * n;
	for (int i = 1; i < n; i++) {
		maxT = max(maxT, N[i] * (n - i));
	}
	printf("%d", maxT);
	return 0;
}*/