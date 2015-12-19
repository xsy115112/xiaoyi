package com.sogou.xiaoyi.array;

import org.junit.Test;

public class SerialSum {
	//Êä³ö
	public void printlnResult(int start,int end){
		for(int i=start;i<=end;i++){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//
	public void addSum(int s){
		int start = 1,end = 2;
		int sum = start + end;
		int half = (s+1)/2;
		while(start<half){
			if(sum == s){
				printlnResult(start, end);
				sum -= start;
				start++;
				end++;
				sum += end;
			}else if(sum<s){
				end++;
				sum += end;
			}else{
				sum -= start;
				start++;
			}
		}
	}
	
	@Test
	public void test(){
		addSum(21);
	}
}
