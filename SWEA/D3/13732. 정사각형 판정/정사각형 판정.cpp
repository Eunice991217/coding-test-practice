#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int n;
char a[24][24];

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
    {
        cin >> n;

        int cnt=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                cin >> a[i][j];
                if(a[i][j]=='#') {
                    cnt++;
                }
            }
        }

        int first_x=0, first_y=0, flag=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(a[i][j]=='#') {
                    first_x = i;
                    first_y = j;
                    flag=1;
                    break;
                }
            }
            if(flag) break;
        }

        int end_x=0, end_y=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(a[i][j]=='#') {
                    end_x = i;
                    end_y = j;
                }
            }
        }

        flag=0;
        for(int i=first_x;i<=end_x;i++) {
            for(int j=first_y;j<=end_y;j++) {
                if(a[i][j]!='#') flag=1;
            }
        }

        cout << "#" << test_case << ' ';

        if(flag) cout << "no\n";
        else {
            double sq = sqrt(cnt);
            if(sq-(int)sq==0) {
                cout << "yes\n";
            }
            else {
                cout << "no\n";
            }
        }


    }
    return 0;
}
