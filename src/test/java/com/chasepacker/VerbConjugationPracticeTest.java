package com.chasepacker;

import static org.junit.Assert.assertFalse;
import org.junit.Test;


public class VerbConjugationPracticeTest {

    @Test
    public void testGenerateQuestionNoModifiers()
    {
        

        boolean[] options = {true, true, true, true, true, true, true, true, true, false, false, false, false};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = VerbConjugationPractice.generateQuestion(options);

            assertFalse(result[2].contains("Volitional"));
            assertFalse(result[2].contains("Potential"));
            assertFalse(result[2].contains("Passive"));
            assertFalse(result[2].contains("Causative"));  
        }
    }

    @Test
    public void testGenerateQuestionNoFormal()
    {
        

        boolean[] options = {true, true, true, true, false, true, true, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = VerbConjugationPractice.generateQuestion(options);

            System.out.println(result[2]);
            assertFalse(result[2].contains("Formal"));
        }
    }

    @Test
    public void testGenerateQuestionNoCasual()
    {
        

        boolean[] options = {true, true, true, false, true, true, true, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = VerbConjugationPractice.generateQuestion(options);

            assertFalse(result[2].contains("Casual"));
        }
    }

    @Test
    public void testGenerateQuestionNoNegative()
    {
        

        boolean[] options = {true, true, true, true, true, true, true, true, false, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = VerbConjugationPractice.generateQuestion(options);

            System.out.println(result[2]);
            assertFalse(result[2].contains("Negative"));
        }
    }

    @Test
    public void testGenerateQuestionNoPositive()
    {
        

        boolean[] options = {true, true, true, true, true, false, true, false, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = VerbConjugationPractice.generateQuestion(options);
            System.out.println(result[2]);
            assertFalse(result[2].contains("Positive"));
        }
    }

    @Test
    public void testGenerateQuestionNoPast()
    {
        

        boolean[] options = {true, true, true, true, true, true, false, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = VerbConjugationPractice.generateQuestion(options);

            assertFalse(result[2].contains("Past"));
        }
    }

    @Test
    public void testGenerateQuestionNoPresent()
    {
        

        boolean[] options = {true, true, true, true, true, false, true, true, true, true, true, true, true};

        XMLParser.scan();

        int testruns = 100;

        for (int i = 0; i < testruns; i++)
        {
            String[] result = VerbConjugationPractice.generateQuestion(options);
            System.out.println(result[2]);
            assertFalse(result[2].contains("Present"));
        }
    }
}
