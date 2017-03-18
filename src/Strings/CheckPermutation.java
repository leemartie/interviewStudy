/**
 * Cracking the Coding Interview 6th Edition
 *
 * 1.2 Check Permutation:
 * Given two strings, write a method to decide if one is
 * a permutation of the other.
 */

import java.util.*;

public class CheckPermutation {

	/**
	 * Logic: put characters into a map with
	 * key = character, value = count for first word
	 * for second word, subtract from value
	 * finally, check that all values are 0
	 *
	 * Assumptions: no whitespace is included in the word
	 * word is limited to ascii characters
	 *
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static boolean checkPermutation(String s1, String s2) {
		if(s1 == null || s2 == null) return false;
		if(s1.length() != s2.length()) return false;

		Map<Character, Integer> counts = new HashMap<>();

		int len = s1.length();
		for(int i = 0; i < len; i++) {
			if(counts.containsKey(s1.charAt(i))) {
				int currentValue = counts.get(s1.charAt(i));
				counts.put(s1.charAt(i), currentValue + 1);
			}
			else {
				counts.put(s1.charAt(i), 1);
			}
		}

		len = s2.length();
		for(int i = 0; i < len; i++) {
			if(!counts.containsKey(s2.charAt(i))) {
				return false;
			}
			else {
				int currentValue = counts.get(s2.charAt(i));

				if(currentValue == 0) return false;

				counts.put(s2.charAt(i), currentValue - 1);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkPermutation(null, null));		// false
		System.out.println(checkPermutation("", null));			// false
		System.out.println(checkPermutation(null, ""));			// false
		System.out.println(checkPermutation("abc", ""));		// false
		System.out.println(checkPermutation("", "abc"));		// false
		System.out.println(checkPermutation("abc", "def"));	// false
		System.out.println(checkPermutation("abc", "bac"));	// true
	}
}