//#include<stdio.h>
//
//int main() {
//	int a, b,sum=0,cnt=0,min;
//	bool idx;
//	scanf("%d %d", &a, &b);
//	for (int i = a; i <= b; i++) {
//		idx = true;
//		if (i == 1) continue;
//		if (i == 2) {
//			cnt++;
//			min = 2;
//			sum += 2; continue;
//		}
//		for (int j = 2; j < i; j++) {
//			if (i%j == 0) idx = false;
//		}
//		if (idx == true) {
//			cnt++;
//			if (cnt == 1) min = i;
//			sum += i;
//		}
//	}
//	if (sum != 0) {
//		printf("%d\n", sum);
//		printf("%d", min);
//	}
//	else printf("-1");
//	return 0;
//}