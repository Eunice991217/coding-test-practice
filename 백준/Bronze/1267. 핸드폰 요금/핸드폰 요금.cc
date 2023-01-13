//
//  1267.cpp
//  BOJ
//
//  Created by 김민경 on 2023/01/13.
//

#include <iostream>
using namespace std;

int main() {
    int n; // 통화의 개수
    int y=0, m=0, ysum=0, msum=0; // y : 영식, m : 민식
    int call;
    
    cin >> n;
    
    for(int i=0;i<n;i++) {
        cin >> call;
        
        y=10*((call/30)+1);
        m=15*((call/60)+1);
        
        ysum+=y;
        msum+=m;
    }
    
    if(ysum<msum) {
        cout << "Y " << ysum;
    }
    else if (ysum==msum) {
        cout << "Y M " << msum;
    }
    else {
        cout << "M " << msum;
    }
    
    return 0;
}
