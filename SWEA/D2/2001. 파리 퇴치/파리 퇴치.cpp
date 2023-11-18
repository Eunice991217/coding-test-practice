#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;
int n, m, a[15][15];

int box(int x, int y) {
    int sum=0;

    for(int i=x;i<x+m;i++) {
        for(int j=y;j<y+m;j++) {
            sum+=a[i][j];
        }
    }

    return sum;
}

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
    {

        cin >> n >> m;
        int maxCount=-1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                cin>>a[i][j];
            }
        }

        cout << "#" << test_case << ' ';

        for(int i=0;i<=n-m;i++){
            for(int j=0;j<=n-m;j++) {
                maxCount=max(maxCount, box(i, j));
            }
        }

        cout << maxCount << '\n';
    }
    return 0;
}