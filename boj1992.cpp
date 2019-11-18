/*#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

int map[129][129] = { 0 };		
void dq(int, int, int, int);

int main() {
	int n;
	char temp[65] = { 0 };
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		cin >> temp;
		for (int j = 1; j <= n; j++) {
			map[i][j] = temp[j - 1]-'0';
		}
	}
	dq(1, n, 1, n);
	return 0;
}

void dq(int wf, int wl, int hf, int hl) {		//wide_first, wide_last, height_first, height_last
	int standard = map[hf][wf];
	int check = 1;
	for (int i = hf; i <= hl; i++) {
		for (int j = wf; j <= wl; j++) {
			if (map[i][j] != standard) {
				check *= -1;
				break;
			}
		}
		if (check == (-1)) break;
	}
	if (check == 1) {
		if (standard == 1) printf("1");
		else if (standard == 0) printf("0");
	}
	else if (check == -1) {
		printf("(");
		dq(wf, (wl + wf) / 2, hf, (hl + hf) / 2);
		dq((wf + wl) / 2 + 1, wl, hf, (hl + hf) / 2);
		dq(wf, (wl + wf) / 2, (hf + hl) / 2 + 1, hl);
		dq((wf + wl) / 2 + 1, wl, (hf + hl) / 2 + 1, hl);
		printf(")");
	}
}*/