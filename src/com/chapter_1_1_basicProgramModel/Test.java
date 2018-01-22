package com.chapter_1_1_basicProgramModel;

import edu.princeton.cs.algs4.StdRandom;

public class Test {
	
	public static void main(String[] args) {
		double[] a = {0.1,0.3,0.3,0.3};
		int result = StdRandom.discrete(a);
		System.out.println(result);
	}
}
