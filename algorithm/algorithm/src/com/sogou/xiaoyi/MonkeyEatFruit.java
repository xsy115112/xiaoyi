package com.sogou.xiaoyi;

import org.junit.Test;

public class MonkeyEatFruit {
	//µÝ¹é
	public int eatFruit(int n){
		if(n == 1){
			return 1;
		}
		return 2*eatFruit(n-1)+2;
	}
	//Ñ­»·
	public int eatFruit01(int n){
		int num = 1;
		for(int i=1;i<n;i++){
			num = 2*num + 2;
		}
		return num;
	}
	
	@Test
	public void testEatFruit(){
		System.out.println(eatFruit(10));
		System.out.println(eatFruit01(10));
	}
}
