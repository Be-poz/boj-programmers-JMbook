/*#include <stdio.h>
#include <stack>
#include <iostream>
using namespace std;

int main() {
	stack<int> stack;
	int n,num,sum=0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		if (num) {
			stack.push(num);
		}
		else {
			stack.pop();
		}
	}
	int s_size = stack.size();
	for (int i = 0; i < s_size; i++) {
		if (!stack.empty()) {
			sum += stack.top();
			stack.pop();
		}
	}
	printf("%d", sum);
	return 0;
}*/