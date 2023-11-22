#include <string>
#include <vector>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int solution(string s) {
    int answer = 0;
    string tmp="";
    string ret="";
    
    for(int i=0;i<s.length();i++) {
        tmp+=s[i];
        if(tmp=="one") {
            tmp="";
            ret+='1';
        }
        else if(tmp=="two") {
            tmp="";
            ret+='2';
        }
        else if(tmp=="three") {
            tmp="";
            ret+='3';
        }
        else if(tmp=="four") {
            tmp="";
            ret+='4';
        }
        else if(tmp=="five") {
            tmp="";
            ret+='5';
        }
        else if(tmp=="six") {
            tmp="";
            ret+='6';
        }
        else if(tmp=="seven") {
            tmp="";
            ret+='7';
        }
        else if(tmp=="eight") {
            tmp="";
            ret+='8';
        }
        else if(tmp=="nine") {
            tmp="";
            ret+='9';
        }
        else if(tmp=="zero") {
            tmp="";
            ret+='0';
        }
        else if(tmp=="1" || tmp=="0" || tmp=="2" || tmp=="3" || tmp=="4" || tmp=="5" || tmp=="6" || tmp=="7" || tmp=="8" || tmp=="9"){
            ret+=tmp;
            tmp="";
        }
    }
    
    answer = stoi(ret);
    
    return answer;
}