/*#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;
vector <int> vv;
vector <int> vv2;
int main() {
	int n, m, num;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		vv.push_back(num);
	}
	sort(vv.begin(), vv.end());
	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", &num);
		vv2.push_back(num);
	}
	for (int i = 0; i < m; i++) {
		printf("%d ", upper_bound(vv.begin(), vv.end(), vv2[i]) - lower_bound(vv.begin(), vv.end(), vv2[i]));
	}
	return 0;
}*/