package 코테교재문제;


public class 챕터5_문제6_실패율 {
	/*
	public static int[] solution(int _n, int[] _stages) {
		HashMap<Integer, Double> fail = new HashMap<Integer, Double>(); // HashMap에 해당 번호 스테이지의 실패율을 key와 value값으로 저장
		double remain = _stages.length;
		double[] count= new double[_n];	// 각 숫자들의 카운트 수를 count 배열에 저장
		for(int j=0; j<_stages.length; ++j) {
			++count[_stages[j]];
		}
		for(int i=1; i<=_n; ++i) {
			if(count[i] == 0) {
				fail.put(i, 0.);
			}
			else {
				fail.put(i, count[i]/remain);
				remain -= count[i];	
			}
		}
		
		return 
		
	}
	*/
	public static void main(String[] args) {
		
	}
}
