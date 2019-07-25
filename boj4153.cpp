/*#include<stdio.h>
#include<algorithm>
#include <cmath>
using namespace std;
int main() {
	int a, b, c, highest, min1, min2;
	scanf("%d %d %d", &a, &b, &c);
	while (a&&b&&c) {
		highest = max(max(a, b),c);
		if (a == highest) {
			min1 = b; 
			min2 = c;
		}
		else if (b == highest) {
			min1 = a; 
			min2 = c;
		}
		else { 
			min1 = a; 
			min2 = b; 
		}
		if (pow(highest, 2) == pow(min1, 2) + pow(min2, 2)) printf("right\n");
		else printf("wrong\n");
		scanf("%d %d %d", &a, &b, &c);
	}

	return 0;
}*/