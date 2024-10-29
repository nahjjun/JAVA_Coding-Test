package 코테교재문제;
import java.util.*;
public class 챕터11_문제39_미로탈출 {
	public static class Node{
		public int row, col;
		public Node(int _x, int _y) {
			row= _x;
			col = _y;
		}
	}
	public static final int[] moveX = {0,1,0,-1}; // 상,우,하,좌 순서
	public static final int[] moveY = {-1,0,1,0};
	
	public static int solution(String[] maps) {
		int n = maps.length;
		int m = maps[0].length();
		
		Node start = null, lever = null, end = null;
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<m; ++j) {
				if(start!=null && lever!=null && end!=null) break;
				if(maps[i].charAt(j)=='S') start = new Node(i,j);
				if(maps[i].charAt(j)=='L') lever = new Node(i,j);
				if(maps[i].charAt(j)=='E') end = new Node(i,j);
			}
		}
		int result1=bfs(maps, start, lever, n, m);
		int result2=bfs(maps, lever, end, n, m);
		if(result1 == -1 || result2 == -1) return -1;
		return result1+result2;
	}
	public static int bfs(String[] maps, Node start, Node end, int n, int m) { // 시작점부터 도착점까지 걸리는 최소 시간을 반환해주는 함수.
		boolean[][] visited = new boolean[n][m]; // 매번 방문 여부를 새로 만든다
		int[][] distance = new int[n][m];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<m; ++j) distance[i][j] = -1;
		}
		
		Queue<Node> queue = new ArrayDeque<>(); // bfs에 사용할 큐(검사할 노드들을 담고 있음)
		queue.add(start); // 시작 노드 추가
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(now.equals(end)) break;
			int nowDistance = distance[now.row][now.col]; // 현재 거리
			for(int i=0; i<4; ++i) {
				Node next = new Node(now.row+moveX[i], now.col+moveY[i]);
				if(next.row<0 || next.row>=n || next.col<0 || next.col>=m) continue; // 범위 벗어나면 취소 
				if(maps[next.row].charAt(next.col)=='X') continue; // 다음 노드가 벽인 경우
				if(!visited[next.row][next.col]) { // 방문하지 않은 노드면
					visited[next.row][next.col] = true; // 방문처리
					queue.add(next); // 큐에 삽입
					distance[next.row][next.col] = nowDistance+1;
				}
			}
		}
		if(distance[end.row][end.col]!=-1) return distance[end.row][end.col]+1;
		else return -1;
		
	}
	public static void main(String[] args) {
		String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
		System.out.println(solution(maps));
	}
}
