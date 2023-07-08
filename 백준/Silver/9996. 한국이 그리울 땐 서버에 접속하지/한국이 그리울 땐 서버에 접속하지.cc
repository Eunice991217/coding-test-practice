#include <bits/stdc++.h>
using namespace std;

int main()
{
    string str, pattern;
    int n;
    
    cin >> n;
    cin >> pattern;
    
    int pos = pattern.find('*');
    string first = pattern.substr(0, pos); // 별표까지 자르고
    string last = pattern.substr(pos+1, pattern.length()); // 별표부터 끝까지 자르고
    
    for(int i=0;i<n;i++) {
        cin >> str; // 문자열 입력받고
        if(str.length() < first.length() + last.length()) {
            cout << "NE" << "\n";
            continue;
        }
        
        string strFirst = str.substr(0,first.length());
        string strLast = str.substr(str.length()-last.length(), str.length());
        
        if(first==strFirst && last==strLast) {
            cout << "DA" << "\n";
        }
        else {
            cout << "NE" << "\n";
        }
    }
    
    return 0;
}
