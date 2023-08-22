#include<bits/stdc++.h>
using namespace std;

int n, m, ret;
int a[8][8];
vector<pair<int, int>> virusList;
vector<pair<int, int>> wallList;
int visited[8][8];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};

void dfs(int y, int x) {
    for(int i=0;i<4;i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny<0 || ny >= n || nx <0 || nx>=m || visited[ny][nx] || a[ny][nx] == 1) continue;
        visited[ny][nx]=1;
        dfs(ny, nx);
    }
    return;
}

int solve() {
    fill(&visited[0][0], &visited[0][0] +8 * 8, 0);
    for(pair<int, int> b : virusList) {
        visited[b.first][b.second] = 1;
        dfs(b.first, b.second);
    }
    int cnt = 0;
    // 카운팅
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            if(a[i][j]==0 && !visited[i][j]) cnt++; // 안정영역이고 방문안했을 경우
        }
    }
    return cnt;
}

int main(void){
    
    cin >> n >> m;
    
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cin >> a[i][j];
            if(a[i][j]==2) virusList.push_back({i,j}); // 바이러스의 좌표를 알면 퍼트리기 쉬움.
            if(a[i][j]==0) wallList.push_back({i,j}); // 벽은 바이러스가 있는 지점에는 세울 수 없음.
        }
    }
    
    // 조합 구현
    for(int i=0;i<wallList.size();i++) {
        for(int j=0;j<i;j++) {
            for(int k=0;k<j;k++) {
                // 벽을 놓을 수 있는 모든 위치에 벽을 세움
                a[wallList[i].first][wallList[i].second] = 1;
                a[wallList[j].first][wallList[j].second] = 1;
                a[wallList[k].first][wallList[k].second] = 1;
                ret = max(ret, solve()); // 계산
                // 벽을 지우는 작업
                a[wallList[i].first][wallList[i].second] = 0;
                a[wallList[j].first][wallList[j].second] = 0;
                a[wallList[k].first][wallList[k].second] = 0;
            }
        }
    }
    
    cout << ret << '\n';
}
