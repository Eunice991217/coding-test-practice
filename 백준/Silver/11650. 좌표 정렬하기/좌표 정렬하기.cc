#include <iostream>
#include <algorithm>
using namespace std;
int T;
pair<int, int> p[100004];

bool compare(pair<int, int> a, pair<int, int> b) {
    if(a.first > b.first) {
        return a.first > b.first;
    }
    else if(a.first < b.first) {
        return a.first < b.first;
    }
    else { // a.first == b.first
        return a.second < b.second;
    }
}

int main() {

    cin >> T;
    for(int i=0;i<T;i++) {
        cin >> p[i].first >> p[i].second;
    }

    sort(p, p+T);

    for(int i=0;i<T;i++) {
        cout << p[i].first << " " << p[i].second <<'\n';
    }

    return 0;
}
