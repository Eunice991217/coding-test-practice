//
//  2587.cpp
//  BOJ
//
//  Created by 김민경 on 2023/01/12.
//

#include <iostream>
using namespace std;

int main() {
    int mid, tmp, sum=0;
    int n[5];
    
    for(int i=0;i<5;i++) {
        cin >> n[i];
        sum+=n[i];
    }
    
    cout << sum/5 << "\n";
    
    for(int i=0;i<5;i++) {
        for (int j=0;j<5;j++) {
            if(n[i]<n[j]) {
                tmp=n[i];
                n[i]=n[j];
                n[j]=tmp;
            }
        }
    }
    
    cout << n[2];
    
    
}
