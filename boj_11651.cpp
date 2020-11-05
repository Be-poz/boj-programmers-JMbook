/*#include <stdio.h>
#include <utility>
#include <algorithm>
#include <vector>
using namespace std;

bool cmp(pair<long,long> a, pair<long,long> b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	else {
		return a.second < b.second;
	}
}

int main() {
	int n,a,b;
	scanf("%d", &n);
	vector<pair<long, long>> vp;
	while(n--){
		scanf("%ld %ld", &a, &b);
		vp.push_back(make_pair(a,b));
	}
	sort(vp.begin(), vp.end(),cmp);
	for (int i = 0; i < vp.size(); i++) {
		printf("%ld %ld\n", vp[i]);
	}
	return 0;
}*/