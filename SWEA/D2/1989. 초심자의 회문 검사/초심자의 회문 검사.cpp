#include<iostream>
#include<algorithm>
using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
    {
        string tmp, str;
        cin >> str;

        tmp=str;
        reverse(str.begin(), str.end());

        if(tmp==str) cout << "#" << test_case << " 1\n";
        else cout << "#" << test_case << " 0\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}