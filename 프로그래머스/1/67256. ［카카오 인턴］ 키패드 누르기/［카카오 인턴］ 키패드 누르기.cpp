#include <string>
#include <vector>
#include <iostream>
using namespace std;
char r='#', l='*';
char a[5][5];

char go(char num, string hand) {
    if(num=='1' || num=='4' || num=='7') {
        l=num;
        return 'L';
    }
    else if(num=='3' || num=='6' || num=='9') {
        r=num;
        return 'R';
    }
    else { // 2, 5, 8, 0
        int r1, r2, c1, c2, l1, l2;
        for(int i=0;i<4;i++) {
            for(int j=0;j<3;j++) {
                if(a[i][j]==num) {
                    c1=i;
                    c2=j;
                }
                if(a[i][j]==l) {
                    l1=i;
                    l2=j;
                }
                else if(a[i][j]==r) {
                    r1=i;
                    r2=j;
                }
            }
        }
        int comL, comR;
        comL = abs(l1-c1) + abs(l2-c2);
        comR = abs(r1-c1) + abs(r2-c2);
        if(comL<comR) {
            l=num;
            return 'L';
        }
        else if(comL>comR) {
            r=num;
            return 'R';
        }
        else {
            if(hand=="left") {
                l=num;
                return 'L';
            }
            else {
                r=num;
                return 'R';
            }
        }
    }
}

string solution(vector<int> numbers, string hand) {
    string answer = "";

    int sum=0;
    for(int i=0;i<3;i++) {
        for(int j=0;j<3;j++) {
            sum++;
            a[i][j]=(char)(sum+'0');
        }
    }
    a[3][0]='*';
    a[3][1]='0';
    a[3][2]='#';

    for(int i=0;i<numbers.size();i++) {
        cout << "l : " << l << " r : " << r << '\n';
        answer+=go((char)(numbers[i]+'0'), hand);
    }

    return answer;
}