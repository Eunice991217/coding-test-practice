#include <iostream>
#include <algorithm>
#include <map>
using namespace std;
int m, n;
map<int, int> mp;
int tmp, a[500004];

int main() {

    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    cin >> n;

    for(int i=0;i<n;i++) {
        cin >> tmp;
        mp[tmp]++;
    }

    cin >> m;

    for(int i=0;i<m;i++) {
        cin >> a[i];
        cout << mp[a[i]] << " ";
    }

    return 0;
}
