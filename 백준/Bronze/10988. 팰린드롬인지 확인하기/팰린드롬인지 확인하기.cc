#include <bits/stdc++.h>
using namespace std;

int main()
{
    string str;
    string reStr;
    
    cin >> str;
    
    reStr = str;
    
    reverse(reStr.begin(), reStr.end());

    if(str.compare(reStr)==0) {
        cout << "1";
    }
    else {
        cout << "0";
    }
    
}





