package com.epam.jmp.first.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtReader implements Reader {

	@Override
	public List<List<String>> readFile() {
		List<List<String>> labyrinth = new ArrayList<List<String>>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/resources/labyrinth.txt")))
		{
			String currentLine;
			List<String> line;
			while ((currentLine = br.readLine()) != null) {	
				line = new ArrayList<String>();
				for (String symbol: currentLine.split("")){
					line.add(symbol);
				}
				labyrinth.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 			
		return labyrinth;
	}
}
