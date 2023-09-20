#include <bits/stdc++.h>
using namespace std;
int N, result[20];
vector<int> v1, v2;
string str;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    int num;

    for(int i=0;i<n;i++) {
        cin >> num;
        arr1.push_back(num);
    }
    for(int i=0;i<n;i++) {
        cin >> num;
        arr2.push_back(num);
    }

    for(int i=0;i<n;i++) {
        result[i] = arr1[i] | arr2[i]; // or 연산
        string tmp = "";

        while (tmp.size() != n) {
            if (result[i] % 2 != 0) {
                tmp.push_back('#');
            } else {
                tmp.push_back(' ');
            }
            result[i] /= 2;
        }
        reverse(tmp.begin(), tmp.end()); // 역으로 바꾸기
        answer.push_back(tmp);
    }

    return answer;
}