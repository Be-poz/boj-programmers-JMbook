#include <stdio.h>
#include <deque>
using namespace std;
deque<int> dq;

deque<int> left_rotate(deque<int> dq);
int cnt = 0;
int arr[50] = { 0 };

int main(){
	int x, y, z = 0, cnt = 0, temp_x, temp = 0;
	scanf("%d %d", &x, &y);
	temp_x = x;
	for (int i = 1; i <= x; i++) {
		dq.push_back(i);
	}
	for (int i = 0; i < y; i++) {
		scanf("%d", &arr[i]);
	}


	while(true) {
		while (!(dq.front() == arr[z])) {
			dq = left_rotate(dq);
			temp++;
		}
		if (temp > (temp_x / 2)) {
			cnt += (temp_x-temp);
		}
		else cnt += temp;

		dq.pop_front();
		temp = 0;
		temp_x--;
		z++;
		if (z == y) break;
	}

	printf("%d", cnt);
	return 0;
}

deque<int> left_rotate(deque<int> dq) {
	int temp = dq.front();
	dq.push_back(temp);
	dq.pop_front();
	return dq;
}