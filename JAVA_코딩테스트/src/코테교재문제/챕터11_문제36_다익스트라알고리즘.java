package 코테교재문제;
import java.util.*;
public class 챕터11_문제36_다익스트라알고리즘 {
	public static class Node{
		public int node;
		public int price; // 시작노드부터 node 까지의 거리를 계속해서 갱신시키며 담는 변수
		public Node(int n, int p) {
			node = n;
			price = p;
		}
	}
	public static ArrayList<Node>[] array; // 그래프에서 서로 연결된 각 노드 번호, 가중치를 각 노드마다 리스트로 담은 배열
	public static int INF = Integer.MAX_VALUE; // 다익스트라 알고리즘의 최소비용, 직전 노드 베열에 사용할 굉장히 큰 수
	public static boolean[] visited; // 각 노드가 방문한 노드인지 확인할 배열
	public static int[] leastPrice; // 다익스트라 알고리즘에서 최소비용을 기록할 배열
	public static int[] prevNode; // 다익스트라 알고리즘에서 각 노드의 직전 노드를 기록할 배열
	
	public static int[] solution(int[][] graph, int start, int n) {
		init(start, n); // 각 데이터들 초기화
		buildGraph(graph, n); // 그래프 구축
		
		// 방문하지 않은 노드 중에서 매번 최소 비용이 가장 작은 노드를 선택해야하기 때문에, 우선순위 큐를 사용한다
		// 우선순위 큐 안에 있으면 아직 방문하지 않은 노드, 큐 안에 들어있지 않으면 이미 방문한 노드이다.
		PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.price, o2.price)); // 람다식을 활용해서 비용이 적게 든 노드를 먼저 나오게 한다.  
		queue.add(new Node(start,0)); // 시작 노드를 삽입한다.
		while(!queue.isEmpty()) {
			Node now = queue.poll(); // 현재 가장 최단 거리인 노드를 가져온다.
			if(visited[now.node]) continue; // 해당 노드가 방문한 노드이면 패스
			for(Node next:array[now.node]) { // 현재 노드와 연결된(인접한) 노드들의 거리 값을 계산한다.
				if(leastPrice[next.node] > now.price + next.price) { // 만약 다음에 방문할 노드의 최소 비용 배열의 데이터값보다 더 짧은 거리를 발견하면, 최소 비용 값을 갱신하고 그 값을 큐에 넣는다.
					leastPrice[next.node] = now.price + next.price;
					queue.add(new Node(next.node, leastPrice[next.node]));
				}
			}
			visited[now.node] = true;
		}
		return leastPrice;
	}
	public static void buildGraph(int[][] graph, int n) { // 그래프 구축 함수
		array = new ArrayList[n];
		for(int i=0; i<n; ++i) array[i] = new ArrayList<>();
		for(int[] tmp:graph) array[tmp[0]].add(new Node(tmp[1],tmp[2]));
	}
	public static void init(int start, int n) { // 각 데이터들 초기화
		visited = new boolean[n];
		leastPrice = new int[n];
		prevNode = new int[n];
		for(int i=0; i<n; ++i) {
			if(i==start) {
				leastPrice[i] = 0;
				prevNode[i] = start;
			}
			else {
				leastPrice[i] = INF;
				prevNode[i] = INF;
			}
		}
	}
	public static void main(String[] args) {
		int[][] graph = {{0,1,1},{1,2,5},{2,3,1}};
		int start = 0;
		int n=4;
		System.out.println(Arrays.toString(solution(graph,start,n)));
	}
}
