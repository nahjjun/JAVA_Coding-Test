package 코테교재문제;
import java.util.*;
public class 챕터6_문제8_올바른괄호 {
	public static boolean solution(String _input) {
		Stack<Character> s = new Stack<>();
		for(int i=0; i<_input.length(); ++i) {
			if(_input.charAt(i) == '(') {
				s.push('(');
			}
			else {
				if(s.isEmpty()) {
					return false;
				}
				else {
					s.pop();
				}
			}
		}
		if(s.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		boolean result = solution(input);
		System.out.println(result);
		scan.close();
	}
}
