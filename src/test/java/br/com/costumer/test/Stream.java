package br.com.costumer.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Stream {
	
	public static void read(String inputString) {
		Scanner scanner = new Scanner(inputString);
		
		while(scanner.hasNext())
			System.out.println(primeiroCaractereSemRepeticao(scanner.next()));
		scanner.close();
	}
	
	public static void main(String[] args) {
		Stream.read("aAbBABac");
	}
	
	public static char primeiroCaractereSemRepeticao(String str) {
		Map<Character, Integer> maps = new LinkedHashMap<>(str.length());
		for (char c : str.toCharArray()) {
			maps.put(c, maps.containsKey(c) ? maps.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : maps.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("Não encontrou caracteres que não se repetem");
	}
}
