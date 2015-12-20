package com.sogou.xiaoyi.palindrome;

public class LongestPalindrome {
	
	public boolean isPalndrome(String s,int start,int end){
		for(int i=start,j=end;i<j;i++,j--){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
	
	public String longestPalindrome(String s) {
		if(s == null || s.length()<=1){
			return s;
		}else{
			int len = s.length();
			int max = 0;
			int from = 0;
			int to = 1;
			for(int i=0;i<len;i++){
				for(int j=i;j<len;j++){
					if(isPalndrome(s, i, j)){
						if(j-i+1>=max){
							max = j-i+1;
							from = i;
							to = j;
						}
					}
				}
			}
			return s.substring(from, to);
		}
    }
	
	public String longestPalindrome01(String s) {
		if(s == null || s.length()<=1){
			return s;
		}else{
			int n = s.length();
			int max =0;
			int maxLeft = 0;
			int maxRight = 0;
			int start,end,left,right,len;
			for(int i=0;i<n;i++){
				start = i;
				end = i+1;
				left = start;
				right = end;
				len = 0;
				while(start>=0 && end<n){
					if(s.charAt(start) == s.charAt(end)){
						len  += 2;
						left = start;
						right = end;
						start --;
						end ++;
					}else{
						break;
					}
				}
				if(len>max){
					maxLeft = left;
					maxRight = right;
					max = len;
				}
				start = i-1;
				end = i+1;
				left = start;
				right = end;
				len = 1;
				while(start>=0 && end<n){
					if(s.charAt(start) == s.charAt(end)){
						len  += 2;
						left = start;
						right = end;
						start --;
						end ++;
					}else{
						break;
					}
				}
				if(len>max){
					maxLeft = left;
					maxRight = right;
					max = len;
				}
			}
			return s.substring(maxLeft,maxRight+1);
		}
    }
}
