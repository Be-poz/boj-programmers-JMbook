/*#include <cstdio>
#include <string>
#include <vector>

using namespace std;

bool solution(vector<string> phone_book) {
	bool answer = true;
	bool check = true;
	int vsize = phone_book.size();
	for (int i = 0; i < vsize; i++) {
		string temp = phone_book[i];
		for (int j = 0; j < vsize; j++) {
			if (i == j) continue;
			int temp_size = temp.size();
			bool temp_check = true;
			for (int k = 0; k < temp_size; k++) {
				if (temp[k] == phone_book[j][k]) continue;
				else {
					temp_check = false;
					break;
				}
			}
			if (temp_check==true) {
				check = false;
				break;
			}
		}
		if (check == false) break;
	}
	answer = check;
	return answer;
}

int main() {
	vector<string> pb;
	bool answer;
	pb.push_back("1234567890123456789");
	pb.push_back("12345678901234567860");
	pb.push_back("567");
	pb.push_back("576");
	pb.push_back("56278");
	answer = solution(pb);
	printf(answer ? "true" : "false");
	return 0;
}*/