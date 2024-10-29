package 코테교재문제;
import java.util.*;
public class 챕터10_문제31_폰켓몬 {
	public static int solution(int[] nums) {
		HashSet<Integer> numSet = new HashSet<>();
		for(int i:nums) {
			numSet.add(i);
		}
		if(nums.length/2 <= numSet.size()) return nums.length/2;
		else return numSet.size();
	}
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
		System.out.println(solution(nums));
	}
}
