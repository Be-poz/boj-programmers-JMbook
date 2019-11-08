#include <iostream>
#include <stack>
#include <cstring>

int result[1000001];

int main() {
	int n;
	memset(result, -1, sizeof(result));
	std::stack<std::pair<int, int>> s;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		int cur;
		std::cin >> cur;
		if (s.size() == 0) s.push({ cur, i });
		else {
			while (cur > s.top().first) {
				result[s.top().second] = cur;
				s.pop();
				if (s.size() == 0) break;
			}
			s.push({ cur, i });
		}
	}
	for (int i = 0; i < n; i++) std::cout << result[i] << " ";
}