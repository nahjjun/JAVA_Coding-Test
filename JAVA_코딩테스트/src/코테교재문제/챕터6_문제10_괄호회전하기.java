package 코테교재문제;
import java.util.*;
public class 챕터6_문제10_괄호회전하기 {
	// 정렬되었는지 확인해주는 함수
	public static boolean isSorted(StringBuilder _s) {
		// 각 스택 배열에는 순서대로 '()', '{}', '[]' 배열을 의미한다.
		Stack<Character> stack[] = new Stack[3];
		for(int i=0; i<3; ++i) stack[i] = new Stack<>();
		int choose=0;
		for(int i=0; i<_s.length(); ++i) {
			switch(_s.charAt(i)){
				case '(':
				case ')':
					choose = 0;
					break;
				case '{':
				case '}':
					choose = 1;
					break;
				case '[':
				case ']':
					choose = 2;
					break;
			}
			// 주어진 문자가 왼쪽인지, 오른쪽인지 구분하기 위한 조건문
			if(_s.charAt(i) == '(' || _s.charAt(i) == '{' || _s.charAt(i) == '[') {
				stack[choose].push(_s.charAt(i));
			}
			else {
				if(stack[choose].isEmpty()) {
					return false;
				}
				else {
					stack[choose].pop();
				}
			}
		}
		return stack[0].isEmpty() && stack[1].isEmpty() && stack[2].isEmpty(); 
		
	}
	public static int solution(StringBuilder _s) {
		int length = _s.length(); // 문자열의 길이
		int count=0;
		for(int i=0; i<length-1; ++i) {
			// 정렬 여부 검사
			if(isSorted(_s)) {
				++count;
			}
			// 배열 회전
			_s.append(_s.charAt(0));
			_s.deleteCharAt(0);
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String arr = scan.next();
		StringBuilder s = new StringBuilder(arr);
		int count = solution(s);
		System.out.println(count);
		
		scan.close();
	}
}
