package 코테교재문제;
import java.util.*;
public class 챕터10_문제30_간단한유니온파인드알고리즘구현하기 {
	static int[] set = new int[1001]; // 각 노드들의 부모를 담는 int형 배열
	static ArrayList<Boolean> result = new ArrayList<>();
	public static Boolean[] solution(int[][] operations) {
		for(int i=0; i<1001; ++i) {
			set[i] = i;
		}
		
		
		for(int[] operation:operations) {
			int x = operation[1];
			int y = operation[2];
			if(operation[0] == 0) { // union 연산인 경우
				union(x,y);
			}
			else { // equals 연산인 경우
				if(find(x) == find(y)) result.add(true);
				else result.add(false);
			}
		}
		return result.toArray(new Boolean[0]);
	}
	public static void union(int x, int y) { // 유니온 파인드 알고리즘의 합치기 연산은 "두 집합의 루트 노드를 같게 하는 것이다." 
		int root1 = find(x); // 각 값이 들어 있는 집합의 루트 노드를 find 함수로 찾는다.
		int root2 = find(y);
		set[root2] = root1;
	}
	public static int find(int i) {
		int current = i;
		while(set[current] != current) {
			current = set[current];
		}
		return current;
	}
	public static void main(String[] args) {
		int[][] operations = {{0,0,1},{1,1,2},{0,1,2},{1,0,2}};
		System.out.println(Arrays.toString(solution(operations)));
	}
}
