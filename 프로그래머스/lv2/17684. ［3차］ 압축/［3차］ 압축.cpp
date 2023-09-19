#include <bits/stdc++.h>
using namespace std;

map<string, int> mp; // dictionary
string msg; // 입력 받는 문자열
int num=1;

void init() { // 사전 초기화
    char ch;
    for(char c='A'; c<='Z'; c++) { // A~Z까지
        string str="";
        str+=c; // char to string
        mp[str]=num++; // 1부터 대입
    }
}

vector<int> solution(string input) { // 색인 번호 출력 및 사전 추가
    vector<int> ans; // 출력 되는 색인 번호 배열
    int len = input.length(); // 문자열 길이
    string ret="";

    init(); // 사전 초기화

    for(int i=0;i<len;i++) { // 입력 받은 문자열 길이 만큼
        ret+=input[i];
        if(mp[ret]==0) { // 사전에 없을 때
            mp[ret] = num++; // 사전에 추가
            ret = ret.substr(0, ret.length()-1);
            ans.push_back(mp[ret]);
            ret="";
            i--;
        }
    }
    ans.push_back(mp[ret]); // 처리 되지 않은 글자 색인 번호 입력

    return ans;
}