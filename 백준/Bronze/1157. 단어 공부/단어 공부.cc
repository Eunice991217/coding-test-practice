#include <bits/stdc++.h>
using namespace std;
string str;
int num[26];

char go(string str) {
    char ch;
    int maxCnt=0;
    int index=-1;

    for (int i = 0; i < str.size(); i++) {
        str[i] = toupper(str[i]);
        num[str[i]-'A']++;
    }

    for(int i=0;i<26;i++) {
        if(maxCnt < num[i]) {
            maxCnt = num[i];
            index = i;
        }
    }

    for(int i=0;i<26;i++) {
        if(i==index) continue;
        if(num[i] == maxCnt) {
            return '?';
        }
    }

    ch = (char)(index+'A');
    return ch;
}

int main() {
    char ch;

    cin >> str;

    cout <<  go(str);

}