#include <bits/stdc++.h>
using namespace std;

int main()
{
    int arr[100] = {0};
    
    int a, b, c;
    cin >> a >> b >> c; // 차량 입력
    for(int i = 0; i < 3; i++){
        int start = 0, end = 0; // 시작, 끝 입력
        cin >> start >> end;
        for(int j = start; j < end; j++){
            arr[j]++;
        }
        
    }
    
    int sum = 0;
    for(int i = 0; i < 100; i ++){
        if(arr[i] == 1)
            sum += arr[i] * a;
        else if(arr[i] == 2)
            sum += arr[i] * b;
        else if(arr[i] == 3)
            sum += arr[i] * c;
    }

    cout << sum << endl;
}





