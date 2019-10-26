/*#include <stack>
#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;
int main() {
	stack<char> stack;
	int flag = 1;
	string sen = "set";
	getline(cin, sen);
	while (!(sen == ".")) {
		for (int i = 0; i < sen.size(); i++) {
			if (sen[i] == '(' || sen[i] == '[') {
				stack.push(sen[i]);
			}
			if (sen[i] == ')' || sen[i] == ']') {
				if (stack.empty()) {
					flag = 0;
					break;
				}
				if (sen[i] == ')'&& stack.top() != '(') {
					flag = 0;
					break;
				}
				if (sen[i] == ']' && stack.top() != '[') {
					flag = 0;
					break;
				}
				stack.pop();
			}
		}
		if (flag == 0 || !stack.empty()) printf("no\n");
		else if(flag==1) printf("yes\n");
		cin.clear();
		while (!stack.empty()) stack.pop();
		getline(cin, sen);
		flag = 1;
	}
	return 0;
}*/