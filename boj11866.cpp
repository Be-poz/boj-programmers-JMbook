/*#include <stdio.h>
#include <queue>
using namespace std;
int arr[1000] = { 0 };

int main() {
	queue<int> queue;
	int n, n2,temp;
	scanf("%d %d", &n, &n2);
	for (int i = 1; i <= n; i++) {
		queue.push(i);
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n2-1; j++) {
			temp = queue.front();
			queue.pop();
			queue.push(temp);
		}
		arr[i] = queue.front();
		queue.pop();
	}
	printf("<");
	for (int i = 0; i < n; i++) {
		if (i != (n - 1)) {
			printf("%d, ", arr[i]);
		}
		else {
			printf("%d>", arr[i]);
		}
	}
	return 0;
}*/