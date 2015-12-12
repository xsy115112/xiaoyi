package com.sogou.xiaoyi.array;

import org.junit.Test;

public class RotateArray {
	//½»»»
	public void swap(int[] array,int a,int b){
		int temp = array[a];
		array[a] = array[b];
		array[b]= temp;
	}
	//´òÓ¡
	public void printArr(int[] arr){
		for(int a:arr){
			System.out.print(a+"   ");
		}
		System.out.println("");
	}
	//inverse
	public void inverse(int[] array,int start,int end){
		if(array == null || array.length<=1){
			return;
		}
		for(int i=start,j=end;i<j;i++,j--){
			swap(array,i,j);
		}
	}
	
	public void rotate(int[] nums, int k) {
		if(k<0){
			return ;
		}
		int len = nums.length;
		if(k>len){
			k = k%len;
		}
		inverse(nums, 0, len-k-1);
		inverse(nums, len-k, len-1);
		inverse(nums, 0, len-1);
	}
	
	@Test
	public void testRotate(){
		int [] nums = {1,2,3,4,5,6,7};
		printArr(nums);
		rotate(nums, 3);
		printArr(nums);
	}
	
}
