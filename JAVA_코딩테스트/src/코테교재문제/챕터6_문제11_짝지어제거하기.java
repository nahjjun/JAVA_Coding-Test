package 코테교재문제;
import java.util.*;
public class 챕터6_문제11_짝지어제거하기 {
	public static int solution(String _s) {
		Stack<Character> stack = new Stack<>();
		for(char c:_s.toCharArray()) {
			if(stack.isEmpty() || !stack.peek().equals(c)) {
				stack.push(c);
			}
			else {
				stack.pop();
			}
		}
		if(stack.isEmpty()) return 1;
		else return 0;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String s = scan.next();
		System.out.println(solution(s));
		scan.close();
	}
}
