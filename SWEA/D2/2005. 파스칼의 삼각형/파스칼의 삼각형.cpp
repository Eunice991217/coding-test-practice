#include<iostream>
using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin >> T;

    for(test_case = 1; test_case <= T; ++test_case)
    {
        int n, a[10][10];
        cin >> n;

        cout << "#" << test_case << '\n';

        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) {
                    a[i][j] = 1;
                    cout << a[i][j] << ' ';
                }
                else {
                    a[i][j]= a[i-1][j-1] + a[i-1][j];
                    cout << a[i][j] << ' ';
                }
            }
            cout << '\n';
        }
    }

    return 0;
}