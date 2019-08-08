/*#include <stdio.h>

int main() {
	int n,a1,a2,a3,a4,a5,a6;
	scanf("%d", &n);
	for (int i = 1; i < 1000000; i++) {
		a1 = i / 100000;
		a2 = i % 100000 / 10000;
		a3 = i % 10000 / 1000;
		a4 = i % 1000 / 100;
		a5 = i % 100 / 10;
		a6 = i % 10;
		if (n == (a1 + a2 + a3 + a4 + a5 + a6 + i)) {
			printf("%d\n", i);
			break;
		}
		if (i == 999999)printf("0\n");
	}
	return 0;
}*/