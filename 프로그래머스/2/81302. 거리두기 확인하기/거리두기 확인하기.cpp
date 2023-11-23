#include <iostream>
#include <vector>
using namespace std;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int visited[5][5];
int N=5;
int result;

void dfs(string place[5], int x, int y, int cnt) {
    if(place[x][y]=='X') {
        return;
    }

    if(place[x][y]=='P' && visited[x][y]==0) {
        result = 0;
        return;
    }

    if(cnt<2) {
        for(int i=0;i<4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny>=0 && nx>=0 && nx<N && ny<N) {
                dfs(place, nx, ny, cnt+1);
            }
        }
    }


}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;

    for(int i=0;i<5;i++) {
        string place[5];
        for(int j=0;j<5;j++) {
            place[j]=places[i][j];
        }

        result = 1;
        for(int j=0;j<5;j++) {
            for(int k=0;k<5;k++) {
                if(place[j][k]=='P') {
                    visited[j][k]=1;
                    dfs(place, j, k, 0);
                    visited[j][k]=0;
                }
            }
        }
        answer.push_back(result);
    }

    return answer;
}