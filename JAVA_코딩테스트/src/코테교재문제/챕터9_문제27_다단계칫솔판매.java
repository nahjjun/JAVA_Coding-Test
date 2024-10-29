package 코테교재문제;
import java.util.*;
public class 챕터9_문제27_다단계칫솔판매 {
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		HashMap<String, Integer> sellerMoney = new HashMap<>(); // 각 판매원마다 번 돈을 기록할 해시맵
		HashMap<String, String> sellerParent = new HashMap<>(); // 각 판매원의 부모를 담은 해시맵 
		List<Integer> result = new ArrayList<>();
		
		 // 초기화
		for (int i = 0; i < enroll.length; ++i) {
            sellerMoney.put(enroll[i], 0);
            sellerParent.put(enroll[i], referral[i]);
        }
		
	    // 판매 금액을 기록 및 분배
		for (int i = 0; i < seller.length; ++i) {
            String currentSeller = seller[i];
            int currentAmount = amount[i] * 100;
            
            while (!currentSeller.equals("-")) {
                int giveMoney = currentAmount / 10;
                int keepMoney = currentAmount - giveMoney;
                
                sellerMoney.put(currentSeller, sellerMoney.get(currentSeller) + keepMoney);
                
                if (giveMoney < 1) break; // 만약 10퍼센트를 계산한 금액이 1원 미만이면 이득을 분배하지 않고 자신이 모두 가진다.
                
                currentSeller = sellerParent.get(currentSeller);
                currentAmount = giveMoney;
            }
        }
		for(String s:enroll) result.add(sellerMoney.get(s));
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12,4,2,5,10}; // 각자 다른 양을 판매
        
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }
}
