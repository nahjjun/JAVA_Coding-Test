package 코테교재문제;
import java.util.*;
public class 챕터13_문제51 {
	public static int[] solution(int[] arr1, int[] arr2) {
		ArrayList<Integer> newArr = new ArrayList<>();
		
		Queue<Integer> q1 = new ArrayDeque<>(), q2 = new ArrayDeque();
		for(int i:arr1) q1.add(i);
		for(int i:arr2) q2.add(i);
		
		while(!(q1.isEmpty() && q2.isEmpty())) {
			if(q1.isEmpty() || q1.peek()>q2.peek()) // q1이 비었거나 q2의 제일 앞의 요소가 더 작으면
				newArr.add(q2.poll()); // q2의 제일 앞의 요소를 추가한다
			else if (q2.isEmpty() || q1.peek()<=q2.peek()) // q2이 비었거나 q1의 제일 앞의 요소가 더 작거나 같으면 
				newArr.add(q1.poll()); // q1의 제일 앞의 요소를 추가한다
		}
		
		return newArr.stream().mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {
		int[] arr1 = {1,3,5};
		int[] arr2 = {2,4,6};
		
		System.out.println(Arrays.toString(solution(arr1, arr2)));
		
		
	}
}
