package com.sogou.xiaoyi.recursion;

public class Test {
	
	public static void main(String[] args) {
		int [] a = {1,2,4,5,8,2,3,4,10,470,23,45,67,23};
		//BubbleSorter(a);
		quickSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print("     "+a[i]);
		}
		System.out.println("\n");
		System.out.println(binarySearch(a, 10));
	}

	//???æ³?
	public static void BubbleSorter (int[] list){
		for(int i=0;i<list.length;i++){
			for(int j=i+1;j<list.length;j++){
				if(list[i] > list[j]){
					int temp = list[i];
					list[i] = list [j];
					list[j] = temp;
				}
			}
		}
	}
	//äº??????¥æ??
	public static int binarySearch(int[] list, int key){
		int low = 0;
		int high = list.length-1;
		while(low <= high){
			int mid = (low+high) >>> 1;
			if(key > list[mid]){
				low = mid + 1;
			}else if(key < list[mid]){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	//å¿???????åº?
	public static void quickSort(int[] arr,int left,int right){
		if(left < right){
			int low = left,high = right;
			int key = arr[low];
			while(low < high){
				while(low < high && arr[high] >= key){
					high --;
				}
				arr[low] = arr[high];
				while(low < high && arr[low] <= key){
					low ++;
				}
				arr[high] = arr[low];
			}
			arr[low] = key;
			
			quickSort(arr,left,low-1);
			quickSort(arr,low+1,right);
		}
	}
}
