package com.sogou.xiaoyi;

import org.junit.Test;

public class CommonSum {

	//�ǵݹ�
	public int sum(int n){
		int sum = 0;
		for(int i=1;i<=n;i++){
			sum += i;
		}
		return sum;
	}
	//�ݹ�
	public int sum01(int n){
		if(n==1){
			return 1;
		}else{
			return n+sum01(n-1);
		}
	}
	//��͹�ʽ
	public int sum02(int n){
		return (n+1)*n/2;
	}
	//�쳣��ʽ
	public int sum03(int i,int[] arr) {
		try {
			arr[i] = arr[i - 1] + i;
			int k = sum03(i+1,arr);
			return k;
		} catch (ArrayIndexOutOfBoundsException e) {
			return arr[arr.length-1];
		}
	}
	
	@Test
	public void testSum(){
		System.out.println(sum(100));
		System.out.println(sum01(100));
		System.out.println(sum02(100));
		int[] arr = new int[101];
		System.out.println(sum03(1,arr));
	}
}
