package com.prowings.io;

import java.io.File;
import java.io.IOException;

public class TestFile {
	
	public static void main(String[] args) throws IOException {
		
		String path = "E:\\java_io_package\\src\\Shubham.txt";
		
		File file = new File(path);
		
		System.out.println(file.exists());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		
		
//		file.mkdir(); // creates new folder
		
		if(!file.exists()) 
		{
			
			file.createNewFile(); // creates new file
			
			System.out.println("created file !!");
		}
		else
		{
			
			System.out.println("already exist !!");
		}
		
		
		System.out.println("name :"+ file.getName());
		System.out.println("absolute path :"+file.getAbsolutePath());
		System.out.println("canonical path :"+file.getCanonicalPath());
		System.out.println("total space :"+file.getTotalSpace());
		
		
//		if(file.exists())
//		{
//			file.delete();
//			System.out.println("deleted file !!!");
//		}
		
		
		
		
		
		
		
		
	}

}
