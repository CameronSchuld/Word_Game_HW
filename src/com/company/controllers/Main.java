package com.company.controllers;

import com.company.models.WordList;
import com.company.views.CmdLineView;

public class Main {

    public static String[] letters;
    public static boolean[] correctLetters = new boolean[20];
    public static int numLetters = 0;
    public static int numGuesses;
    public static boolean win = false;
    public static boolean rightGuess = false;
    public static String theGuess;
    public static String[] hints;
    public static  CmdLineView view;

    public static void main(String[] args) {

        numGuesses = 6;

        GetWord getWord = new GetWord();
        String theWord = getWord.getTheWord();

        WordList word = new WordList(theWord);

        //WordList word = new WordList(getWord.getTheWord());

        letters = calculateLetters(word.getTheWord());

        view = new CmdLineView(letters);
        view.startGame();
        view.cheat(word.getTheWord());

        while(numGuesses > 0 && win == false){
            rightGuess = false;
            hints = guess();
            if(rightGuess == false)
            {
                numGuesses--;
            }
            view.displayHints(letters, numGuesses, correctLetters);

            int numLetters = 0;
            for(int i = 0, j = 1; i < letters.length; i++)
            {
                if(correctLetters[i])
                    numLetters++;
            }

            if(numLetters == letters.length)
                win = true;


            //display
            //System.out.println(hints);
        }
        if(win)
            System.out.println("Congratulations! You won!");
        else
        {
            System.out.print("You Lost :(\nthe word was ");
            for(int i = 0; i < letters.length; i++)
                System.out.print(letters[i]);
        }




    }

    private static String[] calculateLetters(String theWord){
        String[] letters = theWord.split("");
        numLetters = letters.length;
        return letters;
    }

    private static String[] guess(){

        theGuess = view.makeAGuess();

        String msg = "";

        String[] hints = new String[letters.length];

        for(int i = 0; i < letters.length; i++){
            if(letters[i].equals(theGuess)){
                rightGuess = true;
                correctLetters[i] = true;
            }
            else {
                hints[i] = "_";
            }
        }

        return hints;
    }
}