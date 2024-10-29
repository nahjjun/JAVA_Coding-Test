package 코테교재문제;
import java.util.*;
public class 챕터11_문제42_전력망을둘로나누기 {
	public static ArrayList<Integer>[] graph;

	public static int solution(int n, int[][] wires) {
		int result = n;
		for(int[] wire:wires) {
			int case1 = bfs(n, wires, wire[0], wire[0], wire[1]);
			int case2 = bfs(n, wires, wire[1], wire[0], wire[1]);
			result = Integer.min(Integer.max(case1,case2)-Integer.min(case1,case2), result);
		}
		return result;
	}
	public static void init(int n, int[][] wires) {
		graph = new ArrayList[n+1]; // bfs에 사용할 인접 리스트
		for(int i=0; i<=n; ++i) graph[i] = new ArrayList<>();
		for(int[] tmp:wires) {
			if(!graph[tmp[0]].contains(tmp[1])) {
				graph[tmp[0]].add(tmp[1]);
				graph[tmp[1]].add(tmp[0]);
			}
		}
	}
	public static void delete(int delete1, int delete2) {
		graph[delete1].remove(Integer.valueOf(delete2));
		graph[delete2].remove(Integer.valueOf(delete1));
	}
	public static int bfs(int n, int[][] wires, int start, int delete1, int delete2) {
		init(n, wires);
		delete(delete1, delete2);
		boolean visited[] = new boolean[n+1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next:graph[now]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true; 
					++count;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int n=4;
		int[][] wires = {{1,2},{2,3},{3,4}};
		System.out.println(solution(n, wires));
		
	}
}
