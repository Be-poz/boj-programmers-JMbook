/* <stdio.h>
#include <stack>
#include <string>
#include <iostream>
using namespace std;

int main() {
	int n;
	int flag = 1;
	string str;
	stack<int> stack;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		while (!stack.empty()) stack.pop(); //요것이 요점이었다... 오답의
		cin >> str;
		flag = 1;
		for (int j = 0; j < str.size(); j++) {
			if (str[j] == '(') {
				stack.push(1);
			}
			else {
				if (!stack.empty()) {
					stack.pop();
				}
				else {
					flag = 0;
					break;
				}
			}
		}
		if (!stack.empty()) flag = 0;
		if (flag) {
			printf("YES\n");
		}
		else printf("NO\n");
	}
	return 0;
}*/