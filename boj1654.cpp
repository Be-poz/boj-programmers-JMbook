/*#include <stdio.h>
#include <vector>
#include <limits.h>
using namespace std;

int main() {
	long long k, n, num;
	long long  left,right,pivot, max = 0,result=0;
	vector<int> vv;
	scanf("%lld %lld", &k, &n);
	for (int i = 0; i < k; i++) {
		scanf("%lld", &num);
		vv.push_back(num);
	}
	left = 0, right = INT_MAX;
	while (left <= right) {
		result = 0;
		pivot = (left + right) / 2;
		for (int i = 0; i < k; i++) {
			result += vv[i] / pivot;
		}
		if (result >= n) {
			left = pivot + 1;
			if (pivot > max) max = pivot;
		}
		else {
			right = pivot - 1;
		}
	}
	printf("%lld", max);
	return 0;
}*/