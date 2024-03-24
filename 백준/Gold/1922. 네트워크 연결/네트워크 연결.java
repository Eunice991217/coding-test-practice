import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main
{
    static int n, m, ans=0, sx, sy, sw;
    static PriorityQueue<Node> pq;
    static List<List<Node>> list;
    static boolean visited[];

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 콤퓨타~
        n = Integer.parseInt(br.readLine());

        // 선
        m = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();

        list = new ArrayList<>();

        for(int i=0;i<100001;i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[n+1];

        // 연결 비용
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        go();

        System.out.println(ans);

    }

    public static void go() {
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int d = now.d;
            if(!visited[x]) {
                ans+=d;
                visited[x] = true;
                for(int i=0;i<list.get(x).size();i++) {
                    Node next = list.get(x).get(i);
                    int nx = next.x;
                    if(!visited[nx]) {
                        pq.add(next);
                    }
                }
            }
        }
    }


}

class Node implements Comparable<Node> {
    int x;
    int d;
    Node(int x, int d) {
        this.x = x;
        this.d = d;
    }
    @Override
    public int compareTo(Node o) {
        return this.d-o.d;
    }
}
