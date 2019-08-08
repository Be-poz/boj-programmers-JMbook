/*#include    <iostream>
#include    <cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	int T;
	cin >> T;

	for (int i = 1; i <= T; ++i)
	{
		int x1, y1, r1, x2, y2, r2;
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		int bx, by, br, sx, sy, sr;//big, small
		if (r1 > r2)
		{
			bx = x1; by = y1; br = r1;
			sx = x2; sy = y2; sr = r2;
		}
		else
		{
			bx = x2; by = y2; br = r2;
			sx = x1; sy = y1; sr = r1;
		}

		//point to point
		double p2p = sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));

		if (p2p < br)
		{
			if (bx == sx && by == sy && br == sr)
				cout << -1 << endl;
			else if (sr + p2p == br)
				cout << 1 << endl;
			else if (sr + p2p > br)
				cout << 2 << endl;
			else
				cout << 0 << endl;
		}
		else if (p2p > br)
		{
			if (p2p == br + sr)
				cout << 1 << endl;
			else if (p2p > br + sr)
				cout << 0 << endl;
			else
				cout << 2 << endl;
		}
		else//p2p == br
			cout << 2 << endl;

	}

	return 0;
}*/