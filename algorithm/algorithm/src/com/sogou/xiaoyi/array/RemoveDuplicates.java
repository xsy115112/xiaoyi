package com.sogou.xiaoyi.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

 
public class RemoveDuplicates {
	//list
	public int removeDuplicates(int[] nums) {
		if(nums ==null || nums.length==0){
			return 0;
		}else if(nums.length==1){
			return 1;
		}else{
			List<Integer> arrList = new ArrayList<Integer>();
			int len = nums.length-1;
			int i = 0;
			while (i<=len) {
				if(i==len){
					arrList.add(nums[i]);
					i++;
				}else{
					int j = i+1;
					if(nums[i]==nums[j]){
						while (j<=len && nums[i] == nums[j]) {
							j++;
						}
					}
					arrList.add(nums[i]);
					i=j;
				}
			}
			//¸³Öµ
			for(int k=0;k<arrList.size();k++){
				nums[k] = arrList.get(k);
			}
			return arrList.size();
		}
	}
	
	@Test
	public void test(){
		int [] nums = {1,1};
		System.out.println(removeDuplicates(nums));
	}
}
