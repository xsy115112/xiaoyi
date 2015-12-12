package com.sogou.xiaoyi.array;

import org.junit.Test;

public class TwoSum {
	//O(n2)
	public void twoSum01(int [] array,int s){
		if(array ==null || array.length<=1){
			return ;
		}
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]+array[j] == s){
					System.out.println(array[i]+"+"+array[j]+"="+s);
					break;
				}
			}
		}
	}
	//O(n)
	public void twoSum02(int [] array,int s){
		if(array ==null || array.length<=1){
			return ;
		}
		int i=0,j=array.length-1;
		while(i<=j){
			int sum = array[i]+array[j];
			if(sum>s){
				j--;
			}else if(sum<s){
				i++;
			}else{
				System.out.println(array[i]+"+"+array[j]+"="+s);
				i++;
				j--;
			}
		}
	}
	//二分查找
	public int binarySearch(int[] array, int key){
		int low = 0;
		int high = array.length-1;
		while(low <= high){
			int mid = (low+high) >>> 1;
			if(key > array[mid]){
				low = mid + 1;
			}else if(key < array[mid]){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	//O(nlong2N)(二分查找法）
	public void twoSum03(int [] array,int s){
		if(array ==null || array.length<=1){
			return ;
		}
		int len = array.length;
		for(int i=0;i<len-1;i++){
			int another = s - array[i];
			if(binarySearch(array, another)>=i+1){
				System.out.println(array[i]+"+"+another+"="+s);
			}
		}
	}
	
	@Test
	public void testTwoSum(){
		int [] array = {1,3,4,5,8,9,11};
		int s = 13;
		twoSum01(array, s);
		twoSum02(array, s);
		twoSum03(array, s);
	}
}
