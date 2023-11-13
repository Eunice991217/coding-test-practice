#include<iostream>
#include<string>
using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
    {

        int maxN=-1, minN=1000000000;
        string n, tmp;

        cin >> n;
        tmp = n;

        cout << "#" << test_case << ' ';

        for(int i=0;i<n.size();i++) {
            for(int j=i;j<n.size();j++) {
                swap(n[i], n[j]);
                if(n[0]=='0') {
                    swap(n[i], n[j]);
                }
                minN = min(minN, stoi(n));
                n=tmp;
            }
        }

        cout << minN << ' ';

        for(int i=0;i<n.size();i++) {
            for(int j=i;j<n.size();j++) {
                swap(n[i], n[j]);
                maxN = max(maxN, stoi(n));
                n=tmp;
            }
        }

        cout << maxN << '\n';

    }
    return 0;
}