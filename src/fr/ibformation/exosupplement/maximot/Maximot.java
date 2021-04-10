package fr.ibformation.exosupplement.maximot;

import java.util.Random;

/**
 * Class for Maximot game
 * @author erwan
 *
 */
public class Maximot {
	
	private static Random randomObject = new Random();
	private static String[] dictionary;
	private static String wordChoosed;
	private static String wordMixRandomly;

	public static void main(String[] args) {
		// STEP 1 : Create dictionary
		buildDictionary();
		System.out.println(dictionary[0] + " " + dictionary[1] + " " + dictionary[2]);

		// Step 2 : Choose randomly a word into the dictionary
		wordChoosed = chooseWordRandomly(dictionary);
		System.out.println(wordChoosed);
		
		// STEP 3 : Mix the word choosed
		wordMixRandomly = mixWordLettersRandomly(wordChoosed);
		System.out.println(wordMixRandomly);
	}
	
	/**
	 * 
	 */
	private static void buildDictionary() {
		dictionary = new String[] {"FRAISE","BANANE","ORANGE"};
	}
	
	/**
	 * 
	 * @param dictionary
	 * @return
	 */
	private static String chooseWordRandomly(String[] dictionary) {
		int randomIndex = randomObject.nextInt(dictionary.length);
		return dictionary[randomIndex];
	}

	/**
	 * 
	 * @param wordToMix
	 * @return
	 */
	public static String mixWordLettersRandomly(String wordToMix) {
		char[] wordCharFormat = wordToMix.toCharArray();
		int numberLettersFromWord = wordCharFormat.length;
		
		// For each loop interchange letter
		// Number of loop : (number of letters in the word) * 4 = number of loop 
		// Exemple: LOOP 1 : CUILLERE : [C]UIL[L]ERE --> LUILCERE
		//          LOOP 2 : LUILCERE : LUI[L]C[E]RE --> LUIECLRE
		//          LOOP 3 : LUIECLRE : LUIE[[C]]LRE --> LUIECLRE (Same Letter randomly selected) 
		for (int i = 0; i < numberLettersFromWord * 4; i++) {
			int p1 = randomObject.nextInt(numberLettersFromWord);
			int p2 = randomObject.nextInt(numberLettersFromWord);
			if (p1 != p2) {
				char temp = wordCharFormat[p1];
				wordCharFormat[p1] = wordCharFormat[p2];
				wordCharFormat[p2] = temp;
			}
			
		}
		
		return new String(wordCharFormat);
	}
	
}
