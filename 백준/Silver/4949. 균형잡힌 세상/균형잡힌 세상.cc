#include<bits/stdc++.h>
using namespace std;

int n;
string s;

int main(void){
    
    while(1) {
        getline(cin, s);
        if(s==".") break;
        
        stack<char> stk;
        int flag=0;
        for (char a : s) {
            if(a=='(' || a=='[') {
                stk.push(a);
            }
            else if (a==')'){
                if(!stk.empty() && stk.top()=='(') {
                    stk.pop();
                }
                else {
                    flag=1;
                    continue;
                }
            }
            else if (a==']') {
                if(!stk.empty() && stk.top()=='[') {
                    stk.pop();
                }
                else {
                    flag=1;
                    continue;
                }
            }
        }
        
        if(flag) {
            cout << "no\n";
        }
        
        else {
            if(stk.empty() && stk.empty()) {
                cout << "yes\n";
            }
            else {
                cout << "no\n";
            }
        }
        
        
        
    }
    
    
    
}
