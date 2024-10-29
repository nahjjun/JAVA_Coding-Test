package 코테교재문제;
import java.util.*;
public class 챕터12_문제45_피로도 {
	public static int result=0;
	public static int[][] Dungeons;
	public static int solution(int k, int[][] dungeons) {
		Dungeons = dungeons;
		for(int i=0; i<Dungeons.length; ++i) {
			int tmp=0;
			ArrayList<Integer> rDungeons = new ArrayList<>();
			for(int j=0; j<Dungeons.length; ++j) rDungeons.add(j); 
			backtracking(i,tmp, rDungeons, k); // 백트래킹으로 해당 던전으로 시작했을 때 나올 결과를 tmp로 반환 
		}
		return result;
	}
	
	public static boolean canGetIn(int leastPrice, int k) {return leastPrice<=k;}

	
	// start: 시작 던전, result: 해당 던전을 시작으로 했을 때 돌 수 있는 던전의 수
	//rDungeons: 남은 던전 리스트, k: 남은 피로도
	public static void backtracking(int start, int tmp, ArrayList<Integer> rDungeons, int k) {    
		if(rDungeons.isEmpty() || !canGetIn(Dungeons[start][0], k)) return; // 남은 던전이 없어지거나 해당 던전에 들어갈 수 없으면 종료(유망함수)
		ArrayList<Integer> tmpList = new ArrayList<>(rDungeons); // 현재 남은 던전을 넣어놓을 리스트
		tmpList.remove(Integer.valueOf(start));// 만약 현재 던전이 피로도 조건에 맞는다면 rDungeons 리스트에서 제외한다.
		k = k-Dungeons[start][1]; // 남은 피로도 최신화
		++tmp; // 결과 증가시키기
		result = Integer.max(result, tmp); // 해당 결과를 최신화
		for(int next:tmpList) { // 남은 던전들 중에 더 돌 수 있는 던전이 있는지 계속 진행
			backtracking(next, tmp, tmpList, k);
		}
	}
	public static void main(String[] args) {
		int k=80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		System.out.println(solution(k, dungeons));
		
	}
}
