/*#include <stdio.h>
#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main() {
	queue<int> queue;
	int n,n2;
	string str;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		cin >> str;
		if (str == "push") {
			scanf("%d", &n2);
			queue.push(n2);
		}
		else if (str == "front") {
			if (!queue.empty()) {
				printf("%d\n", queue.front());
			}
			else printf("-1\n");
		}
		else if (str == "back") {
			if (!queue.empty()) {
				printf("%d\n", queue.back());
			}
			else printf("-1\n");
		}
		else if (str == "size") {
			printf("%d\n", queue.size());
		}
		else if (str == "empty") {
			printf("%d\n", queue.empty());
		}
		else if (str == "pop") {
			if (queue.size() == 0) printf("-1\n");
			else {
				printf("%d\n", queue.front());
				queue.pop();
			}

		}
	}
	return 0;
}*/