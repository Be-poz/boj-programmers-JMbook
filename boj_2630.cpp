/*#include <stdio.h>
using namespace std;

int map[129][129] = { 0 };		//0은 white, 1은 blue 으로 하자.
int b_cnt = 0, w_cnt = 0;
void dq(int, int, int, int);

int main() {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	dq(1, n, 1, n);
	printf("%d\n%d", w_cnt, b_cnt);
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
		if (standard == 1) b_cnt++;
		else if (standard == 0) w_cnt++;
	}
	else if (check == -1) {
		dq(wf, (wl+wf) / 2, hf, (hl+hf) / 2);
		dq((wf + wl) / 2+1, wl, hf, (hl + hf) / 2 );
		dq(wf, (wl + wf) / 2, (hf + hl) / 2+1, hl);
		dq((wf + wl) / 2+1, wl, (hf + hl) / 2+1, hl);
	}
}*/