#include <bits/stdc++.h>
using namespace std;
int n;
string a[20004];
vector<pair<string, int>> v;
map<string, int> mp;

bool cmp(pair<string, int> &a, pair<string, int> &b) {
    if(a.second == b.second) return a.first<b.first; // 길이가 같으면 사전 순으로
    return a.second < b.second; // 길이가 짧은 것부터
}

int main() {

    cin >> n;

    for(int i=0;i<n;i++) {
        cin >> a[i];
        v.push_back({a[i], a[i].size()});
    }

    sort(v.begin(), v.end(), cmp);

    // 중복제거
    for(int i=0;i<n;i++) {
        if(mp[v[i].first] > 0) continue;
        else mp[v[i].first]++;
        cout << v[i].first << '\n';
    }

    return 0;
}

