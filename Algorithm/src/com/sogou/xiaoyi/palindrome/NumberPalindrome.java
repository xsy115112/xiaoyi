package com.sogou.xiaoyi.palindrome;

public class NumberPalindrome {
	
	public int wei(int x){
		int count = 0;
		while (x>0) {
			x/=10;
			count++;
		}
		return count;
	}
	
	public boolean isPalindrome(int x) {
        if(x<0){
        		return false;
        }else if(x<10){
        		return true;
        }else{
        		int wei = wei(x);
        		int t = (int) Math.pow(10, wei-1);
        		int half = wei >> 1;
        		int n = x;
        		for(int i=0;i<half;i++){
        			if(x/t%10 == n%10){
        				t/=10;
        				n/=10;
        			}else{
        				return false;
        			}
        		}
        		return true;
        }
    }
	
}
