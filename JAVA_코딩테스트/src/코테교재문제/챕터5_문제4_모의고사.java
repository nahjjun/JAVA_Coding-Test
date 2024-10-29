package 코테교재문제;
import java.util.*;

public class 챕터5_문제4_모의고사 {
	public static int[] solution(int[] _arr) {
		int[] count = new int[3];
		int[][] tmp = {
				{1,2,3,4,5},
				{2,1,2,3,2,4,2,5},
				{3,3,1,1,2,2,4,4,5,5}
		};
		
		for(int i=0; i<3; ++i) {
			for(int j=0; j<_arr.length; ++j) {
				if(_arr[j] == tmp[i][j%tmp[i].length]) {
					++count[i];
				}
			}
		}
		int max = Arrays.stream(count).max().getAsInt();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<3; ++i) {
			if(max == count[i]) {
				result.add(i+1);
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		int[] result = solution(answers);
		System.out.print(Arrays.toString(result));
				
	}
}

