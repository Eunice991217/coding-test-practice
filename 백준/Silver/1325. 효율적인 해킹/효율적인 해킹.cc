#include <bits/stdc++.h>
using namespace std;

int n, m, a, b, mx;
vector<int> v[100004];
int visited[100004];
int dp[1000001];

int dfs(int x) {
    visited[x]=1;
    int ret=1;
    for(int there : v[x]) {
        if(visited[there]) continue;
        ret+=dfs(there);
    }
    return ret;
}

int main(void){

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;

    for(int i=0;i<m;i++) {
        cin >> a >> b;
        v[b].push_back(a);
    }

    for(int i=1;i<=n;i++) { // 모든 정점 탐색
        memset(visited, 0, sizeof(visited)); // 초기화 해줘야함 (dfs 할때마다)
        dp[i]=dfs(i); // dfs를 배열에 담음 (해당 정점으로부터 몇개의 노드를 탐색하는지 dp에 담기)
        mx  = max(dp[i], mx);
    }

    for(int i=1;i<=n;i++) {
        if(mx==dp[i]) cout << i << " ";
    }

    return 0;

}




