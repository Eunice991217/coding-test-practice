//
//  1475.cpp
//  BOJ
//
//  Created by 김민경 on 2023/01/14.
//

#include <iostream>
using namespace std;

int main() {
    int n; // 방 번호
    int set[10]={};
    int ans=1;
    
    cin >> n;
    
    // ans = 1로 둠으로서 N = 0일때에 대한 예외처리가 자연스럽게 가능해짐
    while(n) {
        set[n%10]++;
        n/=10;
    }
    
    for(int i=0;i<10;i++) {
        if(i==6 || i==9) {
            continue;
        }
        ans = max(ans, set[i]); // max : 더 큰 값 리턴
    }
    
    // (set[6]+set[9])/2를 올림한 값이 6, 9에 대한 필요한 세트의 수이므로 (set[6]+set[9]+1)/2을 계산
    ans = max(ans, (set[6]+set[9]+1)/2);
    cout << ans;
    
    return 0;
}
