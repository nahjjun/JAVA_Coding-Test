package 코테교재문제;
import java.util.*;
public class 챕터12_문제43_1부터N까지조합구하기 {
	public static ArrayList<ArrayList<Integer>> result; // 결과를 저장할 리스트 배열
	public static int N; 
	
	public static void backtracking(int sum, int start, ArrayList<Integer> selectedList) { // sum=해당 배열 조합의 합, start=현재 위치한 배열(처음 시작할 숫자), selectedList=해당 배열 조합을 저장할 리스트
		if(sum == 10) {
			result.add(selectedList);
			return;
		}
		for(int i=start; i<=N; ++i) {
			if(sum+i<=10) {
				ArrayList<Integer> list = new ArrayList<>(selectedList); // 이전에 받은 선택된 리스트를 생성자의 인자로 줘서 초기화한다. 
				list.add(i);
				backtracking(sum+i, i+1, list); // 새로운 총합값을 재귀로 값을 주고, 새로 더한 값보다 1 큰 값을 검사하도록 인자로 준다.
			}
		}
	}
	public static ArrayList<ArrayList<Integer>> solution(int n){
		N = n;
		result = new ArrayList<>();
		backtracking(0,1,new ArrayList<>()); // 시작할 때 총합은 0이고, 검사 시작 위치는 1이다. List를 선언해준다.
		return result;
	}
	public static void main(String[] args) {
		int N=5;
		System.out.println(solution(N).toString());
	}
}
