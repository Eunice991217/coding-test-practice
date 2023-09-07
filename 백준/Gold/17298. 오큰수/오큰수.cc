#include<bits/stdc++.h>
using namespace std;
int n, a[1000004], ret[1000004];
stack<int> s;
int main() {

    cin >> n;

    memset(ret, -1, sizeof(ret));

    for(int i=0;i<n;i++) {
        cin >> a[i];
        while(s.size() && a[s.top()] < a[i]) { // stack top 사용할 때는 사이즈 먼저 체크!
            ret[s.top()] = a[i];
            s.pop();
        }
        s.push(i);
    }
    for(int i=0;i<n;i++) cout << ret[i] << " ";

}