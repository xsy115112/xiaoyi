package com.sogou.xiaoyi.math;

public class MySqrt {
	/**
	 * 返回平方根,判断如果正数正好是平方根就返回,否则返回小数的
	 * @param x
	 * @param mid
	 * @return
	 */
	private double getSquare(double x, double mid) {
	    long a = Math.round(mid);
	    if (a * a == x) {
	        return a;
	    } else {
	        return mid;
	    }
	}
	
	/**
	 * 二分查找求平方根
	 * @param num
	 * @return
	 */
	public double sqrtBinary(double num, double deviation) {
	    if (num == 0 || num == 1) {
	        return num;
	    } else {
	        double start = 0;
	        double end = num;
	        double mid;
	        while (true) {
	            mid = (start + end) / 2;
	            if (mid * mid == num || Math.abs(mid * mid - num) <= deviation) {
	                return getSquare(num, mid);
	            } else if (mid < num / mid) {
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new MySqrt().sqrtBinary(2, 0.001));
	}
	
}

