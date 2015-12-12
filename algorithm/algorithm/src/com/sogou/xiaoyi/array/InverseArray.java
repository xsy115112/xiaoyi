package com.sogou.xiaoyi.array;

import org.junit.Test;

public class InverseArray {
	//Ωªªª
	public <T> void swap(T[] array,int a,int b){
		T temp = array[a];
		array[a] = array[b];
		array[b]= temp;
	}
	//¥Ú”°
	public <T> void printArr(T[] arr){
		for(T a:arr){
			System.out.print(a+"   ");
		}
		System.out.println("");
	}
	//inverse
	public <T> void inverse01(T[] array){
		if(array == null || array.length<=1){
			return;
		}
		for(int i=0,j=array.length-1;i<j;i++,j--){
			swap(array,i,j);
		}
	}
	//inverse
	public <T> void inverse02(T[] array){
		if(array == null || array.length<=1){
			return;
		}
		int len = array.length;
		int half = len / 2;
		for(int i=0;i<half;i++){
			swap(array,i,len-i-1);
		}
	} 
	
	@Test
	public void testInverse01(){
		Integer [] arr1 = {1,2,3,4,5,6,7};
		printArr(arr1);
		inverse01(arr1);
		printArr(arr1);
		Integer [] arr2 = {1,2,3,4,5,6};
		printArr(arr2);
		inverse01(arr2);
		printArr(arr2);
	}
	@Test
	public void testInverse02(){
		Integer [] arr1 = {1,2,3,4,5,6,7};
		printArr(arr1);
		inverse02(arr1);
		printArr(arr1);
		Integer [] arr2 = {1,2,3,4,5,6};
		printArr(arr2);
		inverse02(arr2);
		printArr(arr2);
	}
}
