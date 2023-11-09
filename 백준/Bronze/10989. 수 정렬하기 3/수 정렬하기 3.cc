#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, arr[10004] = {0};

int main(int argc, char** argv)
{
    cin >> n;

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    for(int i=0;i<n;i++) {
        int in;
        cin >> in;
        arr[in]+=1;
    }

    for(int i=1;i<=10000;i++) {
        for(int j=0;j<arr[i];j++) {
            cout << i << '\n';
        }
    }

    return 0;
}