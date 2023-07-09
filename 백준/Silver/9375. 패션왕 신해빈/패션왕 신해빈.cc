//
//  main.cpp
//  baekjoon
//
//  Created by 김민경 on 2023/07/09.
//

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, m;
    string name, kind;

    cin >> n; // test case
     
    for(int i=0;i<n;i++) {
        map<string, int> mp;
        cin >> m; // 의상의 수
        for(int i=0;i<m;i++) {
            cin >> name >> kind;
            mp[kind]++;
        }
        long long ret = 1; // 경우의 수는 수가 커질수있으므로 long long으로 선언
        for(auto c: mp) {
            ret*=((long long)c.second+1); // 종류마다 아무것도 안입는 경우를 더해줌
        }
        ret--; // 모든 종류를 아무것도 안입는 경우를 빼줌
        cout << ret << endl;
    }
}
