package br.com.costumer.test;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ScannerExample {
	
	public static void readFromString(String inputString) {
		Scanner scanner = new Scanner(inputString);
		
		while(scanner.hasNext())
			
			System.out.println(getFirstNonRepeatedChar(scanner.next()));
		
		scanner.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScannerExample.readFromString("aAbBABac");
	}
	
	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}
}
