#include <bits/stdc++.h>
using namespace std;

int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    int ar[15000];
    int cnt=0;
    
    cin >> n >> m;
    
    for(int i=0;i<n;i++) {
        cin >> ar[i];
    }
    
    for(int i=0;i<n;i++) {
        for(int j=i+1;j<n;j++) {
            if(ar[i]+ar[j]==m) {
                cnt++;
            }
        }
    }
    
    cout << cnt;
    
    return 0;
    
}


