package Strings;
/**
 * Cracking the Coding Interview 6th Edition
 *
 * 1.9 String Rotation:
 * Assume you have a method isSubstring, which checks if one
 * word is a substring of another. Given two strings, s1, and
 * s2, write code to check if s2 is a rotation of s1 using
 * only one call to isSubstring (e.g., "waterbottle" is a
 * rotation of "erbottlewat").
 */

public class StringRotation {

	/**
	 * Logic: concatenating the string with itself, the other
	 * string should be a substring of that new string
	 *
	 * Assumptions: if s1 or s2 are null, return false
	 * if s1 or s2 are the empty string, return false
	 */
	public static boolean isRotation(String s1, String s2) {
		if(s1 == null || s2 == null) return false;
		if(s1.isEmpty() || s2.isEmpty()) return false;

		return isSubstring(s1, s2 + s2);
	}

	public static boolean isSubstring(String needle, String haystack) {
		for(int i = 0; ; i++) {
			for(int j = 0; ; j++) {
				if(j == needle.length()) return true;
				if(i + j == haystack.length()) return false;
				if(needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat")); // true
		System.out.println(isRotation("abc", "def")); // false
		System.out.println(isRotation(null, "abc")); // false
		System.out.println(isRotation("abc", null)); // false
		System.out.println(isRotation("", "abc")); // false
		System.out.println(isRotation("abc", "")); // false
	}
}