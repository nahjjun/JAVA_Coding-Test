package 코테교재문제;
import java.util.*;
public class 챕터6_문제12_주식가격 {
	public static int[] solution(int[] _prices) {
		int[] count = new int[_prices.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<count.length; ++i) {
			if(stack.isEmpty()) { // 스택이 빈 경우 현재 인덱스값 stack에 push
				stack.push(i);
				continue;
			}
			// 현재 인덱스값과 이전 인덱스값을 비교한다
			if(_prices[stack.peek()] <= _prices[i]) { //arr[i] ≥ prices[stack.top] 인 경우
				stack.push(i);
			}
			else { //arr[i] < prices[stack.top] 인 경우
				while(true) {
					int pop = stack.peek();
					if(_prices[pop] > _prices[i]) { // 만약 pop 인덱스값이 현재 인덱스값보다 더 크다면, 해당 pop 인덱스값은 count가 정해진 것이다
						count[pop] = i-pop;
						stack.pop();
					}
					else {
						stack.push(i);
						break;
					}
				}
			}	
		}
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			count[tmp] = _prices.length-1-tmp;
		}
		
		return count;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int prices[] = new int[N];
		for(int i=0; i<N; ++i) {
			prices[i] = scan.nextInt();
		}
		System.out.println(Arrays.toString(solution(prices)));
		scan.close();
	}
}
