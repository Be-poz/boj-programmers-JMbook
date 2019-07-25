/*#include <stdio.h>
#include<iostream>
#include <cmath>
#include<cstring>
using namespace std;
int main() {
	int chk[10001];
	fill_n(chk, 10001, 1);
	int n, value, a, b;
	chk[0] = 0; chk[1] = 0;
	for (int i = 2; i < sqrt(10001); i++) {
		if (chk[i] == 0) continue;
		else {
			for (long long j = 1LL * i * i; j < 10001; j += i) {
				chk[j] = 0;
			}
		}
	}
	scanf("%d", &n);
	while (n--) {
		scanf("%d", &value);
		for (int i = 2; i < value / 2 + 1; i++) {
			if (chk[i] == 1) {
				if (chk[value - i] == 1) {
					a = i; b = value - i;
				}
			}
		}
		printf("%d %d\n", a, b);
	}
	return 0;
}*/