/*#include <stdio.h>
#include <iostream>
#include <deque>
#include <string>
using namespace std;

deque<int> dq;

int main() {
	bool check = true;
	int T,n,num=0;
	int idx = 0;
	string x,cmnd;
	scanf("%d", &T);
	while (T--) {
		dq.clear();
		check = true;
		idx = 0;			//error �Ǻ��ϱ� ���� ����
		cin >> cmnd;		//��ɾ� ����
		scanf("%d", &n);
		cin >> x;

		if (n != 0) {
			for (int i = 1; i < x.length(); i++) {
				if (x[i] >= '0'&&x[i] <= '9') {		//���� ��� ������ 10�� ���ذ�.
					num *= 10;
					num += x[i] - '0';
				}
				else {
					dq.push_back(num);
					num = 0;
				}
			}
		}
		for (int i = 0; i < cmnd.length(); i++) {
			if (cmnd[i] == 'D') {						//D�� ���
				if (dq.empty()) {
					printf("error\n");
					idx = 1;
					break;
				}
				else if(check==true) dq.pop_front();
				else if (check == false) dq.pop_back();
			}
			else if (cmnd[i] == 'R') {					//R�� ���
				if (check == true)check = false;
				else check = true;
			}
		}
		if (idx == 1) continue;
		if (check == true) {
			printf("[");
			for (int i = 0; i < dq.size(); i++) {
				if (i == (dq.size() - 1)) printf("%d", dq[i]);
				else printf("%d,", dq[i]);
			}
			printf("]\n");
		}
		else if (check == false) {
			printf("[");
			for (int i = (dq.size() - 1); i >= 0; i--) {
				if (i == 0) printf("%d", dq[i]);
				else printf("%d,", dq[i]);
			}
			printf("]\n");
		}

	}
	return 0;
}*/