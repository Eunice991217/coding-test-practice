#include<bits/stdc++.h>
using namespace std;

int n, o, A, B, asum, bsum;
string s, pre;

string print(int a) {
    string d = "00" + to_string(a/60);
    string e = "00" + to_string(a%60);
    // 00을 더하고 뒤에서부터 사이즈 2만 자르기
    return d.substr(d.size()-2,2) + ":" + e.substr(e.size()-2,2);
}

int changeToInt(string a) {
    return atoi(a.substr(0,2).c_str())* 60 + atoi(a.substr(3,2).c_str());
}

void go(int &sum, string s) {
    sum += (changeToInt(s) - changeToInt(pre));
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    
    for(int i=0;i<n;i++){
        cin >> o >> s;
        if(A>B) go(asum,s);
        else if(A<B) go(bsum, s);
        o == 1 ? A++ : B++; // 1팀이면 A++, 2팀이면 B++
        pre = s;
    }
    
    // 끝점처리!
    if(A>B) go(asum, "48:00");
    else if(A<B) go(bsum, "48:00");
    
    cout << print(asum) << '\n';
    cout << print(bsum) << '\n';

}
