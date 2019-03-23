package com.sogou.xiaoyi.string;

import org.junit.Test;

public class ReverseWord {
	
	public int i = 10;
	
	public void reverse(char[] s,int start,int end){
		char t ;
		for(;start<end;start++,end--){
			t = s[start];
			s[start] = s[end];
			s[end] = t;
		}
	}
	
	public void reverseWords(String s){
		if(s==null || s.length()<=1){
			return;
		}else{
			int n = s.length();
			int i=0;
			int j;
			//Íâ²ãÑ­»·
			while(i<n){
				j=i;
				while(j<n){
					if(s.charAt(j) == ' '){
						break;
					}else{
						j++;
					}
				}
				reverse(s.toCharArray(), i, j-1);
				while(j<n && s.charAt(j) == ' '){
					j++;
				}
				i = j;
			}
			reverse(s.toCharArray(), 0, n-1);
		}
	}
}
