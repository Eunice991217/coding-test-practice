#include<bits/stdc++.h>
using namespace std;

int n;
int main(void){
    
    cin >> n;
    int i=666;
    
    while(1) {
        if(to_string(i).find("666")!=string::npos) n--;
        if(n==0) break;
        i++;
    }
    
    cout << i << '\n';
    
}
