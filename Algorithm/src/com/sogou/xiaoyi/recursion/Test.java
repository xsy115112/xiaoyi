package com.sogou.xiaoyi.recursion;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
//		int [] a = {1,2,4,5,8,2,3,4,10,470,23,45,67,23};
//		//BubbleSorter(a);
//		quickSort(a,0,a.length-1);
//		for(int i=0;i<a.length;i++){
//			System.out.print("     "+a[i]);
//		}
//		System.out.println("\n");
//		System.out.println(binarySearch(a, 10));
		int big = 40000;
		int small = 200;
		System.out.println("大循环数--->"+big);
		System.out.println("小循环数--->"+small);
		
		long start = System.currentTimeMillis();
		for(int i=0;i<big;i++){
			for(int j=0;j<small;j++){
//				Thread.sleep(1);
				System.out.println(1);
			}
		}
		System.out.println("大循环套小循环--->"+(System.currentTimeMillis()-start));
		
//		long start1 = System.currentTimeMillis();
//		for(int i=0;i<small;i++){
//			for(int j=0;j<big;j++){
////				Thread.sleep(2);
//				System.out.println(2);
//			}
//		}
//		System.out.println("小循环套大循环--->"+(System.currentTimeMillis()-start1));
	}

	//???�?
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
	//�??????��??
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
	
	//�???????�?
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
