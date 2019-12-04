/*#include <stdio.h>
#include <utility>
#include <algorithm>
#include <vector>
using namespace std;

vector<pair<int, int> > vp;
int arr[1000] = { 0 };
int lis[1000] = { 0 };
int main() {
	int n;
	int idx = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		if (i == 0) {
			lis[idx++] = arr[i];
			vp.push_back(make_pair(0, arr[i]));
		}
		else {
			int low = lower_bound(arr, arr + i, arr[i]) - arr;
			vp.push_back(make_pair(low, arr[i]));
		}
	}
	for (int i = vp.size() - 1; i >= 0; i++) {

	}
	return 0;
}*/