package com.prowings.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

public class ReadFileFromClasspathDynamically {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		String fname = "AAA.txt";
		
		String data1 = readFileUsingClassloaderGetResourceAsStream(fname);
		
		System.out.println(data1);
		
		
		String data2 = readFilesUsingClassloaderGetResource(fname);
		
		System.out.println(data2);
		
	}

	private static String readFilesUsingClassloaderGetResource(String fname) throws URISyntaxException, IOException {
		
		ReadFileFromClasspathDynamically obj = new ReadFileFromClasspathDynamically();
		
		URL url = obj.getClass().getClassLoader().getResource(fname);
		
		File file = new File(url.toURI());
		
		FileReader fr = new FileReader(file);
		
		BufferedReader  br = new BufferedReader(fr);
		
		StringBuffer readData = new StringBuffer();
		
		try {
			
			String line;
			while((line = br.readLine()) != null)
			{
				readData.append(line);
				readData.append(" ");
			}
		}
		catch (Exception e) {

			System.out.println("exception while reading file!!");
			e.printStackTrace();

		} 
		finally {
			br.close();
			fr.close();
			
		}

		
		return new String(readData);
	}

	private static String readFileUsingClassloaderGetResourceAsStream(String fname) throws IOException {
		
		ReadFileFromClasspathDynamically obj = new ReadFileFromClasspathDynamically();
		
		InputStream in = obj.getClass().getClassLoader().getResourceAsStream(fname);
		
		InputStreamReader rd = new InputStreamReader(in);
		
		BufferedReader br = new BufferedReader(rd);
		
		StringBuffer sb = new StringBuffer();
		
		String line;
		
		while((line = br.readLine()) != null)
		{
			sb.append(line);
			sb.append(" ");
			
		}
		
		return new String(sb);
	}

}
