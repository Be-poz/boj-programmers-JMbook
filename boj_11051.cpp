/*#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int mod = 10007;
int c[1001][1001];

int f(int n, int k) // n���� k�� ����
{
	if (c[n][k]) return c[n][k];
	if (n == k || k == 0) return 1;
	return c[n][k] = (f(n - 1, k) + f(n - 1, k - 1)) % mod;
}

int main()
{
	int n, k;
	cin >> n >> k;
	cout << f(n, k);
	return 0;
}*/