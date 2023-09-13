#include <bits/stdc++.h>
using namespace std;
int num[8];

string go(int *num) {
    string ans="";
    int aCnt=0, dCnt=0;

    for(int i=0;i<8;i++) {
        if(num[i]==i+1) {
            aCnt++;
        }
        else if(num[i]==8-i) {
            dCnt++;
        }
    }

    if(aCnt==8) ans="ascending";
    else if(dCnt==8) ans="descending";
    else ans = "mixed";

    return ans;
}

int main() {

    for(int i=0;i<8;i++) {
        cin >> num[i];
    }

    cout << go(num);

}