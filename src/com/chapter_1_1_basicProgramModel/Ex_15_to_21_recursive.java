package com.chapter_1_1_basicProgramModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;


//递归
public class Ex_15_to_21_recursive {

	/*
	 * 1.1.15 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小为 M 的数组，
	 * 其中第 i 个元素的值为整数 i 在参数数组中出现的次数。如果 a[] 中的值均在 0 到 M-1之间，返回数组中所有元素之和应该和 a.length 相等。
	 */
	@Test
	public void Ex_15_jianShu() {
		int[] arr = {2, 1, 4, 3, 2, 3, 1, 1, 6, 8};
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

	@Test
	public void Ex_15_github() {
		int[] arr = {2, 1, 4, 3, 2, 3, 1, 1, 6, 8};
		int M = 10;
		int[] newArr = new int[M];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < M)
				newArr[arr[i]]++;
		}

		for (int i = 0; i < newArr.length; i++)
			System.out.println(newArr[i]);
	}


	public static String exR1(int n) {
		if (n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	@Test
	public void Ex_16() {
		exR1(6);
	}

	/*
	1.1.18 请看以下递归函数:
	mystery(2, 25) 和 mystery(3, 11) 的返回值是多少?给定正整数 a 和 b，
	mystery(a,b)计算的结果是什么?将代码中的 + 替换为 * 并将 return 0 改为 return 1，
	然后回答相同的问题。
	 */
	//这道题目考了一个思想，数据和操作，即第一个参数是数据，第二个参数是操作的。这在实际编程中也是一种解耦的思想
	public static int mystery(int a, int b) {
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}

}
	/*
	斐波那契数列
	计算机用这段程序在一个小时之内能够得到 F(N) 结果的最大 N 值是多少?
	开发 F(N) 的一个更好的实现，用数组保存已经计算过的值。
	 */
	class Fibonacci_A {
		public static long F(int N) {
			if (N == 0)
				return 0;
			if (N == 1)
				return 1;
			return F(N - 1) + F(N - 2);
		}

		public static void main(String[] args) {
			for (int N = 0; N < 100; N++)
				StdOut.println(N + " " + F(N));
		}
	}



/*具体能算到多少不知道，部分结果如下：
		0 0
		1 1
		2 1
		3 2
		4 3
		5 5
		6 8
		7 13
		8 21
		9 34
		10 55
		11 89
		12 144
		13 233
		14 377
		15 610
		16 987
		17 1597
		18 2584
		19 4181
		20 6765
		21 10946
		22 17711
		23 28657
		24 46368
		25 75025
		26 121393
		27 196418
		28 317811
		29 514229
		30 832040
		31 1346269
		32 2178309
		33 3524578
		34 5702887
		35 9227465
		36 14930352
		37 24157817
		38 39088169
		39 63245986
		40 102334155
		41 165580141
		42 267914296
		43 433494437
		44 701408733
		45 1134903170
		46 1836311903
		47 2971215073
		48 4807526976
		49 7778742049
		50 12586269025
//这是计算了5分钟左右能计算到第50个，越往后越慢，因为使用了递归的方式，
每次的时间都是所有之前的时间的总和
*/
	//改良版本：
	class Fibonacci_B {


		public static long F1(int N) {
			if (N == 0) return 0;
			if (N == 1) return 1;
			long f = 0;
			long g = 1;
			for (int i = 0; i < N ; i++) {
				f = f + g;
				g = f - g;
			}
			return f;
		}

		public static void main(String[] args) {
			for (int N = 0; N < 100; N++)
				System.out.println(N + " " + F1(N));
		}
	}
/**需要注意的是，long类型大小限制，后面就会出现负数
 81 37889062373143906
 82 61305790721611591
 83 99194853094755497
 84 160500643816367088
 85 259695496911122585
 86 420196140727489673
 87 679891637638612258
 88 1100087778366101931
 89 1779979416004714189
 90 2880067194370816120
 91 4660046610375530309
 92 7540113804746346429
 93 -6246583658587674878
 94 1293530146158671551
 95 -4953053512429003327
 96 -3659523366270331776
 97 -8612576878699335103
 98 6174643828739884737
 99 -2437933049959450366

 所以需要替换成其他类型比如BigInteger

 */


		/*
		1.1.20 编写一个递归的静态方法计算 ln(N!) 的值。

		分析

		背景知识

		ln是数学中的对数符号。
		数学领域自然对数用ln表示，前一个字母是小写的L（l），不是大写的i（I）。
		ln 即自然对数 ln=loge a。
		以e为底数的对数通常用于ln，而且e还是一个超越数。
		N!是N的阶乘
		对数的运算法则：两个正数的积的对数，等于同一底数的这两个数的对数的和，即

		题目中我们使用归纳法来解决问题
		令f(N)= ln(N!)
		f(1) = ln(1!) = 0
		f(2) = ln(2!) = ln(2 * 1) = ln2 + ln1
		f(3) = ln(3!) = ln(3 * 2 * 1) = ln3 + ln2 + ln1 = f2 + ln3
		f(4) = ln(4!) = ln(4 * 3 * 2 * 1) = ln4 + ln3 + ln2 + ln1 = f(3) + ln4
		f(5) = ln(5!) = ln(5 * 4 * 3 * 2 * 1) = ln5 + ln4 + ln3 + ln2 + ln1 = f(4) + ln5

		...
		f(n) = f(n-1) +lnn
		*/
class Ex_20{
	public static double logarithmic(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 0;
		return logarithmic(n - 1) + Math.log(n);
	}
}

/**
 * 1.1.21 编写一段程序，从标准输入按行读取数据，
 * 其中每行都包含一个名字和两个整数。
 * 然后用printf() 打印一张表格，
 * 每行的若干列数据包括名字、两个整数和第一个整数除以第二个整数 的结果，
 * 精确到小数点后三位。
 * 可以用这种程序将棒球球手的击球命中率或者学生的考试分数 制成表格。

 */
class Ex_21{
	public static void main(String[] args) {
		int M = 3;
		int index = 0;
		String[] strs = new String[M];
		while (index < M)
			strs[index++] = StdIn.readLine();
		for (int i = 0; i < strs.length; ++i) {
			String[] arr = strs[i].split("\\s+");
			double temp = Double.parseDouble(arr[1]) / Double.parseDouble(arr[2]);
			StdOut.printf("%-10s   %-10s   %-10s   %-13.3f\n", arr[0], arr[1], arr[2], temp);
		}
	}

}
