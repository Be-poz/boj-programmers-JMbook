/*#include <stdio.h>
#define swap(a,b) {int tmp;tmp=a,a=b,b=tmp;}
using namespace std;

int heap[100001];
int h_cnt = 0;

void insert(int n) {
	heap[++h_cnt] = n;
	int child = h_cnt, parent = h_cnt / 2;
	while (parent >= 1 && heap[child] < heap[parent]) {
		swap(heap[child], heap[parent]);
		child = parent, parent = child / 2;
	}
}

int pop() {
	int result = heap[1];
	if (h_cnt == 0) return 0;
	swap(heap[1], heap[h_cnt]);
	heap[h_cnt] = 0;
	h_cnt--;
	int parent = 1;
	int child = parent * 2;
	if (child + 1 <= h_cnt) {
		child = (heap[child] < heap[child + 1]) ? child : child + 1;
	}
	while (child <= h_cnt && heap[child] < heap[parent]) {
		swap(heap[parent], heap[child]);
		parent = child;
		child = parent * 2;
		if (child + 1 <= h_cnt) {
			child = (heap[child] < heap[child + 1]) ? child : child + 1;
		}
	}
	return result;
}


int main() {
	int n, num;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		if (!num) {
			printf("%d\n", pop());
		}
		else {
			insert(num);
		}
	}
	return 0;
}*/