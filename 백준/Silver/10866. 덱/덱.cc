#include <iostream>
#include <deque>
using namespace std;
deque<int> dq;
int T, n;
string str;

int main() {

    cin >> T;

    for(int i=0;i<T;i++) {
        cin >> str;
        if(str=="push_front") {
            cin >> n;
            dq.push_front(n);
        }
        else if(str=="push_back") {
            cin >> n;
            dq.push_back(n);
        }
        else if(str=="pop_front") {
            if(dq.size()) {
                cout << dq.front() << '\n';
                dq.pop_front();
            }
            else {
                cout << "-1\n";
            }
        }
        else if(str=="pop_back") {
            if(dq.size()) {
                cout << dq.back() << '\n';
                dq.pop_back();
            }
            else {
                cout << "-1\n";
            }
        }
        else if(str=="size") {
            cout << dq.size() << '\n';
        }
        else if(str=="empty"){
            if(dq.size()) {
                cout << "0\n";
            }
            else {
                cout << "1\n";
            }
        }
        else if(str=="front") {
            if(dq.size()) {
                cout << dq.front() << '\n';
            }
            else {
                cout << "-1\n";
            }
        }
        else { // back
            if(dq.size()) {
                cout << dq.back() << '\n';
            }
            else {
                cout << "-1\n";
            }
        }
    }

    return 0;
}
