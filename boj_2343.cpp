/*#include <stdio.h>
#include <vector>
using namespace std;

int main() {
	int n, m,num;
	long long sum = 0;
	int bluelay = 0;
	int left=0, right=0, pivot;
	vector <int> vv;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		right += num;
		left = left < num ? num : left;
		vv.push_back(num);
	}
	while (left <= right) {
		pivot = (left + right) / 2;
		sum = 0, bluelay = 0;
		for (int i = 0; i < n; i++) {
			if (sum + vv[i] > pivot) {
				sum = 0;
				bluelay++;
			}
			sum += vv[i];
		}
		if (sum != 0) bluelay++;
		if (bluelay<=m) {
			right = pivot - 1;
		}
		else left = pivot + 1;
	}
	printf("%d", left);
	return 0;
}*/