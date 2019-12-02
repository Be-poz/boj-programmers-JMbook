/*#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> v1(500000), v2;
int n, m, num;

int search(int x) {
	int left = 0;
	int right = n;
	int mid;
	while (left <= right) {
		mid = (left + right) / 2;
		if (x == v1[mid]) return 1;
		else if (x > v1[mid]) left = mid + 1;
		else if (x < v1[mid])right = mid - 1;
	}
	return 0;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		v1[i] = num;
	}
	sort(v1.begin(), v1.begin()+n);
	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", &num);
		v2.push_back(num);
	}
	for (int i = 0; i < m; i++) {
		printf("%d ", search(v2[i]));
	}
	return 0;
}*/