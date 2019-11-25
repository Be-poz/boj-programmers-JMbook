/*#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> arr;
vector<int> arr2;
//int arr[100000] = { 0 };
//int arr2[100000] = { 0 };

int binary_search(int x,int n) {
	int left=0, right=n-1, pivot=(left+right)/2;
	while (left <= right) {
		if (x == arr[pivot]) return 1;
		if (arr[pivot] > x) {
			right = pivot - 1;
			pivot = (left + right) / 2;
		}
		else if (arr[pivot] < x) {
			left = pivot + 1;
			pivot = (left + right) / 2;
		}
	}
	return 0;
}

int main() {
	int n,m,num;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d",&num);
		arr.push_back(num);
	}
	scanf("%d", &m);
	for (int i = 1; i <= m; i++) {
		scanf("%d", &num);
		arr2.push_back(num);
	}
	sort(arr.begin(),arr.end());
	for (int i = 0; i < m; i++) {
		printf("%d\n", binary_search(arr2[i],n));
	}
	return 0;
}*/