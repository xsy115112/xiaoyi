package com.sogou.xiaoyi;

import org.junit.Test;

public class Fibonacci {
	//递归
	public int climb(int n){
		if(1==n || 2==n){
			return n;
		}else{
			return climb(n-1)+climb(n-2);
		}
	}
	//备忘录法
	public int dfs(int n,int [] arr){
		if(arr[n] != 0){
			return arr[n];
		}else{
			arr[n] = dfs(n-1,arr)+dfs(n-2,arr);
			return arr[n];
		}
	}
	
    public int climb01(int n) {
        if(1==n || 2==n){
			return n;
		}else{
			int[] arr = new int[n+1];
			arr[1] = 1;
			arr[2] = 2;
			return dfs(n,arr);
		}
    }
    
    //动态规划法
    public int climb02(int n){
    		if(1==n || 2==n){
			return n;
		}else{
			int[] arr = new int[n+1];
			arr[1] = 1;
			arr[2] = 2;
			for(int i=3;i<=n;i++){
				arr[i] = arr[i-1]+arr[i-2];
			}
			return arr[n];
		}
    }
    //动态规划法
    public int climb03(int n){
    		if(1==n || 2==n){
			return n;
		}else{
			int a = 1;
			int b = 2;
			int temp;
			for(int i=3;i<=n;i++){
				temp = a+b;
				a = b;
				b = temp;
			}
			return b;
		}
    }
    /**
     * 通项公式法
     */
    public int fib04(int n){
	    	if(n==1||n==2){
	    		return n;
	    	}else{
	    		double sqrtFive=Math.sqrt(5);
	    		n++;
	    		double a=Math.pow((1+sqrtFive)/2, n);
	    		double b=Math.pow((1-sqrtFive)/2, n);
	    		double result=1/sqrtFive*(a-b);
	    		return (int) Math.floor(result);
	    	}
    }
    
	@Test
	public void testClimb(){
		System.out.println(climb(5));
		System.out.println(climb01(5));
	}
}
