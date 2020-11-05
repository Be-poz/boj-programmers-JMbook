/*#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, temp = 0, cnt = 0;
	vector<int> vv;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		if (i == 0) {
			vv.push_back(temp);
			cnt++;
		}
		if (temp > vv.back()) {
			vv.push_back(temp);
			cnt++;
		}
		else {
			auto low = lower_bound(vv.begin(), vv.end(), temp);
			*low = temp;
		}
	}
	printf("%d", cnt);
	return 0;
}*/