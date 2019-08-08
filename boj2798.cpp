/*#include <stdio.h>
#include <algorithm>

int main() {
	int *card;
	int N, M,sum=0,max;
	scanf("%d %d", &N, &M);
	card = new int[N];
	for (int i = 0; i < N; i++) {
		scanf("%d", &card[i]);
	}
	std::sort(card, card + N);
	max = card[0] + card[1] + card[2];
	for (int i = 0; i < N - 2; i++) {
		for (int j = i + 1; j < N - 1; j++) {
			for (int k = j + 1; k < N; k++) {
				sum = card[i] + card[j] + card[k];
				if (sum > max&&sum<=M) max = sum;
			}
		}
	}
	printf("%d\n", max);
	delete []card;
	return 0;
}*/