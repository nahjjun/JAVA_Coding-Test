package 코테교재문제;
import java.util.*;
public class 챕터7_문제15_요세푸스문제 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(), K = scan.nextInt();
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; ++i) {
			q.add(i);
		}
		
		while(N>1) {
			for(int i=0; i<K-1; ++i) {
				int front = q.poll();
				q.add(front);
			}
			q.poll();
			--N;
		}
		System.out.println(q.poll());
		scan.close();
	}
}
