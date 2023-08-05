#include<bits/stdc++.h>
using namespace std;

int t;
int n;

int main() {
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    
    for(int i=0;i<t;i++) {
        cin >> n;
        
        int ret2=0, ret5=0;
        for(int j=2;j<=n;j*=2) {
            ret2 += n/j;
        }
        for(int j=5;j<=n;j*=5) {
            ret5 += n/j;
        }
        cout << min(ret2, ret5) << "\n"; // 5의 개수는 항상 2의 개수보다 작으므로 ret5도 가능
    }
    
}
