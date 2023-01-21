//
//  1357.cpp
//  BOJ
//
//  Created by 김민경 on 2023/01/21.
//

#include <iostream>
using namespace std;

int rev(int n) {
    int ret = 0, re = 0;
    
    while(n>0) {
        ret = n%10;
        n /= 10;
        re = re*10+ret;
    }

    return re;
}

int main() {
    int x, y;
    
    cin >> x >> y;
    
    cout << rev(rev(x) + rev(y));
}
