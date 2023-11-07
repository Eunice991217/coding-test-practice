#include<iostream>
using namespace std;

int gcd(int a, int b) {
    int r;
    while(b!=0) {
        r=a%b;
        a=b;
        b=r;
    }
    return a;
}

int lcm(int a, int b) {
    return a*b / gcd(a,b);
}

int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin >> T;

    for(test_case = 1; test_case <= T; ++test_case)
    {
        string s, t, fs, ft;

        cin >> s >> t;
        cout << "#" << test_case << ' ';

        int len=0;
        len = lcm(s.size(), t.size());

        int i=0, j=0;
        while(1) {
            if(fs.size()==len) break;
            fs+=s[i];
            ft+=t[j];
            i++;
            j++;
            if(s.size()==i) {
                i=0;
            }
            if(t.size()==j) {
                j=0;
            }
        }

        if(fs==ft) cout << "yes\n";
        else cout << "no\n";

    }

    return 0;
}