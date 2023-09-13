#include <bits/stdc++.h>
using namespace std;
string str;
int num[26];

char go(string str) {
    int maxCnt=0;
    int index=0;

    for(int i=0;i<str.size();i++){
        str[i] = toupper(str[i]); // 다 대문자로 변경 (대소문자 구분 없으므로)
        num[str[i]-'A']++;
    }

    for(int i=0;i<26;i++) {
        if(num[i] > maxCnt) {
            maxCnt = num[i];
            index = i;
        }
    }

    for(int i=0;i<26;i++) {
        if(index==i) continue;
        if(num[i]==maxCnt) {
            return '?';
        }
    }

    return (char)(index+'A');
}

int main() {
    char ch;

    cin >> str;

    cout << go(str);

}