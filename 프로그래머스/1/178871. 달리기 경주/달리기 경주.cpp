#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    map<string, int> mp; 
    for(int i=0;i<players.size();i++) {
        mp[players[i]] = i;
    }
    
    for(int i=0;i<callings.size();i++) {
        int idx = mp[callings[i]];
        mp[players[idx-1]]++;
        mp[callings[i]]--;
        swap(players[idx], players[idx-1]);
    }
    
    return players;
}