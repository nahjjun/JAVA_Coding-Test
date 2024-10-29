package 코테교재문제;

import java.util.ArrayList;
import java.util.Arrays;

public class 챕터13_문제54 {
	public static int doSolution(int[] array, int[] command) {
		ArrayList<Integer> tmpArr = new ArrayList<>();
		for(int i=command[0]-1; i<=command[1]-1; ++i) {
			tmpArr.add(array[i]);
		}
		tmpArr.sort(null);;
		return tmpArr.get(command[2]-1);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int commandCount = commands.length; // 명령 반복 횟수
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<commandCount; ++i) {
			result.add(doSolution(array, commands[i]));
		}
		return result.stream().mapToInt(Integer::intValue).toArray();	
	}
	
	public static void main(String[] args) {
		int []array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println(Arrays.toString(solution(array, commands)));
	}
}
