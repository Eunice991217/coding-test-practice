#include<bits/stdc++.h>
using namespace std;

int n, c, a[1004];
vector<pair<int, int>> vi;
map<int, int> mp, mp_first; // mp : 카운팅, mp_first : 몇번째

bool cmp(pair<int, int> a, pair<int, int> b) {
    if(a.first==b.first) return mp_first[a.second] <mp_first[b.second]; // 같다면 먼저 나온것부터
    return a.first > b.first; // 카운팅이 다르면 큰것부터
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);cout.tie(NULL);
    
    cin >> n >> c;
    
    for(int i=0;i<n;i++) {
        cin >> a[i]; // 입력받고
        mp[a[i]]++; // 입력받은 그 값을 카운팅
        if(mp_first[a[i]]==0) mp_first[a[i]]=i+1;
    }
    for(auto it : mp) {
        vi.push_back({it.second, it.first});
    }
    
    sort(vi.begin(), vi.end(), cmp);
    
    for(auto i : vi) {
        for(int j=0; j<i.first; j++) {
            cout << i.second << ' ';
        }
    }
    
    return 0;
}
