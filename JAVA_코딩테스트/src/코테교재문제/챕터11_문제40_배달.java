package 코테교재문제;
import java.util.*;
public class 챕터11_문제40_배달 {
	public static class Node{
		public int node;
		public int price;
		public Node(int n, int p) {
			node = n;
			price = p;
		}
	}
	public static final int INF = Integer.MAX_VALUE;
	public static ArrayList<Node>[] graph; // 그래프
	public static int[] leastCost; // 각 노드별 최소 비용 배열
	public static int[] prevNode; // 각 노드별 직전 노드 배열
	public static boolean[] visited; // 각 노드가 방문한 노드인지 확인
	
	public static int solution(int N, int[][] road, int K) {
		int result=0;
		buildGraph(N, road); // 그래프 생성
		dikstra(N, road); // 다익스트라로 최소 비용 배열 생성
		for(int i:leastCost) {
			if(i<=K) ++result;
		}
		
		return result;
	}
	public static void dikstra(int N, int[][] road) { // 우선순위 큐를 사용한다.
		PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(leastCost[o1.node],leastCost[o2.node])); 
		queue.add(new Node(0,0));
		leastCost[0] = 0;
		prevNode[0] = 0;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(visited[now.node]) continue;
			visited[now.node] = true;
			
			int nowPrice = leastCost[now.node];
			for(Node next:graph[now.node]) {
				if(leastCost[next.node] > nowPrice+next.price) { // 다음 노드의 최소 비용이 해당 노드를 거쳐서 각 노드까지 가는 최소 비용을 비교해서 더 작은 값을 최소 비용으로 갱신
					leastCost[next.node] = nowPrice+next.price;
					prevNode[next.node] = now.node;
					queue.add(next);
				}
			}			
		}
	}
	public static void buildGraph(int N, int[][] road) {
		graph = new ArrayList[N];
		leastCost = new int[N];
		prevNode = new int[N];
		for(int i=0; i<N; ++i) {
			graph[i] = new ArrayList<>();
			leastCost[i] = INF;
			prevNode[i] = INF; 
		}
		visited = new boolean[N];
		for(int[] tmp : road) {
			graph[tmp[0]-1].add(new Node(tmp[1]-1,tmp[2]));
			graph[tmp[1]-1].add(new Node(tmp[0]-1,tmp[2]));
		}
	}
	public static void main(String[] args) {
		int N = 6;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K=4;
		System.out.println(solution(N,road,K));
	}
	// {1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
	//{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}
}
