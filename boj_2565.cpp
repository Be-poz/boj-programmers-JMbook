/*#include <stdio.h>
#include <utility>
#include <algorithm>
#include <vector>
using namespace std;

int n,temp=1,cur_max=1;
int dp[100] = { 0 };
bool check = false;
int main() {
	int a, b;
	scanf("%d", &n);
	vector<pair <int, int>>mp;
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &a, &b);
		mp.push_back(make_pair(a, b));
	}
	sort(mp.begin(), mp.end());
	for (int i = 0; i < n; i++) {
		dp[i] = 1;
		temp = 1, cur_max = 1, check = false;
		for (int j = 0; j < i; j++) {
			if (mp[i].second > mp[j].second) {
				temp = dp[j];
				if (temp > cur_max) cur_max = temp;
				check = true;
			}
		}
		if (check == true) {
			dp[i] = cur_max + 1;
		}
	}
	cur_max = dp[0];
	for (int i = 0; i < n; i++) {
		if (dp[i] > cur_max) cur_max = dp[i];
	}
	printf("%d", n-cur_max);
	return 0;
}*/