/*#include <cstdio>
#include <algorithm>
#include <queue>
using namespace std;

int n, m;
int depth = 0;
int sum = 0;
int max_sum = 0;
int map[502][502];
int visit[502][502];
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,-1,1 };

void angle(int opt) {
	switch (opt) {
	case 0: {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m - 3; j++) {
				sum = 0;
				sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 1: {
		for (int i = 1; i <= n - 3; i++) {
			for (int j = 1; j <= m; j++) {
				sum = 0;
				sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 2: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 3: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i][j] + map[i + 1][j] + map[i+1][j + 1] + map[i + 1][j + 2];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 4: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i+2][j] + map[i + 2][j+1] + map[i + 1][j + 1] + map[i][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 5: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i][j] + map[i][j + 1] + map[i ][j + 2] + map[i+1][j + 2];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 6: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 7: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i+1][j] + map[i + 1][j+1] + map[i + 1][j+2] + map[i][j + 2];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 8: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i+2][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 9: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 10: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i + 2][j+1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 11: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i+1][j] + map[i + 1][j+1] + map[i][j+1] + map[i][j + 2];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 12: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i][j] + map[i + 1][j] + map[i+1][j + 1] + map[i+2][j +1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 13: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i][j] + map[i ][j+1] + map[i + 1][j + 1] + map[i + 1][j + 2];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 14: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i+1][j] + map[i+2][j] + map[i ][j + 1] + map[i + 1][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 15: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i + 1][j] + map[i][j+1] + map[i+1][j + 1] + map[i + 1][j + 2];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 16: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i + 1][j] + map[i ][j+1] + map[i+1][j + 1] + map[i + 2][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 17: {
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 2; j++) {
				sum = 0;
				sum = map[i][j] + map[i][j+1] + map[i][j + 2] + map[i + 1][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	case 18: {
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 1; j++) {
				sum = 0;
				sum = map[i][j] + map[i + 1][j] + map[i+2][j] + map[i + 1][j + 1];
				max_sum = max(sum, max_sum);
			}
		}
		break;
	}
	default: break;
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	for (int i = 0; i < 23; i++) {
		angle(i);
	}
	printf("%d", max_sum);
	return 0;
}*/