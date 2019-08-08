/*#include <cstdio>
#include <utility>
#include <vector>
using namespace std;

int main() {
	vector<pair<int, int>> wh;
	int n, w, h, cnt = 1, m;
	int* cnt_ary;
	scanf("%d", &n);
	m = n;
	cnt_ary = new int[n];
	while (n--) {
		scanf("%d %d", &w, &h);
		wh.push_back(make_pair(w, h));
	}
	for (int i = 0; i < wh.size(); i++) {
		for (int j = 0; j < i; j++) {
			if (wh[j].first > wh[i].first&&wh[j].second > wh[i].second) cnt++;
		}
		for (int j = i + 1; j < wh.size(); j++) {
			if (wh[j].first > wh[i].first&&wh[j].second > wh[i].second) cnt++;
		}
		cnt_ary[i] = cnt;
		cnt = 1;
	}
	for (int i = 0; i <m; i++) {
		printf("%d ", cnt_ary[i]);
	}
	delete[]cnt_ary;
	return 0;
}*/