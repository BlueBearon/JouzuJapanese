package com.chasepacker;

import java.util.Random;
import java.util.Scanner;

import com.chasepacker.ConjugationCode.Word;

public class HiraganaPractice {


    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);



    public String[] generateKanaToRomanjiQuestion()
    {
        int randomNum = random.nextInt(Word.HIRAGANA.length);

        String[] result = {Word.HIRAGANA[randomNum], Word.ROMANJI[randomNum], "KANA"};

        return result;
    }

    public String[] generateRomanjiToKanaQuestion()
    {
        int randomNum = random.nextInt(Word.ROMANJI.length);

        String[] result = {Word.ROMANJI[randomNum], Word.HIRAGANA[randomNum], "ROMANJI"};

        return result;
    }

    public String[] generateQuestion(boolean[] options) 
    {
        //Options = {Boolean Kana to Romanji, Boolean Romanji to Kana}

        if(options[0] && options[1])
        {
            //Both options are true
            
            //Generate random number between 0 and 1
            int randomNum = random.nextInt(2);

            if(randomNum == 0)
            {
                //Kana to Romanji
                return generateKanaToRomanjiQuestion();
            }
            else
            {
                //Romanji to Kana
                return generateRomanjiToKanaQuestion();
            }
        }
        else if(options[0])
        {
            //Kana to Romanji
            return generateKanaToRomanjiQuestion();
        }
        else if(options[1])
        {
            //Romanji to Kana
            return generateRomanjiToKanaQuestion();
        }
        else
        {
            //Both options are false
            System.out.println("Both options are false");

            //Just generate a random question
            int randomNum = random.nextInt(2);

            if(randomNum == 0)
            {
                //Kana to Romanji
                return generateKanaToRomanjiQuestion();
            }
            else
            {
                //Romanji to Kana
                return generateRomanjiToKanaQuestion();
            }
        }

    }

     /**
     * !For Text Version!
     * @param question
     * @return
     */
    private String askQuestion(String question)
    {
        System.out.println(question);

        String answer = scanner.nextLine();

        answer = answer.toLowerCase();

        if(answer.equals("はい"))
        {
            answer = "y";
        }
        else if(answer.equals("いいえ"))
        {
            answer = "n";
        }

        if(!answer.equals("y") && !answer.equals("n"))
        {
            System.out.println("Error: Invalid input. Please enter y or n or はい or いいえ");
            return askQuestion(question);
        }

        return answer;
    }

    private boolean[] getOptions()
    {
        boolean[] options = new boolean[2];

        String kanaToRomanji = askQuestion("Do you want to practice Kana to Romanji? (y/n)");

        if(kanaToRomanji.equals("y"))
        {
            options[0] = true;
        }
        else
        {
            options[0] = false;
        }

        String romanjiToKana = askQuestion("Do you want to practice Romanji to Kana? (y/n)");

        if(romanjiToKana.equals("y"))
        {
            options[1] = true;
        }
        else
        {
            options[1] = false;
        }

        return options;

    }

    public void StartPractice()
    {
        boolean endPractice = false;

        boolean[] options = getOptions();

        while(!endPractice)
        {
            String[] question = generateQuestion(options);

            if (question[2].equals("KANA"))
            {
                System.out.println("What is the Romanji for " + question[0] + "?");
            }
            else
            {
                System.out.println("What is the Kana for " + question[0] + "?");
            }

            String answer = scanner.nextLine();

            if(answer.equals(question[1]))
            {
                System.out.println("Correct!");
            }
            else
            {
                System.out.println("Incorrect! The correct answer is " + question[1]);
            }

            String endPracticeString = askQuestion("Do you want to end practice? (y/n)");

            if(endPracticeString.equals("y"))
            {
                endPractice = true;
            }
        }
    }

    public static void main(String[] args) {
        HiraganaPractice practice = new HiraganaPractice();

        practice.StartPractice();
    }
    
}
