package fr.ibformation.exosupplement.mopion;

import java.util.Scanner;

public class TheGame {
	Player player1;
	Player player2;
	
	Matrix grid;
	Scanner sc = new Scanner(System.in);
	
	
	public TheGame() {
		this.player1 = new Player();
		this.player2 = new Player();
		this.grid = new Matrix();
	}

	public TheGame(Player player1, Player player2, Matrix grid) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.grid = grid;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Matrix getGride() {
		return grid;
	}

	public void setGride(Matrix gride) {
		this.grid = gride;
	}
	
	
	
	// appel joueur 1 pour commancer 
	public void startPlaying() {
		
		// definition joueurs , prenoms et code caractere 
		System.out.println("Joueur 1, entrer votre prenom ");
		this.player1.setName(sc.nextLine());
		this.player1.setPlayingCharacter('X');
		System.out.println("ton caractere est " + this.player1.getPlayingCharacter());
		
		System.out.println("Joueur 2, entrer votre prenom ");
		this.player2.setName(sc.nextLine());
		this.player2.setPlayingCharacter('O');
		System.out.println("ton caractere est " + this.player2.getPlayingCharacter());
		
		boolean isOver = false;
		while ( player1.countingPlayTimes <= 5 &&  !isOver ) {
			// demander au joueur 1 de faire un choix 
			playingRound( player1 ); 
			System.out.println(player1.getName() + " numero tour du jeu = " + player1.countingPlayTimes);
			
			if ( isVictory(player1) ) {
				isOver = isVictory(player1);	
				System.out.println(player1.getName() +" a gange le match");
			}else if (player2.getCountingPlayTimes() < 4) {
				// demanfer au joueur 2 de faire un choix 
				playingRound( player2 );
				System.out.println(player2.getName() + " numero tour du jeu = " + player2.countingPlayTimes);
				if ( isVictory(player2) ) {
					isOver = isVictory(player2);	
					System.out.println(player2.getName() +" a gange le match");
				}
			}
		}
		// si il sont valide finir le jeu 
		// sinon verifier pour joueur 2 
		// afficher egalite dans le cas echeant 
		
		
		// TODO IL RESTE cas egalite é 
		
	}
	
	/**
	 * a function that let one single player to choose the row and the column of the cell he want 
	 * inside this function call another functions to verifie 
	 * first that his input is correct (not under or over the size of matrix)
	 * second that the cell is empty
	 * @param p player 
	 */
	public void playingRound(Player p ) {
		int row, column ;
		
		System.out.println(grid.toString());
		
		 do {
			 // choix ligne et colonne et verification si case est vide
			System.out.println(p.getName() + ", tu dois choisir la ligne ");
			row = inputPlayerWithVerification();
			System.out.println(p.getName() + ", tu dois choisir la colonne  ");
			column =inputPlayerWithVerification();
			if ( grid.getMatrix()[row-1][column-1] != '\u0000' ) {
				System.out.println(" Veuillez remplir une case vide !!! ");
			}
		}while( grid.getMatrix()[row-1][column-1] != '\u0000');
		
		
		// modifier la matrice 
		setOneCell(row, column, p);
		
	}
	
	/**
	 * modify the cell choosed by the player
	 * @param row between 1 and 3
	 * @param column between 1 and 3
	 * @param p the player 
	 * @return
	 */
	public char[][] setOneCell(int row , int column, Player p){
		// verify if the cell is not empty, if yes display a message and re call the fonction till it's empty
		
		grid.getMatrix()[row-1][column-1]=p.getPlayingCharacter();
		p.setCountingPlayTimes(p.getCountingPlayTimes()+1);
		// TODO JE PENSE CountingPlayTimes N'EST PAS UTILE APRES CA 
		grid.setCountFullCell(grid.getCountFullCell() + 1);
		return grid.getMatrix();
	}
	
	/**
	 *  incite the user to put a correct information 
	 * @return an integer between 1 and 3 
	 */
	public int inputPlayerWithVerification() {
		int returnedValue;
		do {
			System.out.println("enter 1, 2 ou 3 ");
			returnedValue = sc.nextInt();
		}while( returnedValue < 1 || returnedValue > 3 );
		
		return returnedValue;
	}
	
	public boolean isVictory(Player p) {
		// affectation du caratere et du tableau dans des variables a nom court pour simplifier la lisibilite 
		char c = p.getPlayingCharacter();
		char[][] mx = grid.getMatrix();

		boolean isVictory = false;
		
		// les comdition de victoire :
		// 1- les 3 lignes remplis par le meme caractere 
		if (mx[0][0] == c && mx[0][1] == c && mx[0][2] == c ) {
			
			return isVictory = true;
		}
		if (mx[1][0] == c && mx[1][1] == c && mx[1][2] == c ) {
			return isVictory = true;
		}
		if (mx[2][0] == c && mx[2][1] == c && mx[2][2] == c ) {
			return isVictory = true;
		}
		
		
		// 2- les 3 colonnes remplis par le meme caractere 
		if ( mx[0][0] == c && mx[1][0] == c && mx[2][0] == c ) {
			
			return isVictory = true;
		}
		if (mx[0][1] == c && mx[1][1] == c && mx[2][1] == c  ) {
			return isVictory = true;
		}
		if ( mx[0][2] == c && mx[1][2] == c && mx[2][2] == c  ) {
			return isVictory = true;
		}
		// 3- les 2 diagonales rempli par le meme caractere 
		if ( mx[0][0] == c && mx[1][1] == c && mx[2][2] == c  ) {
			return isVictory = true;
		}
		if ( mx[0][2] == c && mx[1][1] == c && mx[2][0] == c  ) {
			return isVictory = true;
		}
		
		
		return isVictory;
	}
	
	

}




