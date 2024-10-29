package 코테교재문제;
import java.util.*;
public class 챕터9_문제25_트리순회 {
	public static void preorder(StringBuilder result, int[] nodes, int i) {
		if(i>=nodes.length) return;
		result.append(nodes[i]).append(" ");
		preorder(result, nodes, i*2+1); // 왼쪽 자식
		preorder(result, nodes, i*2+2); // 오른쪽 자식
	}
	public static void inorder(StringBuilder result, int[] nodes, int i) {
		if(i>=nodes.length) return;
		inorder(result, nodes, i*2+1); // 왼쪽 자식
		result.append(nodes[i]).append(" ");
		inorder(result, nodes, i*2+2); // 오른쪽 자식
	}
	public static void postorder(StringBuilder result, int[] nodes, int i) {
		if(i>=nodes.length) return;
		postorder(result, nodes, i*2+1); // 왼쪽 자식
		postorder(result, nodes, i*2+2); // 오른쪽 자식
		result.append(nodes[i]).append(" ");
	}

	public static String[] solution(int[] nodes) {
		StringBuilder[] result=new StringBuilder[3];
		result[0] = new StringBuilder(); // 전위 순회
		result[1] = new StringBuilder(); // 중위 순회
		result[2] = new StringBuilder(); // 후위 순회
		
		preorder(result[0], nodes, 0);
		inorder(result[1], nodes, 0);
		postorder(result[2], nodes, 0);
		
		return Arrays.stream(result).map(StringBuilder::toString).map(String::trim).toArray(String[]::new);
	}
	public static void main(String[] args) {
		int[] nodes = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(solution(nodes)));
		
	}
}
