#include <bits/stdc++.h>
using namespace std;

int n, ret;
string s;
int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n;
    for(int i=0;i<n;i++) {
        cin >> s;
        stack<char> stk;
        for (char a : s) {
						// 큐랑 스택 둘다 항상 사이즈를 체크하고 비교해야한다. (stk.size())
            if(stk.size() && stk.top() == a) stk.pop(); // 가장 위에 있는 문자와 들어오는 문자가 같은지를 비교 (같으면 pop)
            else stk.push(a); // 다르면 push
        }

        if(stk.size()==0) ret++; // 스택에 사이즈가 없다면 (다 폭발했다면) 이건 좋은 단어 
    }
    cout << ret << endl;
    
    return 0;
    
}