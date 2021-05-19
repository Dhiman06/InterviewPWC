package JavaCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OccurenceOfCharacter {

	public static void main(String[] args) {

		String  word = null;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Please provide the word");
		word= sc.next();
		word = word.toLowerCase();
		
		Map<Character, Integer> charCount = new HashMap();
		for(Character ch: word.toCharArray()) {
			if(charCount.containsKey(ch)) {
				charCount.put(ch, charCount.get(ch)+1);
			}
			else {
				charCount.put(ch, 1);
			}
		}
		
		System.out.println(charCount);
		
		

	}

}
