#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
int n;
queue<int> q;

int main() {

    cin >> n;

    for(int i=1;i<=n;i++) {
        q.push(i);
    }

    while(q.size()!=1) {
        q.pop(); // 가장 위에 카드는 버림
        q.push(q.front()); // 제일 위에 있는 카드 아래에 있는 카드 밑으로
        q.pop();
    }

    cout << q.front();

    return 0;
}

