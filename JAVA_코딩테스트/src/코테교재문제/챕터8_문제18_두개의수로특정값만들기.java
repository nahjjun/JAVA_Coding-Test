package 코테교재문제;
import java.util.*;
public class 챕터8_문제18_두개의수로특정값만들기 {
	public static boolean solution(int[] arr, int target) {
		HashSet<Integer> hset = new HashSet<>();
		for(int i:arr) hset.add(i);
		
		for(Integer i:hset) {
			if(target == i*2)continue;
			if(hset.contains(target-i)) {return true;}
		}
		return false;
	}
	public static void main(String[] args) {
		int []arr =  {1,2,3,4,8};
		int target = 6;
		
		System.out.println(solution(arr, target));
	}
}
