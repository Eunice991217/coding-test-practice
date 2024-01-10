#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;
vector<vector<int>> v;
int visited[104];
int n, m;

int dfs(int u) {
    visited[u]=1;
    int cnt=1;
//    cout << u << ' ';
    for(int i=0;i<v[u].size();i++) {
        int next = v[u][i];
        if(!visited[next]) {
            cnt+=dfs(next);
        }
    }
    return cnt;
}

int main(int argc, char** argv)
{
    cin >> n >> m;

    v = vector<vector<int>>(n+1);

    int x, y;
    for(int i=0;i<m;i++) {
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }

    for(int i=1;i<=n;i++) {
        sort(v[i].begin(), v[i].end());
    }

    cout << dfs(1)-1;



    return 0;
}
