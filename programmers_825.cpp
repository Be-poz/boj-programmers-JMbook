/*#include <cstdio>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr) {
	int answer = 0;
	int vsize = arr.size() - 1;
	int stan = arr[vsize];
	int idx = 1;
	int check = 1;
	while (true) {
		int des = stan * idx;
		for (int i = 0; i <= vsize; i++) {
			if (!(des%arr[i])) continue;
			else {
				check = 0; break;
			}
		}
		if (check == 1) {
			answer = des;
			break;
		}
		else {
			check = 1;
			idx++;
		}
	}
	return answer;
}

int main() {
	vector<int> arr;
	arr.push_back(2);
	arr.push_back(6);
	arr.push_back(8);
	arr.push_back(14);
	printf("%d", solution(arr));
	return 0;
}*/