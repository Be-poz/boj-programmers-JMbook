/*#include <stdio.h>
using namespace std;

long long dq(long long a, long long b, long long c) {
	long long result=0;
	if (b == 0) return 1;
	if (b == 1) {
		return a%c;
	}
	if (b % 2==0) {
		result = (dq(a, b / 2, c)%c)*(dq(a, b / 2, c)%c)%c;
	}
	else if (b % 2 == 1) {
		result = (a%c * dq(a, b - 1, c)%c)%c;
	}
	return result;
}

int main() {
	long long a, b, c;
	scanf("%lld %lld %lld", &a, &b, &c);
	printf("%lld", dq(a,b,c));
	return 0;
}*/