/*#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iostream>
using namespace std;
int era[10000000];
int visit[10000000];
vector<int> temp;
vector<int> save;
void eratos() {
	era[0] = 1, era[1] = 1;
	for (int i = 2; i < sqrt(10000000); i++) {
		if (!era[i]) {
			for (int j = 2; j*i < 10000000; j++) era[j*i] = 1;
		}
	}
}

void dfs(vector<int> num, int max, int depth) {
	int vsize = num.size();
	if (max == depth) {
		int value = 0;
		for (int j = 0; j < temp.size(); j++) {
			value += temp[j] * pow(10, temp.size() - 1 - j);
		}
		save.push_back(value);
		return;
	}
	for (int i = 0; i < vsize; i++) {
		if (!visit[i]) {
			temp.push_back(num[i]);
			visit[i] = 1;
			dfs(num, max, ++depth);
			temp.pop_back();
			visit[i] = 0;
			depth--;
		}
	}
}

int solution(string numbers) {
	eratos();
	int answer = 0;
	vector<int> num;
	for (int i = 0; i < numbers.size(); i++) {
		num.push_back(numbers[i] - '0');
	}
	for (int i = 1; i <= numbers.size(); i++) {
		dfs(num, i, 0);
		temp.clear();
	}
	sort(save.begin(), save.end());
	save.erase(unique(save.begin(), save.end()), save.end());
	for (int i = 0; i < save.size(); i++) {
		if (!era[save[i]]) answer++;
	}
	return answer;
}*/