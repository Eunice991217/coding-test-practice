class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        // 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용
        // 한 번 사용한 카드는 다시 사용 불가
        // 카드를 사용하지 않고 다음 카드로 넘어갈 수 없음
        // 기존에 주어진 카드 뭉치의 단어 순서 못 바꿈 
        
        int idx1=0, idx2=0;
        for(int i=0;i<goal.length;i++) {
            if(idx1<cards1.length && cards1[idx1].equals(goal[i])) {
                idx1++;
            } else if(idx2<cards2.length && cards2[idx2].equals(goal[i])) {
                idx2++;
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}