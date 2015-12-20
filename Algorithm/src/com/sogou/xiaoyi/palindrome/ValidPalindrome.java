package com.sogou.xiaoyi.palindrome;

public class ValidPalindrome {
	
	public boolean isAlpha(char c){
		if((c>='0' && c<='9') || (c>='a' && c<='z')){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isPalindrome(String s) {
        if(s ==null || s.length()<=1){
        		return true;
        }else{
        		s = s.toLowerCase();
        		for(int i=0,j=s.length()-1;i<j;i++,j--){
        			while(i<j && !isAlpha(s.charAt(i))){
        				i++;
        			}
        			while(i<j && !isAlpha(s.charAt(j))){
        				j--;
        			}
        			if(s.charAt(i) != s.charAt(j)){
        				return false;
        			}
        		}
        		return true;
        }
    }
}
