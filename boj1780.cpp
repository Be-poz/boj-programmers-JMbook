/*#include <stdio.h>
using namespace std;
int map[2188][2188] = { 0 };

int m_cnt = 0, z_cnt = 0, o_cnt = 0;
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
	printf("%d\n%d\n%d", m_cnt, z_cnt, o_cnt);
	return 0;
}

void dq(int wf, int wl, int hf, int hl) {
	int standard = map[hf][wf];
	int check = 1;
	for (int i = wf; i <= wl; i++) {
		for (int j = hf; j <= hl; j++) {
			if (standard != map[j][i]) {
				check *= -1;
				break;
			}
		}
		if (check == (-1)) break;
	}
	if (check == 1) {
		if (standard == (-1)) m_cnt++;
		else if (standard == 0) z_cnt++;
		else if (standard == 1) o_cnt++;
	}
	else if (check == (-1)) {
		dq(wf, wf+(wl-wf)/3, hf, hf + (hl - hf) / 3);
		dq(wf+(wl-wf)/3+1, wf+(wl-wf)*2/3, hf, hf + (hl - hf) / 3);
		dq(wf+(wl-wf)*2/3+1, wl, hf, hf + (hl - hf) / 3);

		dq(wf, wf + (wl - wf) / 3, hf+(hl-hf)/3+1,hf+(hl-hf)*2/3);
		dq(wf + (wl - wf) / 3 + 1, wf + (wl - wf) * 2 / 3, hf + (hl - hf) / 3 + 1, hf + (hl - hf) * 2 / 3);
		dq(wf + (wl - wf) * 2 / 3 + 1, wl, hf + (hl - hf) / 3 + 1, hf + (hl - hf) * 2 / 3);

		dq(wf, wf + (wl - wf) / 3,  hf+(hl-hf)*2/3+1,hl);
		dq(wf + (wl - wf) / 3 + 1, wf + (wl - wf) * 2 / 3, hf + (hl - hf) * 2 / 3 + 1, hl);
		dq(wf+(wl-wf)*2/3+1, wl, hf + (hl - hf) * 2 / 3 + 1, hl);
	}
}*/