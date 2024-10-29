package 코테교재문제;
import java.util.*;
public class 챕터11_문제37_게임맵최단거리2 {
	public static class Pair{
		public int x;
		public int y;
		public Pair(int _x, int _y) {
			x=_x;
			y=_y;
		}
	}
	public static final int[] moveX = {0,1,0,-1}; // 위,오른쪽,아래,왼쪽 순서
	public static final int[] moveY = {1,0,-1,0};
	public static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		int[][] leastDistance = new int[n][m]; // 최단 거리를 저장할 배열 
		boolean[][] visited = new boolean[n][m]; // 방문한 노드인지 확인하는 배열
		
		Pair end = new Pair(n-1,m-1); // 캐릭터가 도달할 마지막 노드
		Queue<Pair> queue = new ArrayDeque<>(); // bfs에 사용할 큐
		queue.add(new Pair(0,0)); // 시작 노드 큐에 넣는다.
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			for(int i=0; i<4; ++i) { // 각 방향별로 갈 수 있는 곳 인지 탐색 
				int nextX = now.x+moveX[i]; // 다음으로 움직일 x,y 좌표 최신화 
				int nextY = now.y+moveY[i];
				
				if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) continue; // 만약 움직인 장소가 맵 범위를 넘어가는 경우, 다른 경우로 패스
				if(maps[nextX][nextY]==0) continue; // 벽인 경우, 패스
				if(!visited[nextX][nextY]) { // 방문하지 않은 노드인 경우, 
					queue.add(new Pair(nextX,nextY)); // 큐에 해당 노드 추가,
					visited[nextX][nextY] = true; // 해당 노드 방문 처리,
					leastDistance[nextX][nextY] = leastDistance[now.x][now.y]+1; // 해당 노드까지의 최소 거리 최신화
				}
			}	
		}
		if(visited[n-1][m-1]) return leastDistance[n-1][m-1]+1;
		else return -1;
	}
	public static void main(String[] args) {
		int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(solution(maps1));
		System.out.println(solution(maps2));
	}
}
