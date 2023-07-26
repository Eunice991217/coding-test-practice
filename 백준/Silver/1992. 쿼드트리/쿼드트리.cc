//
//  main.cpp
//  BOJ
//
//  Created by 김민경 on 2023/07/25.
//

#include<bits/stdc++.h>
using namespace std;

char a[68][68];
string s;
int n;

string go(int y, int x, int size) {
    if(size==1) return string(1,a[y][x]); // char를 string으로 만들어주는 함수
    char b = a[y][x];
    string ret ="";
    
    for(int i=y;i<y+size;i++) {
        for(int j=x; j<x+size; j++) {
            if(b!=a[i][j]) { // 다를 경우
                ret+="(";
                ret+=go(y,x,size/2);
                ret+=go(y,x+size/2, size/2);
                ret+=go(y+size/2, x, size/2);
                ret+=go(y+size/2, x+size/2, size/2);
                ret+=")";
                return ret;
            }
        }
    }
    
    return string(1, a[y][x]);
}

int main() {
    
    cin >> n;
    
    for(int i=0;i<n;i++) {
        cin >> s;
        for(int j=0;j<n;j++) {
            a[i][j] = s[j];
        }
    }
    
    cout << go(0,0,n) << '\n';
    
    
    return 0;
}
