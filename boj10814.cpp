/*#include <stdio.h>
#include <algorithm>
#include <vector>
#include <string>
#include <iostream>
using namespace std;
bool cmp(pair<int, string>a, pair<int, string>b) {
	return a.first < b.first;
}
int main() {
	int n,age;
	string name;
	vector <pair<int, string>>vp;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		cin >> age >> name;
		vp.push_back(make_pair(age, name));
	}
	stable_sort(vp.begin(), vp.end(), cmp);
	for (int i = 0; i < n; i++) {
		cout << vp[i].first << " " << vp[i].second << '\n';
	}
	return 0;
}*/