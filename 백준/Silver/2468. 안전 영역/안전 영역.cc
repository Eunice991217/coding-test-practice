//
//  main.cpp
//  BOJ
//
//  Created by 김민경 on 2023/07/25.
//

#include<bits/stdc++.h>
using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

int a[104][104], y, x, ny, nx, ret=1, n, h, cnt;
bool visited[104][104];

void dfs(int y, int x, int h) {
    visited[y][x]=1;
    for(int i=0;i<4;i++) {
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny< 0 || nx <0 || ny >= n || nx >=n) continue;
        if(a[ny][nx] > h && !visited[ny][nx]) { // 방문하지 않았다면
            dfs(ny,nx, h); // 방문
        }
    }
}


int main() {
    
    cin >> n; // 행렬
    
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            cin >> a[i][j];
        }
    }
    
    for (int h=1;h<101;h++) {
        cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                visited[i][j] = 0;
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(a[i][j]>h && !visited[i][j]) {
                    cnt++;
                    dfs(i, j, h);
                }
            }
        }
        ret = max(ret, cnt);
    }
    
    cout << ret;
    
    return 0;
}
