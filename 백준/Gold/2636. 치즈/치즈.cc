#include<bits/stdc++.h>
using namespace std;

int n, m;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int a[104][104];
int visited[104][104];
int cnt, cnt2;
vector<pair<int,int>> v;

void dfs(int y, int x) {
    visited[y][x]=1; // 해당 지점에 방문처리
    if(a[y][x]==1) { // 치즈면
        v.push_back({y,x}); // v에 push한것을 기반으로
        return; // 더이상 방문하지않음
    }
    for(int i=0;i<4;i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny<0 || ny>=n || nx<0 || nx>=m || visited[ny][nx]) continue;
        visited[ny][nx]=1;
        dfs(ny, nx);
    }
    return;
}


int main(void){
    cin >> n >> m;
    
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cin >> a[i][j];
        }
    }
    
    while(1) {
        fill(&visited[0][0], &visited[0][0] + 104*104, 0);
        v.clear();
        dfs(0,0);
        cnt2 = v.size();
        for(pair<int,int> b : v) { // v에 push한것을 기반으로
            a[b.first][b.second] = 0; // 치즈를 녹임
        }
        bool flag = 0; // 치즈가 다 녹아있는지 체크
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(a[i][j]!=0) flag=1;
            }
        }
        cnt++; // 치즈가 다 녹아있지않으면 ++
        if(!flag) break; // 치즈가 다 녹아있으면 break
    }
    cout << cnt << '\n' << cnt2 << '\n';
    
}
