#include <bits/stdc++.h>
using namespace std;
int t, r;
string str, ret;

string go(char ch, int n) {
    string ans;
    for(int i=0;i<n;i++) {
        ans+=ch;
    }
    return ans;
}

int main() {
    cin >> t;

    for(int i=0;i<t;i++) {
        cin >> r >> str;
        ret = "";
        for (int j = 0; j < str.size(); j++) {
            ret += go(str[j], r);
        }
        cout << ret << '\n';
    }
}