package fr.ibformation.exosupplement.mopion;

public class Player {
	String name;
	char playingCharacter ;
	int countingPlayTimes;
	
	
	public Player() {
		this.countingPlayTimes=0;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public char getPlayingCharacter() {
		return playingCharacter;
	}


	public void setPlayingCharacter(char playingCharacter) {
		this.playingCharacter = playingCharacter;
	}


	public int getCountingPlayTimes() {
		return countingPlayTimes;
	}


	public void setCountingPlayTimes(int countingPlayTimes) {
		this.countingPlayTimes = countingPlayTimes;
	}


	
	
	
	
	
	

}
