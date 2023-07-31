package com.prowings.io;

public class Demo {

	public static void main(String[] args) {
		String s1="hello";
		String s2=new String("hello");
		String s3="hello";
		
		System.out.println(s1==s2);
		String s4=s2.intern();
		System.out.println(s1==s4);
		
		System.out.println(s3 == s2);
		
//		
	}
}
