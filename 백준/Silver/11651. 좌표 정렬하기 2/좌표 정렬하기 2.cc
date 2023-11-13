#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<pair<int, int>> v;

bool cmp(pair<int, int> a, pair<int, int> b) {
    if(a.second==b.second) {
        return a.first < b.first;
    }
    return a.second < b.second;
}

int main(int argc, char** argv)
{

    cin >> n;

    for(int i=0;i<n;i++) {
        int x, y;
        cin >> x >> y;
        v.push_back({x,y});
    }

    sort(v.begin(), v.end(), cmp);

    for(auto i : v) {
        cout << i.first << ' ' << i.second << '\n';
    }

    return 0;
}