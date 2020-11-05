/*#include <stdio.h>
#include <vector>
using namespace std;

typedef vector<vector<int> > vtwo;

vtwo mul(vtwo a, vtwo b) {
	int n = a.size();
	vtwo result(n, vector<int>(n, 0));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				result[i][j] += a[i][k] * b[k][j];
			}
			result[i][j] %= 1000;
		}
	}
	return result;
}


vtwo dq(vtwo varr, long long b) {
	int n = varr.size();
	vtwo result(n,vector<int>(n));
	for (int i = 0; i < n; i++) result[i][i] = 1;
	vtwo temp = varr;
	while (b > 0) {
		if (b % 2) {
			result = mul(result, temp);
		}
		temp = mul(temp, temp);
		b /= 2;
	}
	return result;
}

int main() {
	int n;
	long long b;
	scanf("%d %lld", &n, &b);
	vtwo ans;
	vtwo varr(n, vector<int>(n, 0));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &varr[i][j]);
		}
	}
	ans = dq(varr, b);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", ans[i][j]);
		}
		printf("\n");
	}
	return 0;
}*/