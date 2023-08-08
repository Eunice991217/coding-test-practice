#include<bits/stdc++.h>
using namespace std;

int main(void){
    int N, team;
    int Atime=0, Btime=0, cnt1=0, cnt2=0;
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        int hour, min, preh, prem;
        scanf("%d", &team);
        scanf("%2d:%2d", &hour, &min);
        if(i!=0){ // 처음을 제외하고,,,!
            if(cnt1>cnt2){
                Atime += ((hour - preh)*60 + (min-prem));
            }
            else if(cnt1<cnt2){
                Btime += ((hour - preh)*60 + (min-prem));
            }
        }
        if(team==1) cnt1++;
        if(team==2) cnt2++;
        preh = hour;
        prem = min;
        if(i==N-1){ // 끝점처리
            if(cnt1>cnt2){
                Atime += ((48 - preh)*60 +(-min));
            }
            else if(cnt1<cnt2){
                Btime += ((48 - preh)*60 +(-min));
            }
        }
    }
    printf("%02d:%02d\n%02d:%02d",Atime/60,Atime%60,Btime/60,Btime%60);
}
