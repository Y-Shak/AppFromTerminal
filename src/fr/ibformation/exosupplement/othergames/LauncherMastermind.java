package fr.ibformation.exosupplement.othergames;

import java.util.Random;
import java.util.Scanner;

public class LauncherMastermind {
	// TODO a refaire aec Map ou arraylist
	public static Scanner sc = new Scanner(System.in); 

	public static void main(String[] args) {
		/* Coder un jeu de mastermind standard ou le but est de découvrir une combinaison secrète de 4 symboles */
		
		int countChances=0;
		int previousLenght;
		 
		// pour stocker les lettres , afin de le afficher vers la fin 
		char[] arrayMysteryLetters;
		
		// chaine de caratere mystere
		String mysteryLetters = randomString();
		arrayMysteryLetters = mysteryLetters.toCharArray();
		
		
		System.out.println("Les symboles sont des alphabets, on peut avoir une lettre plusieurs fois ");
		
		while ( (mysteryLetters.length() > 0 ) & ( countChances < 10 ) ) {
			previousLenght = mysteryLetters.length();
			mysteryLetters = verifyTheChoiceUserRight(mysteryLetters);
			countChances++;
			
			// verifier si il a trouve le symbole en s'appuiant sur la taille precedante du string
			// 
			if (mysteryLetters.length() < previousLenght ) {
				previousLenght = mysteryLetters.length();
				System.out.println(" letter correct  vous avez " + (10-countChances) + " chances" );
			}else {
				System.out.println(" letter incorrect "  + (10-countChances) + " chances");
			}
		}
		
		if (mysteryLetters.length() == 0) {
			System.out.println(" bravo, vouz avez gagne ");
		}else {
			System.out.println(" malheureusement, vous avez perdu" );
		}
		System.out.print("les lettres  mystere sont : " );
		for (char c : arrayMysteryLetters) {
			System.out.print(" " + c + " ");
		}
		
		
	}
	/**
	 * 
	 * @param str 
	 * @return renvoie un string soit le meme si user a entrer un char incorrect, soit le string moins la lettre correct 
	 */
	public static String verifyTheChoiceUserRight(String str) {
		System.out.println("Donner une lettre ");
		String inputUser = sc.next().substring(0, 1);
		if(str.contains(inputUser.toLowerCase())) {
			str = str.replaceFirst(inputUser, "");
		}
		return str;
	}
	
	/**
	 * 
	 * @return a a word of 4 letters randomly and a  letter can be duplicated 
	 */
	
	public static String randomString() {
		Random r = new Random();
		char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuffer str= new StringBuffer();
		for(int i = 0 ; i < 4 ; i++) {
			str=str.append(alphabets[r.nextInt(25)]);
		}
		System.out.println("le string genere " + str.toString());	
		return str.toString();
	}
	
	

}



