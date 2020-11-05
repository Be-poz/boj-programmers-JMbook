/*#include <stdio.h>
#include <iostream>
#include <string>
#include <deque>
//#include <cstring>
using namespace std;

deque<int> dq;

int main() {
	int n,num;
	string sen;
	scanf("%d", &n);
	while (n--) {
		cin >> sen;
		if (sen == "push_front") {
			scanf("%d", &num);
			dq.push_front(num);
		}
		else if (sen == "push_back") {
			scanf("%d", &num);
			dq.push_back(num);
		}
		else if (sen == "pop_front") {
			if (!dq.empty()) {
				printf("%d\n", dq.front());
				dq.pop_front();
			}
			else printf("-1\n");
		}
		else if (sen == "pop_back") {
			if (!dq.empty()) {
				printf("%d\n", dq.back());
				dq.pop_back();
			}
			else printf("-1\n");
		}
		else if (sen == "size") {
			printf("%d\n", dq.size());
		}
		else if (sen == "empty") {
			printf("%d\n", dq.empty());
		}
		else if (sen == "front") {
			if (!dq.empty()) {
				printf("%d\n", dq.front());
			}
			else printf("-1\n");
		}
		else if (sen == "back") {
			if (!dq.empty()) {
				printf("%d\n", dq.back());
			}
			else printf("-1\n");
		}
	}
	return 0;
}*/