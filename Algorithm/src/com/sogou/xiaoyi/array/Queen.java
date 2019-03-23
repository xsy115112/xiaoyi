package com.sogou.xiaoyi.array;

/**
 * 八皇后问题
 * 
 * @author xiaoyi
 *
 */
public class Queen {

	public static int[][] array = new int[8][8];
	public static int count = 1;// 方案数量

	public static void main(String[] args) {
		play(0);
	}
	
	/**
	 * 按照行进行遍历
	 * @param row
	 */
	public static void play(int row) {
		for (int i = 0; i < 8; i++) {
			if (isValid(row, i)) {
				//设置皇后
				array[row][i] = 1;
				// 最后一行表示完成
				if (row == 7) {
					print();
				} else {
					play(row + 1);
				}
				//返回
				array[row][i] = 0;
			}
		}
	}

	/**
	 * 检查是否可以放皇后
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean isValid(int row, int col) {
		// 上面
		for (int i = row - 1; i >= 0; i--) {
			if (array[i][col] == 1) {
				return false;
			}
		}
		// 左斜上
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (array[i][j] == 1) {
				return false;
			}
		}
		// 右斜上
		for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
			if (array[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 打印輸出
	 */
	public static void print() {
		System.out.println("方案" + count);
		count++;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (array[i][j] == 1) {
					System.out.print("Q ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
