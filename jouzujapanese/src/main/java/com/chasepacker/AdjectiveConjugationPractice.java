package com.chasepacker;

import com.chasepacker.ConjugationCode.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.random.RandomGenerator;


public class AdjectiveConjugationPractice {

    private static Scanner scanner = new Scanner(System.in);
    private static RandomGenerator gen = RandomGenerator.getDefault();

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

        if (answer.equals("はい") || answer.equals("yes") || answer.equals("y") || answer.equals(""))
        {
            answer = "y";
        }
        else if (answer.equals("いいえ") || answer.equals("no") || answer.equals("n"))
        {
            answer = "n";
        }

        if(!answer.equals("y") && !answer.equals("n"))
        {
            System.out.println("Error: Invalid input. Please enter y or n");
            return askQuestion(question);
        }

        return answer;
    }

    /**
     * !Keep for GUI Version!
     * Returns a random number between 0 and max
     * @param max
     * @return
     */
    private static int generateRandomNum(int max)
    {
        return gen.nextInt(max);
    }

    /**
     * !Keep for GUI Version!
     * Verifies that the user has selected at least one option for each category
     * @param options
     * @return
     */
    private boolean verifyValidOptions(boolean[] options)
    {
        
        if(!options[0] && !options[1])
        {
            System.out.println("Error: You must select at least one type of adjective");
            return false;
        }

        if(!options[2] && !options[3])
        {
            System.out.println("Error: You must select at least one formality");
            return false;
        }

        if(!options[4] && !options[5])
        {
            System.out.println("Error: You must select at least one tense");
            return false;
        }

        if(!options[6] && !options[7])
        {
            System.out.println("Error: You must select at least one polarity");
            return false;
        }

        return true;
    }

    /**
     * !For Text Version ONLY!
     * Returns an array of booleans representing the options selected by the user
     * @return array of booleans representing the options selected by the user
     */
    private boolean[] getOptions()
    {
        boolean includeIAdjectives = false;
        boolean includeNaAdjectives = false;

        if(askQuestion("Would you like to include i-adjectives? (y/n)").equals("y"))
        {
            includeIAdjectives = true;
        }

        if(askQuestion("Would you like to include na-adjectives? (y/n)").equals("y"))
        {
            includeNaAdjectives = true;
        }

        boolean includeCasual = false;
        boolean includeFormal = false;

        if(askQuestion("Would you like to include casual conjugations? (y/n)").equals("y"))
        {
            includeCasual = true;
        }

        if(askQuestion("Would you like to include formal conjugations? (y/n)").equals("y"))
        {
            includeFormal = true;
        }

        boolean includePresent = false;
        boolean includePast = false;

        if(askQuestion("Would you like to include present tense? (y/n)").equals("y"))
        {
            includePresent = true;
        }

        if(askQuestion("Would you like to include past tense? (y/n)").equals("y"))
        {
            includePast = true;
        }

        boolean includeAffirmative = false;
        boolean includeNegative = false;

        if(askQuestion("Would you like to include affirmative conjugations? (y/n)").equals("y"))
        {
            includeAffirmative = true;
        }

        if(askQuestion("Would you like to include negative conjugations? (y/n)").equals("y"))
        {
            includeNegative = true;
        }

        boolean[] options = {includeIAdjectives, includeNaAdjectives, includeCasual, includeFormal, includePresent, includePast, includeAffirmative, includeNegative};

        if(!verifyValidOptions(options))
        {
            return getOptions();
        }

        return options;
    }

    /**
     * !Keep for GUI Version!
     * Returns a random index of the array of booleans that is true.
     * Used to select to make a selection between valid options of the user
     * @param options
     * @return
     */
    private static int selectRandomBoolean(boolean[] options)
    {
        
        //Create an arraylist of the valid options
        ArrayList<Integer> validOptions = new ArrayList<Integer>();

        //Add the valid options to the arraylist
        for(int i = 0; i < options.length; i++)
        {
            if(options[i])//If the option is true, add it to the arraylist
            {
                validOptions.add(i);
            }
        }

        //Select a random index from the arraylist
        int randomIndex = generateRandomNum(validOptions.size());

        //Return the value at the random index
        return validOptions.get(randomIndex);
        
    }

    /**
     * !Keep for GUI Version!
     * Returns a random adjective based on the options selected by the user
     * @return random adjective based on the options selected by the user
     */
    private static Adjective selectAdjective(boolean iAdjectives, boolean naAdjectives)
    {
        boolean[] options = {iAdjectives, naAdjectives};

        int randomIndex = selectRandomBoolean(options);

        if (randomIndex == 0)
        {
            return XMLParser.getRandomIAdjective();
        }
        else
        {
            return XMLParser.getRandomNaAdjective();
        }
    }

    /**
     * !Keep for GUI Version!
     * Returns a random formality based on the options selected by the user
     * @return random formality based on the options selected by the user
     */
    private static String selectFormality(boolean casual, boolean formal)
    {
        boolean[] options = new boolean[]{casual, formal};

        int randomIndex = selectRandomBoolean(options);

        switch(randomIndex)
        {
            case 0:
                return "Casual ";
            case 1:
                return "Formal ";
            default:
                System.out.println("Error: selectFormality() returned invalid index");
                return "Casual ";
        }
    }

    /**
     * !Keep for GUI Version!
     * Returns a random tense based on the options selected by the user
     * @return random tense based on the options selected by the user
     */
    private static String selectPolarity(boolean affirmative, boolean negative)
    {
        boolean[] options = new boolean[]{affirmative, negative};

        int randomIndex = selectRandomBoolean(options);

        switch(randomIndex)
        {
            case 0:
                return "Positive ";
            case 1:
                return "Negative ";
            default:
                System.out.println("Error: selectPolarity() returned invalid index");
                return "Positive ";
        }
    }

    /**
     * !Keep for GUI Version!
     * Returns a random tense based on the options selected by the user
     * @return random tense based on the options selected by the user
     */
    private static String selectTense(boolean present, boolean past)
    {
        boolean[] options = new boolean[]{present, past};

        int randomIndex = selectRandomBoolean(options);

        switch(randomIndex)
        {
            case 0:
                return "Present";
            case 1:
                return "Past";
            default:
                System.out.println("Error: selectTense() returned invalid index");
                return "Present";
        }
    }

    /**
     * !Keep for GUI Version!
     * Returns a random question based on the options selected by the user
     * @return random question based on the options selected by the user
     */
    public static String[] generateQuestion(boolean[] options)
    {
        String[] result = {"Answer", "Hiragana", "conjugation"};

        Adjective adjective = selectAdjective(options[0], options[1]);

        String formality = selectFormality(options[2], options[3]);

        String polarity = selectPolarity(options[6], options[7]);

        String tense = selectTense(options[4], options[5]);

        ConjugationType conjugation = ConjugationType.fromString(formality + polarity + tense);

        result[0] = adjective.getConjugation(conjugation);

        result[1] = adjective.getHiragana();

        result[2] = conjugation.toString();
        
        return result;
    }

    public void startPractice()
    {
        boolean endPractice = false;

        XMLParser.scan();

        boolean[] options = getOptions();

        while(!endPractice)
        {
            String[] question = generateQuestion(options);

            String answer = askQuestion("What is the " + question[2] + " of " + question[1] + "?");

            if(answer.equals(question[0]))
            {
                System.out.println("Correct!");
            }
            else
            {
                System.out.println("Incorrect. The correct answer is " + question[0]);
            }

            if(askQuestion("Would you like to continue? (y/n)").equals("n"))
            {
                endPractice = true;
            }
        }      
    }

    public static void main(String[] args)
    {
        AdjectiveConjugationPractice practice = new AdjectiveConjugationPractice();

        practice.startPractice();
    }

}
