/*#include <cstdio>
#include <string>
#include <vector>
#include <queue>
int arr[52][52];
int visit[51];
using namespace std;

int bfs(int start, int goal,int vsize) {
	queue<int> q;
	q.push(start);
	visit[start] = 0;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (int i = 0; i < vsize; i++) {
			if (visit[i] == 0 && arr[x][i] == 1) {
				q.push(i);
				visit[i] = visit[x] + 1;
				if (i == goal) return visit[i];
			}
		}
	}
}

int word_cmp(string a, string b) {
	int size = a.size();
	int cnt = 0;
	for (int i = 0; i < size; i++) {
		if (a[i] != b[i]) cnt++;
	}
	if (cnt == 1) return 1;
	else return 0;
}

int solution(string begin, string target, vector<string> words) {
	int answer = 0;
	words.push_back(begin);
	int vsize = words.size();
	int end=(-1);
	for (int i = 0; i < vsize; i++) {
		if (words[i] == target) end = i;
	}
	if (end == (-1)) return 0;

	for (int i = 0; i < vsize; i++) {
		for (int j = 0; j < vsize; j++) {
			if (i == j) arr[i][j] = 0;
			else if (word_cmp(words[i], words[j]) == 1) arr[i][j] = 1;
		}
	}
	answer=bfs(vsize-1, end,vsize);
	return answer;
}

int main() {
	vector<string> words;
	words.push_back("hot");
	words.push_back("dot");
	words.push_back("dog");
	words.push_back("lot");
	words.push_back("log");
	words.push_back("cog");
	printf("%d", solution("hit", "cog", words));
	return 0;
}*/