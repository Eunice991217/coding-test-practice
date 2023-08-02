#include<bits/stdc++.h>
using namespace std;

string str;
char v[5] = {'a', 'e', 'i', 'o', 'u'};
int main() {
    while(1) {
        cin >> str;
        
        if(str=="end") break;
        
        cout << "<" << str << "> is ";
        int flag1=0;
        int lcnt=0;
        int vcnt=0;
        
        for(int i=0;i<str.length();i++) { // 1번 조건
            for(int j=0;j<5;j++) {
                if(str[i]==v[j]) {
                    flag1=1;
                    break;
                }
            }
        }
        
        if(flag1==0) cout << "not acceptable."; // 모음이 없으면
        
        else { // 1번 조건을 통과했다면 (flag1==1)
            for(int i=0;i<str.length();i++) {
                int flag2=0;
                if(str[i]==str[i+1] && str[i]!='e' && str[i]!='o') { // 3번 조건
                    flag1=0; // 같은 글자가 연속적이라면 (e, o가 아닐때)
                    break;
                }
                else { // 3번 조건도 통과했다면
                    for(int j=0;j<5;j++) { // 2번 조건
                        if(str[i]==v[j]){
                            flag2=1;
                        }
                    }
                    if(flag2==1) { // 모음일때
                        vcnt++;
                        lcnt=0;
                    }
                    else { // 자음일때
                        lcnt++;
                        vcnt=0;
                    }
                    if(vcnt==3 || lcnt==3) { // 모음이나 자음이 3개 연속이라면
                        flag1=0;
                        break;
                    }
                }
            }
            if(!flag1) cout << "not acceptable.";
            else cout << "acceptable.";
        }
        
        cout << '\n';
        
        
    }
    
    
    
}
