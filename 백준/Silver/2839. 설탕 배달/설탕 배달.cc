#include <vector>
#include <iostream>
using namespace std;
int n, cnt = 0;

int main() {

    cin >> n;

    while (n > 0) {
        if(n<3) {
            cnt=-1;
            break;
        }
        if(n%5==0) {
            cnt += (n/5); // 5kg
            n%=5;
        }
        else { // 5로 나누어 지지 않을 때
            n-=3;
            cnt++; // 3kg
        }
    }

    cout << cnt;

    return 0;
}