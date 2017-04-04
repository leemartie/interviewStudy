package Strings;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class ReverseSentence {

	/**
	 * Char swap
	 */
	public static void swap(char[] s, int index1, int index2) {
		char temp = s[index1];
		s[index1] = s[index2];
		s[index2] = temp;
	}

	public static void swapStr(char[] s, int bottom, int top) {
		int count = 0;
		for (int i = bottom; i <= top; i++) {
			swap(s, i, top - count);
			count++;

			if (count > ((top - bottom) / 2)) {
				break;
			}
		}
	}

	/**
	 * In place version
	 * reverse sentence
	 * then reverse each word in sentence
	 * @param s
	 * @return
	 */
	public static String rev(char[] s) {

		swapStr(s, 0, s.length - 1);

		// System.out.println(new String(s));

		int b = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				swapStr(s, b, i - 1);
				b = i + 1;
			}

		}

		swapStr(s, b, s.length - 1);

		return new String(s);

	}

	/**
	 * append version
	 * @param sen
	 * @return
	 */
	public static String rev(String sen) {

		StringBuilder sb = new StringBuilder();

		for (int i = sen.length() - 1; i >= 0; i--) {

			if (sen.charAt(i) == ' ') {

				String word = sen.substring(i + 1, sen.length() - sb.length());
				sb.append(word).append(" ");

			}

		}

		String word = sen.substring(0, sen.length() - sb.length());
		sb.append(word).append(" ");

		return sb.toString();

	}

	public static void main(String[] args) {

		// rev("the sky is blue"); // should return "blue is sky the"
		System.out.println(rev("the sky is blue")); // nice
		System.out.println(rev("blue")); // should return "blue"
		System.out.println(rev("blue magic"));
		System.out.println(rev("blue magic carpet"));
		
		System.out.println("========================");
		System.out.println(rev("the sky is blue".toCharArray())); // nice
		System.out.println(rev("blue".toCharArray())); // should return "blue"
		System.out.println(rev("blue magic".toCharArray()));
		System.out.println(rev("blue magic carpet".toCharArray()));
	}
}
