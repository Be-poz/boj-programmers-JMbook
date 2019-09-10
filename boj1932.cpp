#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int n, maxt;
	int ** triangle;
	int ** maximum;
	triangle = new int*[500];
	maximum = new int*[500];
	for (int i = 0; i < 500; ++i) {
		triangle[i] = new int[500];
		maximum[i] = new int[500];
	}
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i+1; j++) {
			scanf("%d", &triangle[i][j]);
		}
	}
	maximum[0][0] = triangle[0][0];
	for (int i = 1; i < n; ++i) {
		for (int j = 0; j < i + 1; ++j) {
			if (j == 0) { maximum[i][j] = maximum[i - 1][0] + triangle[i][j]; }
			else if (j == i) { maximum[i][j] = maximum[i - 1][i - 1] + triangle[i][j]; }
			else { maximum[i][j] = max(maximum[i - 1][j - 1], maximum[i - 1][j]) + triangle[i][j]; }
		}
	}
	maxt = maximum[n - 1][0];
	for (int i = 1; i < n; ++i) {
		if (maxt < maximum[n - 1][i]) maxt = maximum[n - 1][i];
	}
	printf("%d", maxt);
	free(triangle);
	free(maximum);
	return 0;
}