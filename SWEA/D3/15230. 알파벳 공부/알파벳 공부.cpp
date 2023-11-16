#include<iostream>
#include<map>
using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
    {
        string str;
        cin >> str;

        cout << "#" << test_case << ' ';

        map<int, char> mp;
        char ch;
        for(int i=0;i<26;i++) {
            ch = (char)(i+'a');
            mp[i] = ch;
        }

        int cnt=0;
        for(int i=0;i<str.size();i++) {
            if(str[i]==mp[i]) {
                cnt++;
            }
            else {
                break;
            }
        }

        cout << cnt << '\n';

    }
    return 0;
}