#include <cstring>
#include <cstdio>
using namespace std;

int tile[1001];

int dp(int n) {
	int idx = 1;
	tile[1] = 1;
	for (int i = 2; i <= n; i++ ) {
		if (idx == 1) tile[i] = (tile[i - 1] * 2)%10007 + 1;
		else if (idx == (-1)) tile[i] = (tile[i - 1] * 2)%10007 - 1;
		idx *= (-1);
	}
	return tile[n];
}

int main() {
	int n;
	scanf("%d", &n);
	printf("%d", dp(n));
	return 0;
}