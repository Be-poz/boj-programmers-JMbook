/*#include<stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int cost[1000][3] = { 0 };
	int minimum[1000][3] = { 0 };
	int n,result;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &cost[i][0], &cost[i][1], &cost[i][2]);
	}
	minimum[0][0] = cost[0][0], minimum[0][1] = cost[0][1], minimum[0][2] = cost[0][2];
	for (int i = 1; i < n; i++) {
		minimum[i][0] = cost[i][0] + min(minimum[i - 1][1], minimum[i - 1][2]);
		minimum[i][1] = cost[i][1] + min(minimum[i - 1][0], minimum[i - 1][2]);
		minimum[i][2] = cost[i][2] + min(minimum[i - 1][0], minimum[i - 1][1]);
	}
	result = min(min(minimum[n - 1][0], minimum[n - 1][1]), minimum[n - 1][2]);
	printf("%d", result);
	return 0;
}*/