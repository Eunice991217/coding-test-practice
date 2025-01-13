import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static Set<Character> keys = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (String option : arr) {
            System.out.println(go(option));
        }
    }

    static String go(String str) {
        String[] list = str.split(" ");

        // 1. 단어의 첫 글자 확인
        for (int i = 0; i < list.length; i++) {
            char firstChar = Character.toLowerCase(list[i].charAt(0));
            if (check(firstChar)) {
                keys.add(firstChar); // 단축키 등록
                return makeKey(str, i, 0);
            }
        }

        // 2. 단어 내부의 다른 글자 확인
        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list[i].length(); j++) {
                char ch = Character.toLowerCase(list[i].charAt(j));
                if (check(ch)) {
                    keys.add(ch); // 단축키 등록
                    return makeKey(str, i, j);
                }
            }
        }

        // 3. 단축키를 지정하지 못한 경우
        return str;
    }

    static String makeKey(String str, int listIdx, int strIdx) {
        String[] list = str.split(" ");
        list[listIdx] = list[listIdx].substring(0, strIdx) + "[" + list[listIdx].charAt(strIdx) + "]" + list[listIdx].substring(strIdx + 1);
        return String.join(" ", list);
    }

    static boolean check(char ch) {
        return !keys.contains(ch); // 이미 단축키로 지정되지 않은 경우 true 반환
    }
}