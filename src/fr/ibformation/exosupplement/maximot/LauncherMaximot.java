package fr.ibformation.exosupplement.maximot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Random;
import java.util.Scanner;


public class LauncherMaximot {
	
	
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();

	private static final  String URL_FILE = "files/dictionnaire.txt";
	
	private static String wordChoosedRandomly;
	private static String wordMixedRandomly;
	private static String inputUser ;

	public static void main(String[] args) {
		
		boolean isCorrect = false ;

		// TODO chercher un mot aleatoire dans dic  a faire dans une fonction 
		try {
			wordChoosedRandomly = searchingWordRandomlyInDictionary();
			System.out.println(wordChoosedRandomly);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// melanger les lettres 
		wordMixedRandomly = Maximot.mixWordLettersRandomly(wordChoosedRandomly);
		// afficher le mot melange
		System.out.println("le mot est " + wordMixedRandomly);
		//donner la premiere lettre comme indice
		System.out.println("Pour vous aidez, voici la premiere lettre du mot " + wordChoosedRandomly.charAt(0));
		
		//demander de trouver le mot 
		System.out.println("Maintenant Essayez-vous d'en deviner !!!!");
		//  imposer la taille du mot lors de la saisie 
		
		do {
			System.out.println("Enter un mot de taille : " + wordChoosedRandomly.length());
			inputUser = scanner.nextLine();
		}while( inputUser.length() != wordChoosedRandomly.length() );
		//verifier si les lettres sont correctes
		isCorrect = lettersVerification();
		
		// verifier que le mot du joueur est dans le dictionnaire ??? deja choisi du dictionnaire
		// sauf si en veut verifier que la syntaxe du mot est correct 
		// TODO Afficher si le mot existe ou non dans la langue française 
		
		//afficher victoire, ou mauvaise lettres 
		if (isCorrect) {
			System.out.println("Bravo vous avez gagne, le mot original est: " + inputUser );
		} else {
			displayWrongLetters();
		}
		
	}

	private static String searchingWordRandomlyInDictionary() throws FileNotFoundException {
		// TODO ICI je dois aussi nepas sortir de la fonction, jusqu'à trouver un mot 
		
		
		
		// int randomIndex = random.nextInt();
		int randomIndex = 1990 ;
		
		Scanner sc, sc2;
		String word = "DEFAULT" ;
		int fileLinesNumber = 0 ;
		
		// TODO a faire la correction de l'encodage
		try {
			FileInputStream dictionary = new FileInputStream(URL_FILE);
			sc = new Scanner(dictionary);
			
			// calculer le nombre de ligne dans le fichier 
			while ( sc.hasNextLine()) {
				fileLinesNumber++;
				sc.nextLine();
			}
			System.out.println("nombre de ligne du fichier " + fileLinesNumber);
			sc.close();
		// generer un index dans cet interval
		
		// chercher le mot, si il est mal encode je cherche un autre 
			sc2 = new Scanner(dictionary);
			int lineNumber = 0 ;
			while (lineNumber < 2000  && sc.hasNextLine()) {
				lineNumber++;
				sc.nextLine();
				// TODO 
			}
			word = sc.nextLine();
			
		} catch (FileNotFoundException e) {

			
			System.out.println("probleme lecture fichier dictionnaire");
			e.printStackTrace();
		} 
		return word;
	}

	private static void displayWrongLetters() {

		System.out.println("Voici les lettres qui sont pas dans le correct ordre ");
		for( int i = 0 ; i < wordChoosedRandomly.length() ; i++) {
			
			if( inputUser.toLowerCase().charAt(i) != wordChoosedRandomly.toLowerCase().charAt(i) ) {
				System.err.print(inputUser.charAt(i) + " ");
			}else {
				System.out.print(inputUser.charAt(i) + " ");
			}
		}
		
	}

	private static boolean lettersVerification() {

		if ( inputUser.equalsIgnoreCase(wordChoosedRandomly)) {
			return true;
		} else {
			return false;
		}
		
	}

}
