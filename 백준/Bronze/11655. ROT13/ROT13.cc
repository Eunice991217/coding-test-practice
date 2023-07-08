#include <bits/stdc++.h>
using namespace std;

int main()
{
    string str;
    getline(cin, str); // 공백있게 문자열 받기
    
    for (int i = 0; i < str.length(); i++)
    {
        // 소문자
        if (str[i] >= 'a' && str[i] <= 'z')
        {
            int tmp = (str[i] - 'a' + 13) % 26;
            cout << char('a' + tmp);
        }
        // 대문자
        else if (str[i] >= 'A' && str[i] <= 'Z')
        {
            int tmp = (str[i] - 'A' + 13) % 26;
            cout << char('A' + tmp);
        }
        // 소, 대문자가 아닌 경우
        else cout << str[i];
    }
    return 0;
}
