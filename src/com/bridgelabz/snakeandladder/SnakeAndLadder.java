package com.bridgelabz.snakeandladder;


public class SnakeAndLadder {
	
	private static final int NO_PLAY = 0;
	private static final int LADDER = 1;
	private static final int SNAKE = 2;
	private static final int MAX_POSITION = 100;
	private static final int MIN_POSITION = 0;
	
	public static int positionOfPlayerA = 0;
	public static int positionOfPlayerB = 0;
	
	public static int getRandomInteger(int maximum, int minimum){ 
		return ((int) (Math.random()*(maximum - minimum))) + minimum; 
	}
	
	public static int turnOfPlayerA() {
		System.out.println("Player A is Rolling Dice");
		int dice = getRandomInteger(7,1);
		System.out.println("dice for A : "+dice);
		
		
		int checkPlay = (int) Math.floor(Math.random()*10)%3;
		System.out.println("checkplay for A : "+checkPlay);
		
		switch(checkPlay) {
			case NO_PLAY: 
				break;
				
			case LADDER: 
				positionOfPlayerA += dice;
				if(positionOfPlayerA > MAX_POSITION) {
					positionOfPlayerA = positionOfPlayerA-dice;
				}
				if(positionOfPlayerA == MAX_POSITION) {
					return positionOfPlayerA;
				}
				turnOfPlayerA();
				break;
			
			case SNAKE: 
				positionOfPlayerA -= dice;
				if(positionOfPlayerA < MIN_POSITION ) {
					positionOfPlayerA = 0;
				}
				break;
		}
//		System.out.println("Position of A : "+ positionA);
		return positionOfPlayerA;
	}
	
	public static int turnOfPlayerB() {
		System.out.println("Player B is Rolling Dice");
		int dice = getRandomInteger(7,1);
		System.out.println("dice for B : "+dice);
		
		
		int checkPlay = (int) Math.floor(Math.random()*10)%3;
		System.out.println("checkplay for B : "+checkPlay);
		
		switch(checkPlay) {
			case NO_PLAY: 
				break;
				
			case LADDER: 
				positionOfPlayerB += dice;
				if(positionOfPlayerB > MAX_POSITION) {
					positionOfPlayerB = positionOfPlayerB-dice;
				}
				if(positionOfPlayerB == MAX_POSITION) {
//					System.out.println("Position of B : "+ positionB);
					return positionOfPlayerB;
				}
				turnOfPlayerB();
				break;
			
			case SNAKE: 
				positionOfPlayerB -= dice;
				if(positionOfPlayerB < MIN_POSITION ) {
					positionOfPlayerB = 0;
				}
				break;
		}
//		System.out.println("Position of B : "+ positionB);
		return positionOfPlayerB;
	}
	
	public static void main(String[] args) {
		
		System.out.println("---------- Welcome to the game of SNAKES AND LADDERS!! ----------");
		
		int positionOfA = 0, positionOfB = 0;
		while(positionOfA < MAX_POSITION || positionOfB < MAX_POSITION) {
			
			positionOfA = turnOfPlayerA();
			if(positionOfA == MAX_POSITION) {
				System.out.println("Position of A : "+ positionOfA);
				System.out.println("Position of B : "+ positionOfB);
				System.out.println("--------PLAYER A WON !!-------");
				System.exit(0);
			}
			
			positionOfB = turnOfPlayerB();
			if(positionOfB == MAX_POSITION) {
				System.out.println("Position of A : "+ positionOfA);
				System.out.println("Position of B : "+ positionOfB);
				System.out.println("--------PLAYER B WON !!--------");
				System.exit(0);
				
			}
			
			
		}	
		
		
	}

}
