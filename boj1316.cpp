#include<iostream>
#include <string>
#include<cstring>
using namespace std;
int main() {
	bool chk[26];
	memset(chk, false, sizeof(chk));
	int num,cnt=0;
	cin >> num;
	string word;
	char here, prev;
	for (int i = 0; i < num; i++) {
		cin >> word;
		chk[word[0] - 'a'] = true;
		here = word[0];
		if (word.size() == 1)cnt++;
		for (int j = 1; j < word.size(); j++) {
			prev = here;
			here = word[j];
			if (here == prev) {
			}
			else {
				if (chk[word[j] - 'a'] == true) break;
				else chk[word[j] - 'a'] = true;
			}
			if (j == word.size() - 1) cnt++;
		}
		memset(chk, false, sizeof(chk));
	}
	cout << cnt;
	return 0;
}