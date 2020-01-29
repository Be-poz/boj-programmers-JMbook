/*#include <cstdio>
#include <iostream>
#include <string>
#include <utility>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
vector<string> temp;
vector<pair<string,int> > temp2;
int visit[20000];
int depth = 0;

bool cmp(pair<string,int> a, pair<string,int> b) {
	return a.first < b.first;
}

void dfs(vector<vector<string> >tickets,string target) {
	temp2.clear();
	int vsize = tickets.size();
	if (depth == vsize) return;
	for (int i = 0; i < vsize; i++) {
		if (target == tickets[i][0]&&visit[i]==0) {
			temp2.push_back(make_pair(tickets[i][1],i));
		}
	}
	sort(temp2.begin(), temp2.end(), cmp);
	depth++;
	visit[temp2[0].second] = 1;
	temp.push_back(temp2[0].first);
	dfs(tickets, temp2[0].first);
	if (depth == vsize) return;

	depth--;
	temp.pop_back();
}

vector<string> solution(vector<vector<string>> tickets) {
	temp.push_back("ICN");
	dfs(tickets,"ICN");
	return temp;
}

int main() {
	vector<vector<string> > tickets = { {"ICN","COO"},{"ICN","BOO"},{"COO","ICN"},{"BOO","DOO"}};
	vector<string> answer;
	answer = solution(tickets);
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << endl;
	}
	return 0;
}*/