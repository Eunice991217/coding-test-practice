#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;
stack<int> stk;
int T;
string str;
int n;

int main() {

    cin >> T;

    for(int i=0;i<T;i++) {
        cin >> str;
        if(str=="push") { // push
            cin >> n;
            stk.push(n);
        }
        else if(str=="pop") { // pop
            if(stk.size()==0) {
                cout << "-1\n";
            }else {
                cout << stk.top() << '\n';
                stk.pop();
            }
        }
        else if(str=="size"){ // size
            cout << stk.size() << '\n';
        }
        else if(str=="empty") { // empty
            if(stk.size()) { // 스택 비워있지 않음
                cout << "0\n";
            }
            else { // 스택 비워있음
                cout << "1\n";
            }
        }
        else { // top
            if(stk.size()) {
                cout << stk.top() << '\n';
            }
            else {
                cout << "-1\n";
            }
        }
    }

    return 0;
}
