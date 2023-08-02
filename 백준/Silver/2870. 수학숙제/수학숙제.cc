#include<bits/stdc++.h>
using namespace std;

int n;
string str, ret;
vector<string> v;

bool cmp(string a,string b){
    if(a.size()== b.size()) return a<b; // 사이즈가 같으면 아스키코드순으로
    return a.size() <b.size();
}

void go() {
    while(true) {
        if(ret.size() && ret.front()=='0') ret.erase(ret.begin()); // front 할때는 size 같이 해야함 (아니면 참조에러뜸)
        else break;
    }
    if(ret.size()==0) ret="0"; //0000이면 0이 다 사라지므로 0할당
    v.push_back(ret);
    ret="";
}

int main() {
    
    cin >> n;
    
    for(int i=0;i<n;i++) {
        cin >> str;
        ret="";
        for(int j=0;j<str.size();j++) {
            if(str[j]>='0' && str[j]<='9') {
                ret+=str[j];
            }
            else if(ret.size()) go();
        }
        if(ret.size()) go();
    }
    
    sort(v.begin(),v.end(), cmp);
    for(string a : v) cout << a << endl;
    
}
