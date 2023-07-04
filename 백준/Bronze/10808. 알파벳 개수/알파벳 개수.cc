#include <bits/stdc++.h>
using namespace std;

int main() {
    
    int a[26] = {0}, cnt = 0;
    char c[26] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
   
    string str;
    cin >> str;
    
    for(int i=0;i<26;i++) {
        for(int j=0;j<str.length();j++) {
            if(c[i]==str[j]) {
                cnt++;
            }
        }
        a[i] = cnt;
        cnt=0;
    }
    
    for(int i=0;i<26;i++) {
        cout << a[i] << " ";
    }

}

