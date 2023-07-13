#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll a, b, c;

ll go(ll a, ll b) {
    if(b==1) return a % c; // 기저사례 
    ll ret = go(a,b/2);
    ret = (ret*ret) %c;
		// 홀수일때 한번 더 곱함 
    if(b%2) ret = (ret*a) %c; // 5승이라면 (홀수라면) 한번 더 곱해줘야하기 때문 
    return ret;
}
int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> a >> b >> c;
    
    cout << go(a,b) << endl;
    
    return 0;
    
}