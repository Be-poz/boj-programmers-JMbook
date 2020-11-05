/*#include <cstdio>
#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	stack<int> stack;
	int n=0;
	int num=0;
	string word;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		cin >> word;
		if (word=="push") {
			scanf("%d", &num);
			stack.push(num);
		}
		else if (word == "top") {
			if (stack.empty()) {
				printf("-1\n");
			}
			else {
				printf("%d\n", stack.top());
			}
		}
		else if (word == "size") {
			printf("%d\n", stack.size());
		}
		else if (word == "empty") {
			printf("%d\n", stack.empty());
		}
		else if (word == "pop") {
			if (stack.empty()) {
				printf("-1\n");
			}
			else {
				printf("%d\n", stack.top());
				stack.pop();
			}
		}
		cin.clear();
	}
	return 0;
}*/