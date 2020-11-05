/*#include <stdio.h>
#include <utility>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
	int n,a,b;
	scanf("%d", &n);
	vector<pair<long, long>> vp;
	while(n--){
		scanf("%ld %ld", &a, &b);
		vp.push_back(make_pair(a,b));
	}
	sort(vp.begin(), vp.end());
	for (int i = 0; i < vp.size(); i++) {
		printf("%ld %ld\n", vp[i]);
	}
	return 0;
}*/