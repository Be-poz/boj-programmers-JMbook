#include <cstdio>
#include <malloc.h>
#include <algorithm>
#include <cstring>
using namespace std;

int main() {
	int n,i=0;
	int* array;
	scanf("%d", &n);
	array = new int[n];
	memset(array, 0, sizeof(int)*n);
	for(i=0;i<n;i++){
		scanf("%d", &array[i]);
	}
	sort(array, &array[n]);
	for (int i = 0; i <n; i++) {
		printf("%d\n", array[i]);
	}
	return 0;

}