/*#include <cstdio>
#include <vector>
#include <queue>
using namespace std;
int n, k, L;
int cnt = 0;
int ndir = 0;
int past_x = 0;
int past_y = 0;
int chk = true;
int map[102][102];
vector<pair<int, int> > snake;
vector<pair<int, int> > temp;
queue<pair<int, int> >time;			//D는 1, L은 -1로 저장
char dir[4] = { 'r','d','l','u' };	//right, down, left, up 

void check() {
	int a = snake[0].first;
	int b = snake[0].second;
	if (a == 0 || b == 0 || a == n + 1 || b == n + 1) {
		chk= false;
		return;
	}
	for (int i = 1; i < snake.size(); i++) {
		if (a == snake[i].first&&b == snake[i].second) {
			chk= false;
			return;
		}
	}
	chk= true;
	return;
}

void move() {
	int a = snake[0].first, b = snake[0].second;
	int s_size = snake.size();
	switch (ndir) {
	case 0:
		if (map[a][b + 1]) {
			temp.push_back(make_pair(a, b + 1));
			for (int i = 0; i < s_size; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
			map[a][b + 1] = 0;
		}
		else {
			temp.push_back(make_pair(a, b + 1));
			for (int i = 0; i < s_size -1; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
		}
		if (temp[0].first == snake[s_size - 1].first&&temp[0].second == snake[s_size - 1].second) {
			chk = false;
		}
		snake.clear();
		snake = temp;
		temp.clear();
		cnt++;
		break;
	case 1:
		if (map[a+1][b]) {
			temp.push_back(make_pair(a+1, b));
			for (int i = 0; i < s_size; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
			map[a+1][b] = 0;
		}
		else {
			temp.push_back(make_pair(a+1, b));
			for (int i = 0; i < s_size - 1; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
		}
		if (temp[0].first == snake[s_size - 1].first&&temp[0].second == snake[s_size - 1].second) {
			chk = false;
		}
		snake.clear();
		snake = temp;
		temp.clear();
		cnt++;
		break;
	case 2:
		if (map[a][b-1]) {
			temp.push_back(make_pair(a, b - 1));
			for (int i = 0; i < s_size; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
			map[a][b - 1] = 0;
		}
		else {
			temp.push_back(make_pair(a , b-1));
			for (int i = 0; i < s_size - 1; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
		}
		if (temp[0].first == snake[s_size - 1].first&&temp[0].second == snake[s_size - 1].second) {
			chk = false;
		}
		snake.clear();
		snake = temp;
		temp.clear();
		cnt++;
		break;
	case 3:
		if (map[a-1][b]) {
			temp.push_back(make_pair(a-1, b));
			for (int i = 0; i < s_size; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
			map[a-1][b] = 0;
		}
		else {
			temp.push_back(make_pair(a-1, b));
			for (int i = 0; i < s_size - 1; i++) {
				int x = snake[i].first;
				int y = snake[i].second;
				temp.push_back(make_pair(x, y));
			}
		}
		if (temp[0].first == snake[s_size-1].first&&temp[0].second == snake[s_size-1].second) {
			chk = false;
		}
		snake.clear();
		snake = temp;
		temp.clear();
		cnt++;
		break;
	default:
		break;
	}
}

void solve() {
	while (chk) {
		check();
		if (chk == false) break;
		move();
		if (!time.empty()&&cnt == time.front().first) {
			ndir += time.front().second;
			time.pop();
			if (ndir == 4) ndir = 0;
			if (ndir == -1) ndir = 3;
		}
	}
	printf("%d", cnt);
	return;
}

int main() {
	scanf("%d", &n);
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		map[a][b] = 1;
	}
	scanf("%d", &L);
	for (int i = 0; i < L; i++) {
		int a;
		char b;
		scanf("%d %c", &a, &b);
		if (b == 'D') time.push(make_pair(a, 1));
		if (b == 'L') time.push(make_pair(a, -1));
	}
	snake.push_back(make_pair(1, 1));
	solve();
	return 0;
}*/