/*#include <stdio.h>
#include <queue>
using namespace std;

int card(int n);

int main() {
	int n;
	scanf("%d", &n);
	printf("%d", card(n));
	return 0;
}

int card(int n) {
	if (n == 1) return 1;
	queue<int> queue;
	int temp = 0;
	for (int i = 0; i < n; i++) {
		queue.push(i + 1);
	}
	while (true) {
		queue.pop();
		temp = queue.front();
		if (queue.size() == 1) break;
		queue.pop();
		queue.push(temp);
	}
	return temp;
}*/