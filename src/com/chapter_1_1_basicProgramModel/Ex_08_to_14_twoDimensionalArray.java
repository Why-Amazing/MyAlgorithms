package com.chapter_1_1_basicProgramModel;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.algs4.StdOut;

public class Ex_08_to_14_twoDimensionalArray {

	/*书中给出的答案,很简洁
	 * 1.1.9编写一段代码，将一个正整数 N 用二进制表示并转换为一个 String 类型的值 s。
	 */
	@Test
	public void Ex_09() {
		String str = "";
		int N = 5;
		for (int i = N; i > 0; i /=2) {
			str += i%2;
		}
		StdOut.print(str);
	}
	
	//简述上有效率更高的代码,
	//参考Integer源码
	@Test
	public void Ex_09_jianShu(){
		String str = "";
		int N = 5;
		for (int i = 31; i >= 0; i--) {
			str += (N >>> i & 1);
		}
		StdOut.print(str);
	}

	/*
	 * 1.1.11 编写一段代码，打印出一个二维布尔数组的内容。其中，使用 * 表示真，空格表示假。打印出行号和列号。
	 */
	@Test
	public void Ex_11(){
		boolean[][] arr = {{true,false,true},{false,false,true},{true,false,true}};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j])
					System.out.println(String.format("%d %d *", i+1,j+1));
				else
					System.out.println(String.format("%d %d /", i+1,j+1));
			}
		}
	}
	
	/*
	 * 1.1.12 以下代码段会打印出什么结果?
	 */
	@Test
	public void Ex_12(){
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = 9 -i;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[arr[i]];
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/*
	 * 1.1.13 编写一段代码，打印出一个 M 行 N 列的二维数组的转置(交换行和列)。
	 */
	@Test
	public void Ex_13(){
		int[][] arr = {{1,2,3},{4,5,6}};
		int[][] temp = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[i][j] = arr[j][i];
				System.out.print(temp[i][j] + " ");
				if(j == arr.length-1)
					System.out.print("\n");
			}
		}
	}
	
	/*
	 * 1.1.14 编写一个静态方法 lg()，接受一个整型参数 N，返回不大于 log2N 的最大整数。不要使用 Math 库。
	 */
	@Test
	public void Ex_14(){
		int N = 4;
		int count = 0;
		for (int i = 1; i < N; i++) {
			i *= 2;
			count++;
		}
		System.out.println(count);
	}
	
	/*简书算法
	 * private static int lg(int N) {  
        int product = 1;  
        int x = -1;  
        while (product <= N) //*，把等于的情况也纳入进来，从而避免了在如23>5这种情况的自增导致输出结果为3的情况  
        {  
            product *= 2;  
            x++;  
        }  
        return x;  
    }  
      
    public static void main(String args[]) {  
        int N = 100;
        System.out.print(lg(N));  
    }*/

	
}
