/*#include <cstdio>
using namespace std;

int a[1000000];
int n, b, c;
long long sum = 0;

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	scanf("%d %d", &b, &c);
	for (int i = 0; i < n; i++) {
		int pp = a[i];
		if (pp <= b) {
			sum++;
		}
		else {
			sum++;
			if ((pp - b) % c == 0) {
				sum += (pp - b) / c;
			}
			else {
				sum += (pp - b) / c + 1;
			}

		}
	}
	printf("%lld", sum);
	return 0;
}*/