package 코테교재문제;
import java.util.*;
public class 챕터6_문제9_10진수를2진수로변환하기 {
	public static int[] solution(int _input) {
		Stack<Integer> s = new Stack<>();
		
		while(_input > 1) {
			s.push(_input%2);
			_input /= 2;
		}
		if(_input == 1) {
			s.push(1);
		}
		int result[] = new int[s.size()];
		int length = s.size();
		for(int i=0; i<length; ++i) {
			result[i] = s.pop();
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int[] result = solution(input);
		System.out.println(Arrays.toString(result));
		scan.close();
	}
}
