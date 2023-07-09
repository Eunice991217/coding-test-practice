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
    int n, k;
    int psum[100000], a[100000], sum[100000];
    long max=-9123456789;
    
    cin >> n >> k;
    
    for(int i=0;i<n;i++) {
        cin >> a[i];
    }
    
    for(int i=0;i<n;i++) {
        psum[i] = psum[i - 1] + a[i];
    }
    
    for(int i=0;i<n;i++) {
        if(i+(k-1) == n) break;
        sum[i] = psum[i+(k-1)] - psum[i - 1];
        if(max<sum[i]) max = sum[i];
        
    }
    
    cout << max << endl;
    
}
