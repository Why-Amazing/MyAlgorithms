package com.chapter_1_1_basicProgramModel;

import org.junit.Test;


//递归
public class Ex_15_to_21_recursive {
	
	/*
	 * 1.1.15 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小为 M 的数组，
	 * 其中第 i 个元素的值为整数 i 在参数数组中出现的次数。如果 a[] 中的值均在 0 到 M-1之间，返回数组中所有元素之和应该和 a.length 相等。
	 */
	@Test
	public void Ex_15_jianShu(){
		int[] arr = {2,1,4,3,2,3,1,1,6,8};
		int M = 10;
		int[] newArr = new int[M];
		int m = 0;
		int n = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == i)
					m++;
				newArr[i] = m;
			}
			m = 0;
		}
		
		for (int i = 0; i < M; i++) {
			n += newArr[i];
		}
		System.out.println(n == newArr.length);
		
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}
	
	
}
