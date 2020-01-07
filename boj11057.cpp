/*#include <cstdio>
using namespace std;

long long memo[1000][10] = { 1,1,1,1,1,1,1,1,1,1, };

int dp(int n) {
	long long sum = 10;
	long long temp = 0;
	long long temp2 = 0;
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < 10; j++) {
			sum += 10007;
			if (j == 0) memo[i][j] = sum;
			else {
				temp2 += (memo[i - 1][j - 1]%10007);
				memo[i][j] = (sum - temp2)%10007;
			}
			temp += (memo[i][j]%10007);
			temp %= 10007;
		}
		sum = temp;
		temp = 0;
		temp2 = 0;
	}
	return sum;
}

int main() {
	int n;
	scanf("%d", &n);
	printf("%d", dp(n));
	return 0;
}*/