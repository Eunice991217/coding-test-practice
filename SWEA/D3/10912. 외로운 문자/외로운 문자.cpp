#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
    {
        map<char, int> mp;

        string str;
        cin >> str;

        cout << "#" << test_case << ' ';

        for(int i=0;i<str.size();i++) {
            mp[str[i]]++;
        }

        vector<char> v;

        for(auto i : mp) {
            if(i.second%2!=0) {
                v.push_back(i.first);
            }
        }

        sort(v.begin(), v.end());

        if(v.size()) {
            for(auto i : v) {
                cout << i;
            }
        }
        else {
            cout << "Good";
        }


        cout << '\n';

    }
    return 0;
}