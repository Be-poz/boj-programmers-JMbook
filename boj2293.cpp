/*#include <iostream>
using namespace std;

int memo[ 10001 ] = { 1 }, coin[101];

int main() {
	int n, k, i, j;
	cin >> n >> k;

	for (int i = 1; i <= n; i++) {
		cin >> coin[i];

		for (j = coin[i]; j <= k; j++) {
			memo[j] += memo[j - coin[i]];
		}
	}
	cout << memo[k] << endl;
	return 0;
}*/