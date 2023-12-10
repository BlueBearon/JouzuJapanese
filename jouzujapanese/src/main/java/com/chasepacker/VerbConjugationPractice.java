package com.chasepacker;

import com.chasepacker.ConjugationCode.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class VerbConjugationPractice {


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

    /**
     * !Keep for GUI Version!
     * Returns a random number between 0 and max
     * @param max
     * @return
     */
    private int generateRandomNum(int max)
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
        if(!options[0] && !options[1] && !options[2])
        {
            System.out.println("Error: You must select at least one type of verb");
            return false;
        }

        if(!options[3] && !options[4])
        {
            System.out.println("Error: You must select at least one form");
            return false;
        }

        if(!options[5] && !options[6])
        {
            System.out.println("Error: You must select at least one tense");
            return false;
        }

        if(!options[7] && !options[8])
        {
            System.out.println("Error: You must select at least one form");
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
        boolean includeRuVerbs = false;
        boolean includeUVerbs = false;
        boolean includeIrregularVerbs = false;

        if (askQuestion("Would you like to include Ru Verbs? (y/n)").equals("y"))
        {
            includeRuVerbs = true;
        }

        if (askQuestion("Would you like to include U Verbs? (y/n)").equals("y"))
        {
            includeUVerbs = true;
        }

        if (askQuestion("Would you like to include Irregular Verbs? (y/n)").equals("y"))
        {
            includeIrregularVerbs = true;
        }

        boolean includeCasualForm = false;
        boolean includeFormalForm = false;

        if (askQuestion("Would you like to include Casual Form? (y/n)").equals("y"))
        {
            includeCasualForm = true;
        }

        if (askQuestion("Would you like to include Formal Form? (y/n)").equals("y"))
        {
            includeFormalForm = true;
        }

        boolean includePresentTense = false;
        boolean includePastTense = false;

        if (askQuestion("Would you like to include Present Tense? (y/n)").equals("y"))
        {
            includePresentTense = true;
        }

        if (askQuestion("Would you like to include Past Tense? (y/n)").equals("y"))
        {
            includePastTense = true;
        }

        boolean includeAffirmativeForm = false;
        boolean includeNegativeForm = false;

        if (askQuestion("Would you like to include Affirmative Form? (y/n)").equals("y"))
        {
            includeAffirmativeForm = true;
        }

        if (askQuestion("Would you like to include Negative Form? (y/n)").equals("y"))
        {
            includeNegativeForm = true;
        }

        boolean includePotentialForm = false;
        boolean includePassiveForm = false;
        boolean includeCausativeForm = false;
        boolean includeVolitionalForm = false;

        if (askQuestion("Would you like to include Potential Form? (y/n)").equals("y"))
        {
            includePotentialForm = true;
        }

        if (askQuestion("Would you like to include Passive Form? (y/n)").equals("y"))
        {
            includePassiveForm = true;
        }

        if (askQuestion("Would you like to include Causative Form? (y/n)").equals("y"))
        {
            includeCausativeForm = true;
        }

        if (askQuestion("Would you like to include Volitional Form? (y/n)").equals("y"))
        {
            includeVolitionalForm = true;
        }

        boolean includeTeForm = false;

        if (askQuestion("Would you like to include Te Form? (y/n)").equals("y"))
        {
            includeTeForm = true;
        }

        boolean[] options = new boolean[]{includeRuVerbs, includeUVerbs, includeIrregularVerbs, includeCasualForm, includeFormalForm, includePresentTense, includePastTense, includeAffirmativeForm, includeNegativeForm, includePotentialForm, includePassiveForm, includeCausativeForm, includeVolitionalForm, includeTeForm};

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
    private int selectRandomBoolean(boolean[] options)
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
     * Returns a random verb based on the options selected by the user
     * @return random verb based on the options selected by the user
     */
    private Verb selectVerb(boolean ruverbs, boolean uverbs, boolean irrverbs)
    {
        boolean[] options = new boolean[]{ruverbs, uverbs, irrverbs};

        int randomIndex = selectRandomBoolean(options);

        switch(randomIndex)
        {
            case 0:
                return XMLParser.getRandomRuVerb();
            case 1:
                return XMLParser.getRandomUVerb();
            case 2:
                return XMLParser.getRandomIrrVerb();
            default:
                System.out.println("Error: selectVerbType() returned invalid index");
                return XMLParser.getRandomRuVerb();
        }

    }

    /**
     * !Keep for GUI Version!
     * Returns a random formality based on the options selected by the user
     * @return random formality based on the options selected by the user
     */
    private String selectFormality(boolean casual, boolean formal)
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
    private String selectPolarity(boolean affirmative, boolean negative)
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
                return "Postive ";
        }
    }

    /**
     * !Keep for GUI Version!
     * Returns a random tense based on the options selected by the user
     * @return random tense based on the options selected by the user
     */
    private String selectTense(boolean present, boolean past)
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
     * Returns a random modifier based on the options selected by the user
     * @return random modifier based on the options selected by the user
     */
    private String selectModifier(boolean potential, boolean passive, boolean causative, boolean volitional)
    {
        boolean[] options = new boolean[]{potential, passive, causative, volitional, true};

        int randomIndex = selectRandomBoolean(options);

        switch(randomIndex)
        {
            case 0:
                return "Potential ";
            case 1:
                return "Passive ";
            case 2:
                return "Causative ";
            case 3:
                return "Volitional ";
            default:
                return "";//Random Generator selected No special modifier
        }
    }

    /**
     * !Keep for GUI Version!
     * Returns a random question based on the options selected by the user
     * @return random question based on the options selected by the user
     */
    public String[] generateQuestion(boolean[] options)
    {
        String[] result = {"Answer", "Hiragana", "conjugation"};

        Verb verb = selectVerb(options[0], options[1], options[2]);

        String formality = selectFormality(options[3], options[4]);

        String polarity = selectPolarity(options[7], options[8]);

        String tense = selectTense(options[5], options[6]);

        String modifier = selectModifier(options[9], options[10], options[11], options[12]);

        ConjugationType conjugation = ConjugationType.fromString(modifier + formality + polarity + tense);

       if (modifier.equals("Volitional "))
       {
            conjugation = ConjugationType.VOLITIONAL_FORMAL;
       } 

        if (conjugation == null)
        {
            System.out.println("Error: generateQuestion() returned invalid conjugation");
            System.out.println("Offending Results: " + modifier + formality + polarity + tense);
            return generateQuestion(options);
        }

        result[0] = verb.getConjugation(conjugation);

        result[1] = verb.getHiragana();

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

            System.out.println("What is the " + question[2] + " of " + question[1] + "?");

            String answer = scanner.nextLine();

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
        VerbConjugationPractice practice = new VerbConjugationPractice();

        practice.startPractice();
    }

}
