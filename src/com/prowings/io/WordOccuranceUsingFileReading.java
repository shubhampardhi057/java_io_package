package com.prowings.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordOccuranceUsingFileReading {
	
	public static void main(String[] args) throws IOException {
		
		List<String> lines = Files.readAllLines(Paths.get("E:\\java_io_package\\src\\Shubham.txt"));
		
		StringBuffer sb = new StringBuffer();
		
		for(String line : lines)
		{
			sb.append(line);
			sb.append(" ");
		}
		
		String input = new String(sb);
		
		String [] words =  input.split(" ");
		
		System.out.println(Arrays.toString(words));
		
		
		HashMap<String,Integer>  wordcountmap = new HashMap<>();
		
		for(String word : words)
		{
			if(wordcountmap.containsKey(word))
			{
				wordcountmap.put(word,wordcountmap.get(word)+1);
			}
			else
			{
				wordcountmap.put(word,1);
			}
		}
		
		System.out.println(wordcountmap);
		
		
		
	}

}
