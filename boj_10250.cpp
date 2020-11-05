//#include <stdio.h>
//
//int main() {
//	int n, h, w, value;
//	scanf("%d", &value);
//	while (value--) {
//		scanf("%d %d %d", &h, &w, &n);
//		if (n%h != 0) {
//			if (n / h + 1 >= 10) {
//				printf("%d\n", (n%h) * 100 + (n / h + 1));
//			}
//			else {
//				printf("%d\n", (n%h) * 100 + (n / h + 1));
//			}
//		}
//		else {
//			if (n / h + 1 >= 10) {
//				printf("%d\n", (h) * 100 + (n / h));
//			}
//			else {
//				printf("%d\n", (h) * 100 + (n / h ));
//			}
//		}
//	}
//	return 0;
//}