#include <bits/stdc++.h>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);

    map<string, int> mp;
    map<int, string> mp2;
    int n, m, num=1;
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        string str;
        cin >> str;
        mp.insert(make_pair(str, num));
        mp2.insert(make_pair(num++, str));
    }

    for (int i = 0; i < m; i++)
    {
        char s[21];
        cin >> s;
        if (s[0] < 'A')
        {
            int value = atoi(s);
            cout << mp2[value] << '\n';
        }
        else
        {
            cout << mp[s] << '\n';
        }
    }
    return 0;
}


