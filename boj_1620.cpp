/*#include <stdio.h>
#include <map>
#include <string>
#include <iostream>

using namespace std;
int n, m;
char temp[21];
string poke_collect[100000];
map<string, int> mm;

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%s", temp);
		mm.insert(make_pair(temp, i));
		poke_collect[i] = temp;
	}
	for (int i = 0; i < m; i++) {
		scanf("%s", temp);
		if (isdigit(temp[0])) {
			cout << poke_collect[atoi(temp) - 1]<<'\n';
		}
		else {
			string poke = temp;
			printf("%d\n", mm.find(poke)->second+1);
		}
	}
	return 0;
}*/