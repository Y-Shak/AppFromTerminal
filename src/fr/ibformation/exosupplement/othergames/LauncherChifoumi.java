package fr.ibformation.exosupplement.othergames;

import java.util.Random;
import java.util.Scanner;

public class LauncherChifoumi {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/* Ennonce:
		 * Le jeu de Chifoumi s'appelle aussi Caillou-Ciseaux-Papier. Le joueur va
		 * choisir soit un caillou, soit des ciseaux, soit un papier à l'aide d'un menu.
		 * Le joueur affronte le système. On donne un nombre de points à atteindre au
		 * début du programme (3 ou 5 par exemple) et le premier joueur qui a atteint ce
		 * nombre de points a gagné.
		 */
		
		// variables
		char returnedResult = 'x';
		int systemScore = 0, userScore = 0;

		// affichage choix du joueur et saisie
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("------------------------------CHIFOUMI---------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("choisir soit un caillou, soit des ciseaux, soit un papier");

		// qui est le gagnant ?

		while (systemScore < 3 && userScore < 3) {
			returnedResult = traitementGame();
			if (returnedResult == 's') {
				systemScore++;

			} else if (returnedResult == 'u') {
				userScore++;
			}
			System.out.println("ton score = " + userScore + " systeme Score = " + systemScore);
		}

		if (systemScore == 3) {
			System.out.println(" Vous avez perdu contre le systeme ");
		} else {
			System.out.println(" Vous avez gagne, bravo ");
		}

	}

	public static char traitementGame() {
		char oneSingleResultPlay = 'x';
		int userInput;
		int sysChoice;
		Random r = new Random();
		// generate system choice between 1 and 3 
		sysChoice = r.nextInt(3 - 1) + 1;

		// read user choice 
		System.out.println("1- un caillou \t 2- des ciseaux \t 3- soit un papier");
		userInput = sc.nextInt();

		// determinate who win a single round 
		switch (sysChoice) {
			case 1: {
				switch (userInput) {
					case 1: {
						oneSingleResultPlay = 'e';
						break;
					}
					case 2: {
						oneSingleResultPlay = 's';
						break;
					}
					case 3: {
						oneSingleResultPlay = 'u';
						break;
					}
				}
				break;
			}
			case 2: {
				switch (userInput) {
					case 1: {
						oneSingleResultPlay = 'u';
						break;
					}
					case 2: {
						oneSingleResultPlay = 'e';
						break;
					}
					case 3: {
						oneSingleResultPlay = 's';
						break;
					}
				}
				break;
			}
			case 3: {
				switch (userInput) {
					case 1: {
						oneSingleResultPlay = 's';
						break;
					}
					case 2: {
						oneSingleResultPlay = 'u';
						break;
					}
					case 3: {
						oneSingleResultPlay = 'e';
						break;
					}
				}
				break;
			}
			default:
				// recursivite en cas de saisie eronnee de la part de l'utilisateur 
				return traitementGame();
		}

		return oneSingleResultPlay;
	}

}
