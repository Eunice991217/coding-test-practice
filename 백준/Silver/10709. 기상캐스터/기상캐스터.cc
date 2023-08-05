#include<bits/stdc++.h>
using namespace std;

int h, w;
char a[104][104];
int n[104][104];
int cnt=0;
int main() {
    
    cin >> h >> w;

    for(int i=0;i<h;i++) {
        cnt=-1;
        for(int j=0;j<w;j++) {
            cin >> a[i][j];
            if(a[i][j]=='c') {
                cnt=0;
                continue;
            }
            if(cnt>=0) {
                cnt++;
            }
            n[i][j]=cnt;
        }
    }
    
    for(int i=0;i<h;i++) {
        for(int j=0;j<w;j++) {
            cout << n[i][j] << ' ';
        }
        cout << '\n';
    }
    
}
