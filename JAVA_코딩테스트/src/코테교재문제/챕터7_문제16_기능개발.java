package 코테교재문제;
import java.util.*;
public class 챕터7_문제16_기능개발 {
	public static int[] solution(int[] p, int[] s) {
		int[] arr = new int[p.length];
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=0; i<p.length; ++i) {
			int tmp = (100-p[i])%s[i];
			if(tmp == 0) arr[i] = (100-p[i])/s[i];
			else arr[i] = (100-p[i])/s[i]+1;
		}
		
		int day=arr[0]; // 지금까지 지난 일 수
		int result=1; // 각 배포마다 배포되는 기능의 개수
		for(int i=1; i<p.length; ++i) {
			if(arr[i] > day) { // 지금까지 지난일 수보다 기능 구현에 걸리는 시간이 오래걸리면, 아직 구현되지 않았기에 
				q.add(result);
				result=1;
				day = arr[i]; // 지금까지 지난 일 수 갱신
			}
			else ++result; // 지금까지 지난 일 수보다 작으면 이미 구현 완료된 기능이기에 기능의 개수 카운트 증가 
		}
		q.add(result);
		return q.stream().mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {
		int []progresses = {95,90,99,99,80,99};
		int []speeds = {1,1,1,1,1,1};
		
		int []result = solution(progresses, speeds);
		System.out.println(Arrays.toString(result));
	}
}
