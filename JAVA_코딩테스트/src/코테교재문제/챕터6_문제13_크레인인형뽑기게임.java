package 코테교재문제;
import java.util.*;
public class 챕터6_문제13_크레인인형뽑기게임 {
	public static int solution(int[][] _selectArr, int[] _moves) {
		int row = _selectArr.length;
		int col = _selectArr[0].length;
		int count=0; // bucket에서 사라진 인형 쌍의 개수
		Stack<Integer> bucket = new Stack<>(); // 뽑은 인형을 넣을 바구니
		
		// stack들에게 인형을 열로 구분해서 넣는다.
		Stack<Integer> stack[] = new Stack[col];
		for(int j=0; j<col; ++j) {
			stack[j] = new Stack<Integer>();
			for(int i=row-1; i>=0; --i) {
				if(_selectArr[i][j] != 0)
					stack[j].push(_selectArr[i][j]);
			}
		}
		for(int i=0; i<_moves.length; ++i) {
			int select = _moves[i]-1;
			if(stack[select].isEmpty()) continue;
			int tmp = stack[select].pop();
			if(bucket.isEmpty() || bucket.peek() != tmp) {
				bucket.push(tmp);
			}
			else {
				bucket.pop();
				++count;
			}
		}
		return count*2;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("2차원 배열의 nxn 크기의 n을 입력하세요: ");
		int n = scan.nextInt();
		int[][] selectArray = new int[n][n];
		System.out.println("2차원 배열을 입력하세요: ");
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				selectArray[i][j] = scan.nextInt();
			}
		}
		System.out.print("명령어 길이를 입력하세요: ");
		int movesLength = scan.nextInt();
		System.out.print("명령어를 입력하세요: ");;
		int[] moves = new int[movesLength];
		for(int i=0; i<movesLength; ++i) {
			moves[i] = scan.nextInt();
		}
		int count = solution(selectArray, moves);
		System.out.println(count);
		scan.close();
	}
}
