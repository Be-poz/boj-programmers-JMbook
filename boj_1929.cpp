/*#include<stdio.h>
#include<string>
#include<cstring>
#include<cmath>

int main() {
	int a, b;
	bool* che;
	scanf("%d %d", &a, &b);
	che = new bool[b + 1];
	memset(che, true, sizeof(bool)*(b + 1));
	che[1] = false;
	for (int i = 2; i <= b; i++) {
		if (che[i] == false) continue;
		else {
			for (int j = i * i; j <= b; j += i) {
				che[j] = false;
			}
		}
	}
	for (int i = a; i <= b; i++) {
		if (che[i] == true) printf("%d\n", i);
	}
	delete[]che;
	return 0;
}*/