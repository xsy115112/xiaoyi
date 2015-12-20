package com.sogou.xiaoyi.palindrome;

import org.junit.Test;

public class PalindromeString {

	public boolean isPalindrom(String str){
		if(str == null || str.length()<=1){
			return true;
		}else{
			for(int i=0,j=str.length()-1;i<j;i++,j--){
				if(str.charAt(i) != str.charAt(j)){
					return false;
				}
			}
			return true;
		}
	}
	
	@Test
	public void testIsPalindrom(){
		System.out.println(isPalindrom("abcdcba"));
		System.out.println(isPalindrom("abcdeba"));
		System.out.println(isPalindrom("abccba"));
		System.out.println(isPalindrom("abcd"));
		System.out.println(isPalindrom("Çï½­³þÑãËÞÉ³ÖÞ ÑãËÞÉ³ÖÞÇ³Ë®Á÷ Á÷Ë®Ç³ÖÞÉ³ËÞÑã ÖÞÉ³ËÞÑã³þ½­Çï"));
	}
}
