/*#include <stdio.h>
#include <utility>
#include <vector>
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
bool cmp(pair<string, int>a, pair<string, int>b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	else {
		return a.second < b.second;
	}
}
int main() {
	int n;
	string word;
	vector<pair<string, int>> vp;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		cin>>word;
		vp.push_back(make_pair(word, word.size()));
	}
	sort(vp.begin(), vp.end(), cmp);
	vp.erase(unique(vp.begin(), vp.end()), vp.end());
	for (int i = 0; i < vp.size(); i++) {
		cout << vp[i].first<<'\n';
	}
	return 0;
}*/