import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static boolean isOk(List addArr) {
		if(addArr.size() % 2 == 0) {
			String firfix = "";
			String endfix = "";
			for(int i = (addArr.size() / 2) - 1; i >= 0; i--) {
				firfix += addArr.get(i);
			}
			
			for(int i = (addArr.size() / 2); i < addArr.size(); i++) {
				endfix += addArr.get(i);
			}
			
			if(firfix.equals(endfix))
				return true;
			else
				return false;
		}
		else{
			String firfix = "";
			String endfix = "";
			for(int i = (addArr.size() / 2) - 1; i >= 0; i--) {
				firfix += addArr.get(i);
			}
			
			for(int i = (addArr.size() / 2) + 1; i < addArr.size(); i++) {
				endfix += addArr.get(i);
			}
			if(firfix.equals(endfix))
				return true;
			else
				return false;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		// 문자열을 쪼개서 배열에 저장
		char[] arr = str.toCharArray();
		
		// 결과 문자길이 저장 변수
		int result = 0;
		
		// 문자 추가할 수 있게 List로 배열을 다시 재정의
		List<Character> addArr = new ArrayList<>();
	
		// 만약 회문이면 while문 탈출하도록 false반환
		boolean ok = true;
		
		int max = 0;
		for(int i = str.length()-1; i >= 0; i--) {
			addArr.add(arr[i]);
			if(isOk(addArr)) {
				max = addArr.size();
			}
		}
		for(int i = addArr.size()-max-1; i >=0; i--) {
			addArr.add(arr[i]);
		}
		
		System.out.println(addArr.size());
		
		
	}
}
