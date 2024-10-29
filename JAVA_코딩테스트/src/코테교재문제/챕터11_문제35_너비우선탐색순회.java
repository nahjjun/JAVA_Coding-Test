package 코테교재문제;
import java.util.*;
public class 챕터11_문제35_너비우선탐색순회 {
	public static ArrayList<Integer>[] array; 
	public static int[] solution(int[][] graph, int start, int n) {
		array = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
		Queue<Integer> queue = new ArrayDeque<>(); // BFS에 사용할 큐 생성
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=0; i<n+1; ++i) {
			array[i] = new ArrayList<>();
			visited[i] = false;
		}
		for(int[] i:graph) array[i[0]].add(i[1]); // 그래프 구축
		
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int polled = queue.poll();
			result.add(polled);
			for(int i:array[polled]) { // 인접한 노드들에 대해서,
				if(!visited[i]) { // 방문하지 않은 인접한 노드인 경우,
					queue.add(i);  // 큐에 삽입하고
					visited[i] = true; // 인접한 노드를 방문 처리한다.
				}
			}
			
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {
		int[][] graph = {{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{4,8},{5,8},{6,9},{7,9}};
		int start = 1;
		int n=9;
		System.out.println(Arrays.toString(solution(graph, start, n)));
	}
}
