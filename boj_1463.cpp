/*#include <cstdio>
#include <string.h>

#define min(x,y) x<=y ? x:y
#define INF 987654321
using namespace std;

int dp[1000001];

int solve(int n) {

	if (n == 1) return 0;
	if (dp[n] != -1) return dp[n];

	int ret = INF;
	if (n % 2 == 0) ret = 1 + solve(n / 2);
	if (n % 3 == 0) ret = min(ret, 1 + solve(n / 3));
	//ret = min(ret, 1+solve(n-1));
	if (n % 6 != 0)
		ret = min(ret, 1 + solve(n - 1));

	return dp[n] = ret;
}

int main() {

	int n;
	scanf("%d", &n);

	memset(dp, -1, sizeof(dp));
	printf("%d\n", solve(n));
}
*/