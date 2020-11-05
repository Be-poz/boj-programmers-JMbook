/*#include <cstdio>
#include <algorithm>
using namespace std;

char map[10][10];
int n, m;
char str[10];
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,-1,1 };
int rx, ry, bx, by;
int cnt = 0;
int answer = 987654321;

int inverse_dir(int dir) {
	if (dir == 0) return 1;
	if (dir == 1) return 0;
	if (dir == 3) return 4;
	if (dir == 4) return 3;
}

void move(int rx, int ry, int bx, int by, int cnt, int dir) {
	if (cnt >= answer) return;
	if (cnt > 10) return;
	bool red_flag = false;
	bool blue_flag = false;

	int nrx = rx + dx[dir];
	int nry = ry + dy[dir];
	while (true) {
		if (map[nrx][nry] == '#') break;
		if (map[nrx][nry] == 'O') {
			red_flag = true;
			break;
		}
		nrx += dx[dir];
		nry += dy[dir];
	}
	nrx -= dx[dir];
	nry -= dy[dir];

	int nbx = bx + dx[dir];
	int nby = by + dy[dir];
	while (true) {
		if (map[nbx][nby] == '#') break;
		if (map[nbx][nby] == 'O') {
			blue_flag = true;
			break;
		}
		nbx += dx[dir];
		nby += dy[dir];
	}
	nbx -= dx[dir];
	nby -= dy[dir];

	if (blue_flag) return;
	else {
		if (red_flag) {
			answer = min(answer, cnt);
			return;
		}
	}

	if (nrx == nbx && nry == nby) {
		int red_distance = abs(nrx - rx) + abs(nry - ry);
		int blue_distance = abs(nbx - bx) + abs(nby - by);
		if (red_distance > blue_distance) {
			nrx -= dx[dir];
			nry -= dy[dir];
		}
		else {
			nbx -= dx[dir];
			nby -= dy[dir];
		}
	}
	for (int i = 0; i < 4; i++) {
		if (i == dir) continue;
		if (i == inverse_dir(dir)) continue;

		move(nrx, nry, nbx, nby, cnt + 1, i);
	}
}

void search() {
	for (int i = 0; i < 4; i++) {
		move(rx, ry, bx, by, 1, i);
	}
	if (answer == 987654321 || answer > 10) answer = -1;
	printf("%d", answer);
}



int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%s", str);
		for (int j = 0; j < m; j++) {
			if (str[j] == 'R') {
				rx = i;
				ry = j;
				map[i][j] = '.';
			}
			else if (str[j] == 'B') {
				bx = i;
				by = j;
				map[i][j] = '.';
			}
			else map[i][j] = str[j];
		}
	}
	search();
	return 0;
}*/