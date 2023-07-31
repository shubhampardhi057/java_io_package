package com.prowings.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileByDifferentWays {
	
	public static void main(String[] args) throws IOException {
			
		
		System.out.println(readFilesUsingFileReader());
		
		System.out.println(readFilesUsingBufferedReader());
		
		System.out.println(readFileUsingBufferedReaderLinesMethod());

		System.out.println(readFileUsingFiles());
		
		System.out.println(readFileUsingFileInputStream());
		
	}
	
	private static String readFileUsingFileInputStream() throws IOException {
		
		File file = new File("E:\\java_io_package\\src\\Shubham.txt");
		
		FileInputStream in = new FileInputStream(file);
		
		in.read();
		
		System.out.println("File Read Successfully !!!");
		
		return null;
	}

	private static String readFileUsingFiles() throws IOException {
		
//		return Files.readString(Paths.get("E:\\java_io_package\\src\\Shubham.txt"));
		
		List<String> allLines = Files.readAllLines(Paths.get("E:\\java_io_package\\src\\Shubham.txt"));
		
		System.out.println("@ : "+allLines);
		
		StringBuffer sb = new StringBuffer();
		
		for(String line : allLines)
		{
			sb.append(line);
			sb.append(" ");
		}
		
		return new String(sb);
	
	}
	
	private static String readFileUsingBufferedReaderLinesMethod() throws FileNotFoundException {
		
		File file = new File("E:\\java_io_package\\src\\Shubham.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		return br.lines().collect(Collectors.joining());
		
		
	}
	private static String readFilesUsingBufferedReader() throws IOException {
		
		File file = new File("E:\\java_io_package\\src\\Shubham.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader bwr = new BufferedReader(fr);
		
		StringBuffer readData = new StringBuffer();
		
		try {
			
			String line;
			
//			String line = bwr.readLine();
//			String line1 = bwr.readLine();
//			String line2 = bwr.readLine();

//			System.out.println("===>>>"+line);
//			System.out.println("===>>>"+line1);
//			System.out.println("===>>>"+line2);
			
			while((line = bwr.readLine()) != null)
			{
				readData.append(line);
				readData.append(" ");
			}
		
		}
		catch (Exception e) {
			System.out.println("exception while reading file!!");
			e.printStackTrace();

		} finally {
			bwr.close();
			fr.close();
		}
		return new String(readData);
		
	}
	private static String readFilesUsingFileReader() throws IOException {
		
		File file = new File("E:\\java_io_package\\src\\Shubham.txt");
		
		FileReader frr = null;
		
		String readData = "";
		
		try {
			
			frr = new FileReader(file);
			char[] dt = new char[100];
			
			frr.read(dt);
			
			readData = new String(dt);	
			
			
		}
		catch(Exception e)
		{
			System.out.println("exception while reading !!!"+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			frr.close();
		}
		
		System.out.println("data read successfully !!!");
		return readData;
	}

}
