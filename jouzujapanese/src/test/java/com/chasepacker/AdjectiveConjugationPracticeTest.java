package com.chasepacker;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AdjectiveConjugationPracticeTest {


    @Test
    public void testGenerateQuestionNoFormal()
    {
        AdjectiveConjugationPractice acp = new AdjectiveConjugationPractice();

        //{includeIAdjectives, includeNaAdjectives, includeCasual, includeFormal, includePresent, includePast, includeAffirmative, includeNegative};
        boolean[] options = {true, true, true, false, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = acp.generateQuestion(options);

            System.out.println(result[2]);
            assertFalse(result[2].contains("Formal"));
        }
    }

    @Test
    public void testGenerateQuestionNoCasual()
    {
        AdjectiveConjugationPractice acp = new AdjectiveConjugationPractice();

        //{includeIAdjectives, includeNaAdjectives, includeCasual, includeFormal, includePresent, includePast, includeAffirmative, includeNegative};
        boolean[] options = {true, true, false, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = acp.generateQuestion(options);

            assertFalse(result[2].contains("Casual"));
        }
    }

    @Test
    public void testGenerateQuestionNoNegative()
    {
        AdjectiveConjugationPractice acp = new AdjectiveConjugationPractice();

        //{includeIAdjectives, includeNaAdjectives, includeCasual, includeFormal, includePresent, includePast, includeAffirmative, includeNegative};
        boolean[] options = {true, true, true, true, true, true, true, false};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = acp.generateQuestion(options);

            System.out.println(result[2]);
            assertFalse(result[2].contains("Negative"));
        }
    }

    @Test
    public void testGenerateQuestionNoPositive()
    {
        AdjectiveConjugationPractice acp = new AdjectiveConjugationPractice();

        //{includeIAdjectives, includeNaAdjectives, includeCasual, includeFormal, includePresent, includePast, includeAffirmative, includeNegative};
        boolean[] options = {true, true, true, true, true, true, false, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = acp.generateQuestion(options);
            System.out.println(result[2]);
            assertFalse(result[2].contains("Positive"));
        }
    }

    @Test
    public void testGenerateQuestionNoPast()
    {
        AdjectiveConjugationPractice acp = new AdjectiveConjugationPractice();

        //{includeIAdjectives, includeNaAdjectives, includeCasual, includeFormal, includePresent, includePast, includeAffirmative, includeNegative};
        boolean[] options = {true, true, true, true, true, false, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = acp.generateQuestion(options);
            System.out.println(result[2]);
            assertFalse(result[2].contains("Past"));
        }
    }

    @Test
    public void testGenerateQuestionNoPresent()
    {
        AdjectiveConjugationPractice acp = new AdjectiveConjugationPractice();

        //{includeIAdjectives, includeNaAdjectives, includeCasual, includeFormal, includePresent, includePast, includeAffirmative, includeNegative};
        boolean[] options = {true, true, true, true, false, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = acp.generateQuestion(options);
            System.out.println(result[2]);
            assertFalse(result[2].contains("Present"));
        }
    }
}


