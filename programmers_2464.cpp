/*#include <cstdio>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> budgets, int M) {
	int answer = 0;
	int vsize = budgets.size() - 1;
	sort(budgets.begin(), budgets.end());
	int left = 0;
	int right = budgets[vsize];
	int pivot = (left + right) / 2;
	int temp = 0;
	int sum = 0;
	while (true) {
		sum = 0;
		for (int i = 0; i <= vsize; i++) {
			if (budgets[i] > pivot) sum += pivot;
			else sum += budgets[i];
		}
		if (sum == M) {
			answer = pivot;
			break;
		}
		else if (sum > M) {
			right = pivot - 1;
		}
		else left = pivot + 1;
		pivot = (left + right) / 2;
		if (right<left) {
			answer = right;
			break;
		}
	}
	return answer;
}

int main() {
	vector<int> bud;
	bud.push_back(120);
	bud.push_back(110);
	bud.push_back(140);
	bud.push_back(150);
	printf("%d", solution(bud,485));
	return 0;
}*/