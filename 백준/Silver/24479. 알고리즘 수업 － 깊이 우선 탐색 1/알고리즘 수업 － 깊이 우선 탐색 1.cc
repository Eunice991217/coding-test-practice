#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;
vector<vector<int>> v;
int visited[100004];
int order[100004];
int n, m, r, cnt=1;

void dfs(int u) {
    visited[u]=1;
    order[u]=cnt++;
    for(int i=0;i<v[u].size();i++) {
        int next = v[u][i];
        if(!visited[next]) {
            dfs(next);
        }
    }
    return;
}

int main(int argc, char** argv)
{
    cin >> n >> m >> r;

    v = vector<vector<int>>(n + 1);
    fill(&visited[0], &visited[104], 0);

    int x, y;
    for(int i=0;i<m;i++) {
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }

    for(int i=1;i<=n;i++) {
        sort(v[i].begin(), v[i].end());
    }

    if(!visited[r]) {
        dfs(r);
    }

    for(int i=1;i<=n;i++) {
        cout << order[i] << ' ';
    }

    return 0;
}
