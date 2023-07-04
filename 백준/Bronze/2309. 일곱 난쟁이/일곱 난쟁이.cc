#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> a;
    vector<int> dwarf;
    vector<int> flag {0,0,1,1,1,1,1,1,1};
    int n, sum=0;
    
    for(int i=0;i<9;i++) {
        cin >> n;
        a.push_back(n);
    }
    
    sort(a.begin(), a.end());
    
    do{
        sum=0;
        for(int i=0;i<a.size(); i++) {
            if(flag[i]!=0) {
                sum+=a[i];
            }
        }
        if(sum == 100) {
            for(int i=0;i<a.size();i++) {
                if(flag[i]!=0) {
                    cout << a[i] << endl;
                }
            }
            break;
        }
    }while(next_permutation(flag.begin(), flag.end()));

}

