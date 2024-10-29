package 코테교재문제;
import java.util.*;
public class 챕터9_문제28_양과늑대 {
	// 현재 위치, 양의 수, 늑대의 수와, 방문한 노드 저장을 위한 Info class를 생성한다.
	public static class Info{
		int node, sheep, wolf;
		HashSet<Integer> visited; // 자신과 인접한 노드들(검사해야할 노드)을 담고 있다. 
		
		public Info(int _node, int _sheep, int _wolf, HashSet<Integer> _visited) {
			node = _node;
			sheep = _sheep;
			wolf = _wolf;
			visited = _visited;
		}
	}
	
	public static ArrayList<Integer>[] tree; // 각 노드에 어떤 자식들이 연결되었는지 확인하기 위한 tree 리스트 배열
	public static void buildTree(int[] info, int[][] edges) { // tree 생성 함수
		tree = new ArrayList[info.length];
		for(int i=0; i<tree.length; ++i) tree[i] = new ArrayList<>(); // tree를 생성해준다.
		for(int i=0; i<edges.length; ++i) tree[edges[i][0]].add(edges[i][1]);
	}
	public static int solution(int[] info, int[][] edges) {
		// 트리 생성
		buildTree(info, edges);
		int maxSheep=0; // 최대 양의 수를 저장할 변수 
		ArrayDeque<Info> queue = new ArrayDeque<>(); // 각 노드 별 양, 늑대, 인접 노드 상태를 저장하면서 최대 양의 개수를 비교하는데 쓰이기 위한 큐
		queue.add(new Info(0,1,0,new HashSet<>())); // 처음 루트 노드부터 bfs 시작하기 위해 큐에 해당 노드 add
		
		// bfs 시작
		while(!queue.isEmpty()) {
			Info now = queue.poll(); // 현재 검사하고 있는 노드를 꺼낸다
			maxSheep = Math.max(now.sheep, maxSheep); // 지금 검사하고 있는 노드 기준 양의 개수 vs 최대 양의 수를 비교해서 업데이트 한다
			now.visited.addAll(tree[now.node]); // tree에는 각 인덱스 별로 연결된 자식의 리스트가 전부 들어있으므로 now의 visited 해시셑에 전부 추가해준다
			
			// now 노드와 연결된 다른 자식 노드들을 순회한다.
			for(int next:now.visited) { // 현재 now와 연결된 자식 노드들 중 한 노드를 검사중이다.
				HashSet<Integer> set = new HashSet<>(now.visited); // 현재 자신(next)과 이웃인 노드들의 인덱스값이 담겨있는 해시셑의 복사본을 생성한다.
				set.remove(next); // 자기 자신은 이미 방문한 상태이므로 복사한 해시셋에서 제거한다.
				if(info[next] == 1) { // 늑대인 경우
					if(now.sheep != now.wolf+1) { // 늑대 수를 하나 증가시켜줘도 현재 양의 개수와 같지 않을 때 
						queue.add(new Info(next, now.sheep, now.wolf+1, set)); // 현재 노드 상태(노드 인덱스, 양 개수, 늑대 개수, 현재 노드와 연결
					}
				}
				else { // 양인 경우는 조건 검사 없이 이동해도 된다.
					queue.add(new Info(next, now.sheep+1, now.wolf,set));
				}
				
			}
			
		}
		return maxSheep;
	}
	
	
	public static void main(String[] args) {
		int[] info= {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		
		System.out.println(solution(info,edges));
	}
}
