#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
char a[104][104];
int visited[104][104];
int n;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void dfsR(int y, int x) {
    visited[y][x]=1;
    for(int i=0;i<4;i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
        if(!visited[ny][nx] && a[ny][nx]=='R') {
            dfsR(ny, nx);
        }
    }
    return;
}
void dfsG(int y, int x) {
    visited[y][x]=1;
    for(int i=0;i<4;i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
        if(!visited[ny][nx] && a[ny][nx]=='G') {
            dfsG(ny, nx);
        }
    }
    return;
}
void dfsB(int y, int x) {
    visited[y][x]=1;
    for(int i=0;i<4;i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
        if(!visited[ny][nx] && a[ny][nx]=='B') {
            dfsB(ny, nx);
        }
    }
    return;
}

void dfsRG(int y, int x) {
    visited[y][x]=1;
    for(int i=0;i<4;i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
        if(!visited[ny][nx] && (a[ny][nx]=='R' || a[ny][nx]=='G')) {
            dfsRG(ny, nx);
        }
    }
    return;
}

int main(int argc, char** argv)
{
    cin >> n;

    fill(&visited[0][0], &visited[103][104], 0);

    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            cin >> a[i][j];
        }
    }

    int cntR=0, cntG=0, cntB=0, cntRG=0;
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            if(!visited[i][j] && (a[i][j]=='R')) {
                cntR++;
                dfsR(i, j);
            }
            if(!visited[i][j] && (a[i][j]=='G')) {
                cntG++;
                dfsG(i, j);
            }
            if(!visited[i][j] && (a[i][j]=='B')) {
                cntB++;
                dfsB(i, j);
            }
            if(!visited[i][j] && (a[i][j]=='G' || a[i][j]=='R')) {
                cntRG++;
                dfsRG(i, j);
            }
        }
    }

    fill(&visited[0][0], &visited[103][104], 0);
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            if(!visited[i][j] && (a[i][j]=='G' || a[i][j]=='R')) {
                cntRG++;
                dfsRG(i, j);
            }
        }
    }

    cout << cntR + cntG + cntB << ' ';
    cout << cntRG + cntB<< ' ';

    return 0;
}
