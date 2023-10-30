#include <iostream>
#include <algorithm>
#include <stack>
#include <queue>
using namespace std;
queue<int> q;
int T, n;
string str;

int main() {

    cin >> T;

    for(int i=0;i<T;i++) {
        cin >> str;
        if(str=="push") {
            cin >> n;
            q.push(n);
        }
        else if(str=="pop") {
            if(q.size()) {
                cout << q.front() << '\n';
                q.pop();
            }
            else {
                cout << "-1\n";
            }
        }
        else if(str=="size") {
            cout << q.size() << '\n';
        }
        else if(str=="empty") {
            if(q.size()) {
                cout << "0\n";
            }
            else {
                cout << "1\n";
            }
        }
        else if(str=="front") {
            if(q.size()) {
                cout << q.front() << '\n';
            }
            else {
                cout << "-1\n";
            }
        }
        else {
            if(q.size()) {
                cout << q.back() << '\n';
            }
            else {
                cout << "-1\n";
            }
        }
     }

    return 0;
}
