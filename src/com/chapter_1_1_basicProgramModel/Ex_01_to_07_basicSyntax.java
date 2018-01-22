package com.chapter_1_1_basicProgramModel;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.algs4.StdOut;

import java.lang.Math;

public class Ex_01_to_07_basicSyntax {
	@Test
	public void Ex_01(){
		System.out.println(2.0*Math.E - 6*100000000.1);
	}
	
	//斐波那契数列
	@Test
	public void Ex_06(){
		int f = 0;
		int g = 1;
		for (int i = 0; i < 15; i++) {
			StdOut.println(f);
			f = f + g;
			g = f - g;
		}
	}
	
	
	@Test
	public void Ex_07_a(){
		double t =9.0;
		while (Math.abs(t - 9.0/t) > .001) {
			t = (9.0/t + t)/2.0; 
		}
		StdOut.printf("%.5f\n", t);
	}
	
	@Test
	public void Ex_07_b(){
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		StdOut.print(sum);
	}
	
	@Test
	public void Ex_07_c(){
		int sum = 0;
		for (int i = 1; i < 50; i *= 2) {
			for (int j = 0; j < 50; j++) {
				sum++;
			}
		}
		StdOut.print(sum);
	}
	
}
