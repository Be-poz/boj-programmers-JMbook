/*#include <map>
#include <vector>
#include <iostream>
#include <string>
#include <stdio.h>
#include <algorithm>
using namespace std;


bool cmp(pair<string, int> a, pair<string, int> b) {
	return a.second > b.second;
}

bool cmp2(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second) return a.first < b.first;
	else return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
	vector<int> answer;
	map<string, int> temp;
	vector<pair<string, int> > vp;
	vector<pair<string, int> > basic;

	for (int i = 0; i < genres.size(); i++) {
		temp[genres[i]] += plays[i];
		basic.push_back(make_pair(genres[i], plays[i]));
	}
	for (auto it = temp.begin(); it != temp.end(); it++) {
		vp.push_back(make_pair(it->first, it->second));
	}
	sort(vp.begin(), vp.end(), cmp);
	for (int i = 0; i < vp.size(); i++) {
		vector<pair<int, int> > tp;
		for (int j = 0; j < basic.size(); j++) {
			if (basic[j].first == vp[i].first) {
				tp.push_back(make_pair(j, basic[j].second));
			}
		}
		sort(tp.begin(), tp.end(), cmp2);
		for (int k = 0; k < 2 && k != tp.size(); k++) {
			answer.push_back(tp[k].first);
		}
	}
	return answer;
}

int main() {
	vector<int> plays;
	vector<string> genres;
	genres.push_back("classic");
	genres.push_back("pop");
	genres.push_back("classic");
	genres.push_back("classic");
	genres.push_back("pop");
	plays.push_back(500);
	plays.push_back(600);
	plays.push_back(150);
	plays.push_back(800);
	plays.push_back(2500);

	vector<int>answer = solution(genres, plays);

	for (int i = 0; i < answer.size(); i++) {
		printf("%d ", answer[i]);
	}

	return 0;
}*/