package 코테교재문제;

public class 챕터9_문제26_예상대진표 {
	public static int solution(int N, int A, int B) {
		int[] arr = new int[N]; // 참가자들의 번호를 담을 배열
		int round=0; // 라운드 수를 나타낼 변수
		
		// A와 B는 계속해서 숫자 번호를 새로 받으므로, 인덱스로 최신화해주는 것이 맞다. 따라서 다른 배열값들은 건들 필요가 없다
		while(A!=B) {
			++round;
			A = (A+1)/2; // A는 자신의 부모 노드로 옮겨주는 되는것.
			B = (B+1)/2; 
		}
		return round;
	}
	public static void main(String[] args) {
		int N = 8;
		int A = 4;
		int B = 7;
		
		System.out.println(solution(N,A,B));
	}
}