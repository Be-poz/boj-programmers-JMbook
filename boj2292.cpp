#include <cstdio>
#include <math.h>
int main() {
	int a, cnt = 1;
	scanf("%d", &a);
	while (a > 3 * pow(cnt, 2) - 3 * cnt + 1) {
		cnt++;
	}
	printf("%d", cnt);
}