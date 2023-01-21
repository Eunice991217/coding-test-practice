//
//  2693.cpp
//  BOJ
//
//  Created by 김민경 on 2023/01/21.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int n=3;

bool compare(int i, int j) {
    return i > j;
}

int main() {
    int T, arr[10];
    vector<int> vn;
    
    cin >> T;
    
    for(int i=0;i<T;i++) {
        for(int j=0;j<10;j++) {
            cin >> arr[j];
        }
        sort(arr, arr+10, compare);
        vn.push_back(arr[2]);
    }
    for(int b : vn) cout << b << endl;
    
}
