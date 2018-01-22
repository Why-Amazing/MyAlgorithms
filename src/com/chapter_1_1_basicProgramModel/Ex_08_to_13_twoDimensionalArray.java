package com.chapter_1_1_basicProgramModel;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.algs4.StdOut;

public class Ex_08_to_13_twoDimensionalArray {

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

}
