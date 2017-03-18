package Strings;
/**
 * Cracking the Coding Interview 6th Edition
 *
 * 1.1 String Rotation:
 * Implement an algorithm to determine if a string has all
 * unique characters. What if you cannot use additional
 * data structures?
 */

import java.util.*;

public class IsUnique {

	/**
	 * Logic: put character into a set
	 * if character exists, return false
	 *
	 * Assumptions: if s is null or empty, return true
	 *
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static boolean uniqueWithSet(String s) {
		if(s == null || s.isEmpty()) return true;

		Set<Character> characterSet = new HashSet<>();

		int len = s.length();
		for(int i = 0; i < len; i++) {
			if(characterSet.contains(s.charAt(i))) {
				return false;
			}
			characterSet.add(s.charAt(i));
		}

		return true;
	}

	/**
	 * Logic: create an array with first 256 ascii values
	 * check flag as we iterate through the string
	 *
	 * Assumptions: string only consists of first 256
	 * ascii values
	 *
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static boolean uniqueWithArray(String s) {
		if(s == null || s.isEmpty()) return true;

		boolean[] asciiFlags = new boolean[256];
		for(int i = 0; i < 256; i++) {
			asciiFlags[i] = false;
		}

		int len = s.length();
		for(int i = 0; i < len; i++) {
			if(asciiFlags[s.charAt(i)]) {
				return false;
			}
			asciiFlags[s.charAt(i)] = true;
		}

		return true;
	}

	/**
	 * Logic: compare each character with every other
	 * character
	 *
	 * Assumptions: if s is null or empty, return true
	 *
	 * Time complexity: O(n^2)
	 * Space complexity: O(1)
	 */
	public static boolean uniqueWithoutExtraMemory(String s) {
		if(s == null || s.isEmpty()) return true;

		int len = s.length();
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				if(s.charAt(i) == s.charAt(j)) return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(uniqueWithSet(""));		// true
		System.out.println(uniqueWithSet(null));	// true
		System.out.println(uniqueWithSet("abc")); // true
		System.out.println(uniqueWithSet("aba")); // false

		System.out.println(uniqueWithArray(""));			// true
		System.out.println(uniqueWithArray(null));		// true
		System.out.println(uniqueWithArray("abc"));		// true
		System.out.println(uniqueWithArray("aba"));		// false

		System.out.println(uniqueWithoutExtraMemory(""));			// true
		System.out.println(uniqueWithoutExtraMemory(null));		// true
		System.out.println(uniqueWithoutExtraMemory("abc"));	// true
		System.out.println(uniqueWithoutExtraMemory("aba"));	// false
	}
}