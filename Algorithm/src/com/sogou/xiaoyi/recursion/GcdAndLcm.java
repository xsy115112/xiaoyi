package com.sogou.xiaoyi.recursion;

import org.junit.Test;

public class GcdAndLcm {
	//µ›Õ∆
	public int gcd(int m,int n) {
		if(m !=0 && n!=0){
			int max = Math.max(m, n);
			int min = Math.min(m, n);
			int r;
			while(max%min !=0){
				r = max%min;
				max = min;
				min = r;
			}
			return min;
		}else{
			return -1;
		}
	}
	//µ›πÈ
	public int gcd01(int m,int n){
		if(m != 0 && n!=0){
//			int max = Math.max(m, n);
//			int min = Math.min(m, n);
//			if(max%min==0){
//				return min;
//			}else{
//				return gcd01(min, max%min);
//			}
			return m>=n?m%n==0?n:gcd01(n, m%n):n%m==0?m:gcd01(m, n%m);
		}else{
			return -1;
		}
		//ºÚµ•À„∑®
	}
	//
	public int lcm(int m,int n) {
		return m*n/gcd(m, n);
	}
	
	@Test
	public void testGcd(){
		System.out.println(gcd(25, 100));
		System.out.println(lcm(25, 100));
		System.out.println(gcd01(25, 100));
	}
}
