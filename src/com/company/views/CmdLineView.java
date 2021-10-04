package com.company.views;

import java.util.Scanner;

public class CmdLineView {

    private String[] letters;
    private String theGuess;

    public CmdLineView(String[] letters) {
        this.letters = letters;
    }

    public void startGame() {
        System.out.println("Guess the word \n");
        for(int i = 0; i < letters.length; i++){
            System.out.print("_ ");
        }
        System.out.print("\n");
    }

    public String makeAGuess(){
        System.out.println("Guess a letter: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public void displayHints(String[] letters, int numGuess, boolean[] correctLetters){
        for(int i = 0; i < letters.length; i++)
        {
            if(correctLetters[i] == true){
                System.out.print(letters[i]);
            }
            else{
                System.out.print("_");
            }
        }
        System.out.print("\nTries Left: " + numGuess);
        System.out.print("\n");
    }

    public void cheat(String theWord){
        System.out.println("The word is " + theWord + ".");
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }
}
