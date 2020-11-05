/*#include <stdio.h>
#include <queue>
using namespace std;

int n, x, y, num,cnt=0;

int main() {
	priority_queue<int> pq;
	queue<pair<int, int>> qu;
	scanf("%d", &n);
	while (n--) {
		cnt = 0;
		scanf("%d %d", &x, &y);
		for (int i = 0; i < x; i++) {
			scanf("%d", &num);
			pq.push(num);
			qu.push({ num,i });
		}
		while (qu.size()) {
			int temp = qu.front().first;
			int temp2 = qu.front().second;
			qu.pop();
			if (temp == pq.top()) {
				cnt++;
				pq.pop();
				if (y == temp2) break;
			}
			else qu.push({ temp,temp2 });
		}
		printf("%d\n", cnt);
		while (!qu.empty()) {
			qu.pop();
		}
		while (!pq.empty()) {
			pq.pop();
		}
	}
	return 0;
}*/