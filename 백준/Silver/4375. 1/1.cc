#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, cnt=1;
    long long k=1;
    
    while(scanf("%d", &n) != EOF) {
        cnt=1;
        k=1;
        while(k%n!=0) {
            k = (k*10) +1;
            k%=n;
            cnt++;
        }
        cout << cnt << endl;
    }
    
    return 0;
    
}


