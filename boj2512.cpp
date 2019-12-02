/*#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> v;
int n, m, num;

int search() {
	int left = 1, right = v[n-1],mid;
	long long sum = 0;
	while (left <= right) {
		sum = 0;
		mid = (left + right) / 2;
		for (int i = 0; i < n; i++) {
			if (v[i] > mid) sum += mid;
			else sum += v[i];
		}
		if (sum == m) return mid;
		if (sum > m) right = mid - 1;
		else if (sum < m) left = mid + 1;
	}
	return right;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	scanf("%d", &m);
	printf("%d", search());
	return 0;
}*/