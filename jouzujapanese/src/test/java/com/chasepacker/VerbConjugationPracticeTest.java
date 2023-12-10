package com.chasepacker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import com.chasepacker.ConjugationCode.Verb;

public class VerbConjugationPracticeTest {


    /*
     * public String[] generateQuestion(boolean[] options)
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
    */


    @Test
    public void testGenerateQuestion()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, true, true, true, true, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);
        }
    }

    @Test
    public void testGenerateQuestionNoModifiers()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, true, true, true, true, true, true, false, false, false, false};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);

            assertFalse(result[2].contains("Volitional"));
            assertFalse(result[2].contains("Potential"));
            assertFalse(result[2].contains("Passive"));
            assertFalse(result[2].contains("Causative"));  
        }
    }

    @Test
    public void testGenerateQuestionNoFormal()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, true, false, true, true, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);

            System.out.println(result[2]);
            assertFalse(result[2].contains("Formal"));
        }
    }

    @Test
    public void testGenerateQuestionNoCasual()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, false, true, true, true, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);

            assertFalse(result[2].contains("Casual"));
        }
    }

    @Test
    public void testGenerateQuestionNoNegative()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, true, true, true, true, true, false, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);

            System.out.println(result[2]);
            assertFalse(result[2].contains("Negative"));
        }
    }

    @Test
    public void testGenerateQuestionNoPositive()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, true, true, false, true, false, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);
            System.out.println(result[2]);
            assertFalse(result[2].contains("Positive"));
        }
    }

    @Test
    public void testGenerateQuestionNoPast()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, true, true, true, false, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);

            assertFalse(result[2].contains("Past"));
        }
    }

    @Test
    public void testGenerateQuestionNoPresent()
    {
        VerbConjugationPractice vcp = new VerbConjugationPractice();

        boolean[] options = {true, true, true, true, true, false, true, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = vcp.generateQuestion(options);
            System.out.println(result[2]);
            assertFalse(result[2].contains("Present"));
        }
    }
}
