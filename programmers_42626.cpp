/*#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
	int temp = 0;
	int cnt = 0;
	int a = 0, b = 0;
	priority_queue<int, vector <int>, greater<int> >pq;
	for (int i = 0; i < scoville.size(); i++) {
		pq.push(scoville[i]);
	}
	while (pq.top() < K) {
		a = pq.top();
		pq.pop();
		if (pq.empty()) return -1;
		b = pq.top();
		pq.pop();
		pq.push(a + b * 2);
		cnt++;
	}
	return cnt;
}

int main() {
	vector<int> sco;
	sco.push_back(2);
	sco.push_back(9);
	sco.push_back(1);
	sco.push_back(10);
	sco.push_back(3);
	sco.push_back(12);
	printf("%d", solution(sco, 7));
	return 0;
}
*/