#include <bits/stdc++.h>
using namespace std;
string str;
int cnt=1;

int main() {

    getline(cin, str);

    if(str[0]==' ') cnt--;

    for(int i=0;i<str.size();i++) {
        if(str[i]==' ') {
            cnt++;
        }
    }

    if(str[str.size()-1]==' ') cnt--;

    cout << cnt;

}