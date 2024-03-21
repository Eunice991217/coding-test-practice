

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer> list;
    static boolean visited[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        list = new ArrayList<Integer>();
        visited = new boolean[9];
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        go();
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    public static void go() throws IOException {
    	if(list.size()==m) {
    		for(int i=0;i<m;i++) {
    			bw.write(list.get(i)+" ");
    		}
    		bw.newLine();
    		return;
    	}
    	
    	for(int i=1;i<=n;i++) {
    		list.add(i);
    		go();
    		list.remove(list.size()-1);
    	}
    }

}
