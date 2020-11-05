/*#include <stdio.h>
#include <algorithm>
#define swap(a,b) {int tmp;tmp=a,a=b,b=tmp;}
using namespace std;

int max_heap[100001];
int min_heap[100001];
int maxh_cnt = 0;
int minh_cnt = 0;

void max_insert(int x) {
	max_heap[++maxh_cnt] = x;
	int child = maxh_cnt, parent = child / 2;
	while (parent >= 1 && max_heap[child] > max_heap[parent]) {
		swap(max_heap[child], max_heap[parent]);
		child = parent, parent = child / 2;
	}
}

int max_pop() {
	if (maxh_cnt == 0) return 0;
	int result = max_heap[1];
	swap(max_heap[1], max_heap[maxh_cnt]);
	max_heap[maxh_cnt] = 0;
	maxh_cnt--;
	int parent = 1;
	int child = parent * 2;
	if (child + 1 <= maxh_cnt) {
		child = (max_heap[child] > max_heap[child + 1]) ? child : child + 1;
	}
	while (max_heap[child] > max_heap[parent] && child <= maxh_cnt) {
		swap(max_heap[parent], max_heap[child]);
		parent = child;
		child = parent * 2;
		if (child + 1 <= maxh_cnt) {
			child = (max_heap[child] > max_heap[child + 1]) ? child : child + 1;
		}
	}
	return result;
}

void min_insert(int n) {
	min_heap[++minh_cnt] = n;
	int child = minh_cnt, parent = minh_cnt / 2;
	while (parent >= 1 && min_heap[child] < min_heap[parent]) {
		swap(min_heap[child], min_heap[parent]);
		child = parent, parent = child / 2;
	}
}

int min_pop() {
	int result = min_heap[1];
	if (minh_cnt == 0) return 0;
	swap(min_heap[1], min_heap[minh_cnt]);
	min_heap[minh_cnt] = 0;
	minh_cnt--;
	int parent = 1;
	int child = parent * 2;
	if (child + 1 <= minh_cnt) {
		child = (min_heap[child] < min_heap[child + 1]) ? child : child + 1;
	}
	while (child <= minh_cnt && min_heap[child] < min_heap[parent]) {
		swap(min_heap[parent], min_heap[child]);
		parent = child;
		child = parent * 2;
		if (child + 1 <= minh_cnt) {
			child = (min_heap[child] < min_heap[child + 1]) ? child : child + 1;
		}
	}
	return result;
}

int main() {
	int n, num;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		if (i == 0) max_insert(num);
		else if (num > max_heap[1]) min_insert(num);
		else max_insert(num);

		if (maxh_cnt > minh_cnt + 1) {
			min_insert(max_pop());
		}
		else if (minh_cnt > maxh_cnt) {
			max_insert(min_pop());
		}

		if (maxh_cnt == minh_cnt) printf("%d\n", min(min_heap[1], max_heap[1]));
		else printf("%d\n", max_heap[1]);
	}
	return 0;
}*/