#include <bits/stdc++.h>
using namespace std;

int n, r, num, root;
vector<int> adj[54];

// 리프노드 수를 구하는 함수 (루트노드는 체크가 안되는 로직)
int dfs(int here) { 
    int ret = 0; // 리프노드의 수
    int child = 0;
    for(int there : adj[here]) { 
        if(there == r) continue; // 해당 부분을 탐색하지않음. (노드 지우는 부분)
        ret += dfs(there); // 리프노드에서 1을 반환하는걸 모두 더하는것
        child++; // 자식 노드가 있으면 child++
    }
    if(child==0) return 1; // 자식노드가 하나도 없으면 1을 return
    return ret;
}

int main(void){

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=0;i<n;i++) {
        cin >> num;
        if(num==-1) root = i;
        adj[num].push_back(i);
    }
    cin >> r;

    if(r==root) { // 루트 노드를 지웠을 경우에는 0 (루트노드도 체크해줘야함) -> 반례처리
        cout << 0 << '\n';
        return 0;
    }
    cout << dfs(root) << '\n';
    return 0;
}




