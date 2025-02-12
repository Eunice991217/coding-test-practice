import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, ans, cnt;
    static boolean flag;
    static int[] arr, merge_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        flag = false;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_arr = new int[n];
        merge_sort(arr, 0, n-1);

        if(!flag) System.out.println(-1);
        else System.out.println(ans);
    }

    static void merge_sort(int[] arr, int low, int high) {
        if(flag) return;

        if(low<high) {
            int mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        if(flag) return;

        int i = low;
        int j = mid + 1;
        int k = low;

        while(i<=mid && j<=high) {
            if(arr[i]<arr[j]) {
                merge_arr[k] = arr[i];
                k++;
                i++;
            } else {
                merge_arr[k] = arr[j];
                k++;
                j++;
            }
            cnt++;
            if(cnt==m) {
                ans = merge_arr[k-1];
                flag = true;
                return;
            }
        }

        while(i<=mid) {
            merge_arr[k] = arr[i];
            cnt++;
            k++;
            i++;
            if(cnt==m) {
                ans = merge_arr[k-1];
                flag = true;
                return;
            }
        }

        while(j<=high) {
            merge_arr[k] = arr[j];
            cnt++;
            k++;
            j++;
            if(cnt==m) {
                ans = merge_arr[k-1];
                flag = true;
                return;
            }
        }

        for(k=low;k<=high;k++) {
            arr[k] = merge_arr[k];
        }

    }

}