/*#include <stdio.h>
#include <vector>
using namespace std;

int main() {
	int n, m, num, idx = 0;
	long long left, right, mid,sum;
	vector <int> vv;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		vv.push_back(num);
	}
	left = 1, right = 1000000000;
	while (left <= right) {
		mid = (left + right) / 2;
		sum = 0;
		for (int i = 0; i < n; i++) {
			if (vv[i] - mid >= 0) {
				sum += (vv[i] - mid);
			}
		}
		if (sum > m) {
			left = mid + 1;
		}
		else if (sum < m) {
			right = mid - 1;
		}
		else if (sum == m) {
			idx = 1;
			break;
		}
	}
	if (idx == 1) printf("%d", mid);
	else printf("%d", right);
	return 0;
}*/