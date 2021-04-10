package fr.ibformation.exosupplement.othergames;

import java.util.Random;
import java.util.Scanner;

public class LauncherMysteryNumber {
	
	// TODO 
	// intervale sur le random 
	// externalisation du code random
	// final 
	
	public static int count = 0;
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* Ennone :
		Le systeme choisit un nombre aléatoire entre 1 et 100 (il est possible de le fixer
				dans un premier temps). Le joueur doit trouver le nombre mystere en 7 coups
				maximum ! A chaque tentative, le système indique si le nombre mystère est plus
				grand ou plus petit. A la fin du jeu, le système indique le nombre de coup en cas de
				victoire, ou un message de defaite le cas echeant
	
		 */
		Random random = new Random();
		
		int mysteryNumber = 1 + random.nextInt( 100- 1);
		int inputUser;
		
		do { 
			inputUser = inputUserAndVerification();	
			System.out.println(" vous avez encore  " + (7-count) + " chance ");
			if (inputUser == mysteryNumber) {
				System.out.println(" Bravo, vous avez gagne ");
				break;
			}else if( inputUser < mysteryNumber ) {
				System.out.println(" " + inputUser + " est inferieur au nombre mystere !!!" );
				}else {
					System.out.println(" " + inputUser + " est superieur au nombre mystere !!!" );
				} 
		}while ( count < 7);
		
		 if (count >= 7){
			System.out.println(" malheuresement vous avez perdu toutes les chances pour deviner "+mysteryNumber);
		 }
	}
	
	/**
	 * @param 
	 * @return user input that must be between 1 and 100 
	 */
	
	public static int inputUserAndVerification() {
		int inputUser; 
		
		do {
			System.out.println(" entrer un nombre  entre 1 et 100");
			inputUser = sc.nextInt();
		} while( inputUser < 1 || inputUser >100);
		
		count++;
		return inputUser;
	}

}
