#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, m;
vector<int> nv;

void binary_search(int target) {
    int low=0, high=n-1, mid=0;

    while(low<=high) {
        mid = (low+high) / 2;

        if(nv[mid]==target) {
            cout << 1 << '\n';
            return;
        }
        else if(nv[mid] > target) {
            high = mid-1;
        }else {
            low = mid+1;
        }
    }

    cout << 0 << '\n';

    return;
}

int main(int argc, char** argv)
{
    cin >> n;

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    for(int i=0;i<n;i++) {
        int tmp;
        cin >> tmp;
        nv.push_back(tmp);
    }

    sort(nv.begin(), nv.end());

    cin >> m;

    for(int i=0;i<m;i++) {
        int tmp;
        cin >> tmp;
        binary_search(tmp);
    }

    return 0;
}