/*#include <stdio.h>
#include <cstring>
#include <cmath>
#include <string>
int main() {
	int n, cnt;
	bool* chk;
	scanf("%d", &n);
	while (n != 0) {
		cnt = 0;
		chk = new bool[2 * n + 1];
		memset(chk, true, sizeof(bool)*(2 * n + 1));
		chk[1] = false;
		for (int i = 2; i <= 2 * n; i++) {

			if (chk[i] == false) continue;
			else {
				for (long long j = 1LL*i*i; j <= 2 * n; j += i) {
					chk[j] = false;
				}
			}
		}
		for (int i = n+1; i <= 2 * n; i++) {
			if (chk[i] == true) cnt++;
		}
		printf("%d\n", cnt);
		delete[]chk;
		scanf("%d", &n);
	}
	return 0;
}*/