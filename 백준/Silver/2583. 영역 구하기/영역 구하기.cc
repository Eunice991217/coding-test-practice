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

int a[104][104], y, x, ny, nx, n, m, k, tmp[4], visited[104][104];
vector<int> ret;

int dfs(int y, int x) {
    visited[y][x]=1;
    int ret = 1;
    for(int i=0;i<4;i++) {
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny< 0 || nx <0 || ny >= m || nx >=n || visited[ny][nx]==1) continue;
        if(a[ny][nx] == 1) continue;
        ret += dfs(ny,nx);
    }
    return ret;
}


int main() {
    
    cin >> m >> n >> k; // 행렬, 직사각형 개수
    
    for(int i=0;i<k;i++) {
        for(int j=0;j<4;j++) {
            cin >> tmp[j];
        }
        for(int q=tmp[1];q<tmp[3];q++) {
            for(int p=tmp[0]; p<tmp[2];p++) {
                a[q][p] = 1;
            }
        }
    }
    
    for(int i=0;i<m;i++) {
        for(int j=0;j<n;j++) {
            if(a[i][j] == 0 && !visited[i][j]) {
                ret.push_back(dfs(i,j));
            }
        }
    }
    sort(ret.begin(), ret.end()); // 오름차순 정렬
    
    cout << ret.size() << '\n'; // 컴포넌트 개수
    for(int a : ret) cout << a << ' '; // 각 크기
    
    return 0;
}
