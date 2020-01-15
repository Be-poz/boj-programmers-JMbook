/*#include <stdio.h>
#include <iostream>
#include <algorithm>

using namespace std;

const int MAX = 13;
int k;
int num[MAX];
int result[MAX];

void dfs(int start, int depth) {
	if (depth == 6)
	{
		for (int i = 0; i < depth; i++)
		{
			printf("%d ", result[i]);
		}
		printf("\n");

		return;
	}

	for (int i = start; i < k; i++)
	{
		result[depth] = num[i];
		dfs(i + 1, depth + 1);
	}
}
int main(int argc, const char * argv[]) {

	while (true)
	{
		scanf("%d", &k);
		if (k == 0) {
			printf("\n");
			break;
		}
		for (int i = 0; i < k; i++)
		{
			scanf("%d", &num[i]);
		}
		dfs(0, 0);
		printf("\n");
	}
	return 0;
}*/