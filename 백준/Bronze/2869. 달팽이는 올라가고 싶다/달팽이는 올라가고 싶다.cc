#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
long long a, b, v, d, sum;

int main(int argc, char** argv)
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> a >> b >> v;

    d = 1;

    d+=(v-a)/(a-b);

    if((v-a)%(a-b) != 0) {
        d++;
    }
    if(a>=v) cout << '1';
    else {
        cout << d;
    }

    return 0;
}