//
//  5635.cpp
//  Baekjoon
//
//  Created by 김민경 on 2023/02/20.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

int n;
int main(){
    std::ios_base::sync_with_stdio(false); // 실행속도를 높이기 위한 코드
    std::cin.tie(NULL); // 실행속도를 높이기 위한 코드
    std::cout.tie(NULL); // 실행속도를 높이기 위한 코드
    
    cin >> n; // 인원수
    vector<pair<pair<int, int>, pair<int, string>>> s(n); // 여러개 페어로 묶기 (sort를 사용할 때 pair의 first를 기준으로 정렬되기에 연도를 first.first로 구성)
    // 년, 월, 일, 이름
    
    for(int i=0; i<n; i++){
        cin >> s[i].second.second >> s[i].second.first >> s[i].first.second >> s[i].first.first; // 이름, 일, 월, 년
    }
    
    sort(s.begin(), s.end()); // 년월일 순 정렬 (오름차순 정렬)
    
    cout << s[n-1].second.second << "\n" << s[0].second.second;
    
    return 0;
}
