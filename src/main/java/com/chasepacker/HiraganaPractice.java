package com.chasepacker;

import java.util.Random;
import java.util.Scanner;

import com.chasepacker.ConjugationCode.Word;

public class HiraganaPractice {


    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);


    private static final int[] regularBound = {0, 46};
    private static final int[] dakutenHandakutenBound = {46, 71};
    private static final int[] extendedBound = {71, 92};

    private static int getRandomNum(boolean includeDakutenHandakuten, boolean includeExtended)
    {

        if(includeDakutenHandakuten && includeExtended)
        {
            //All options are true
            return random.nextInt(Word.HIRAGANA.length);
        }
        else if(includeDakutenHandakuten)
        {
            //Dakuten and Handakuten are true
            return random.nextInt(dakutenHandakutenBound[1]);
        }
        else if(includeExtended)
        {
            //Extended is true
            return random.nextInt(extendedBound[1]);
        }
        else
        {
            //All options are false
            return random.nextInt(regularBound[1] - regularBound[0]);
        }

    }

    public static String[] generateKanaToRomanjiQuestion()
    {
        int randomNum = random.nextInt(Word.HIRAGANA.length);

        String[] result = {Word.HIRAGANA[randomNum], Word.ROMANJI[randomNum], "KANA"};

        return result;
    }

    public static String[] generateKanaToRomanjiQuestion(boolean includeDakutenHandakuten, boolean includeExtended)
    {
        int randomNum = getRandomNum(includeDakutenHandakuten, includeExtended);

        String[] result = {Word.HIRAGANA[randomNum], Word.ROMANJI[randomNum], "KANA"};

        return result;
    }

    public static String[] generateRomanjiToKanaQuestion()
    {
        int randomNum = random.nextInt(Word.HIRAGANA.length);

        String[] result = {Word.ROMANJI[randomNum], Word.HIRAGANA[randomNum], "ROMANJI"};

        return result;
    }

    public static String[] generateRomanjiToKanaQuestion(boolean includeDakutenHandakuten, boolean includeExtended)
    {
        int randomNum = getRandomNum(includeDakutenHandakuten, includeExtended);

        String[] result = {Word.ROMANJI[randomNum], Word.HIRAGANA[randomNum], "ROMANJI"};

        return result;
    }

    public static String[] generateQuestion(boolean[] options) 
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
                return generateKanaToRomanjiQuestion(options[2], options[3]);
            }
            else
            {
                //Romanji to Kana
                return generateRomanjiToKanaQuestion(options[2], options[3]);
            }
        }
        else if(options[0])
        {
            //Kana to Romanji
            return generateKanaToRomanjiQuestion(options[2], options[3]);
        }
        else if(options[1])
        {
            //Romanji to Kana
            return generateRomanjiToKanaQuestion(options[2], options[3]);
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
                return generateKanaToRomanjiQuestion(options[2], options[3]);
            }
            else
            {
                //Romanji to Kana
                return generateRomanjiToKanaQuestion(options[2], options[3]);
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
