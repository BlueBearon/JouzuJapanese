package com.chasepacker;

import static org.junit.Assert.assertFalse;
import org.junit.Test;


public class VerbConjugationPracticeTest {


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
