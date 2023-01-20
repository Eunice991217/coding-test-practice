//
//  1181.cpp
//  BOJ
//
//  Created by 김민경 on 2023/01/20.
//

#include <iostream>
#include <algorithm>
#include <stdio.h>
#include <string>
using namespace std;

bool compare(string s1, string s2) {
    if (s1.size() == s2.size()) {
        return  s1 < s2;
    }
    else {
        return s1.size() < s2.size();
    }
}

int main() {
    string s[20000];
    int n;
    
    cin >> n;
    
    for(int i=0; i<n; i++) {
        cin >> s[i];
    }
    
    sort(s, s+n, compare);
    
    for(int i=0;i<n;i++) {
        if(s[i]==s[i-1]) {
            continue;
        }
        cout << s[i] << "\n";
    }

    
}
