#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, idx=0;
vector<pair<int, string>> v;

bool cmp(pair<int, string> x, pair<int, string> y) {
    return x.first < y.first;
}

int main(int argc, char** argv)
{
    cin >> n;
    for(int i=0;i<n;i++) {
        int age;
        string name;
        cin >> age >> name;
        v.push_back({age, name});
    }

    stable_sort(v.begin(), v.end(), cmp);

    for(int i=0;i<n;i++) {
        cout << v[i].first << ' ' << v[i].second << '\n';
    }

    return 0;
}