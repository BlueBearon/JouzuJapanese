package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Verb;
import com.chasepacker.ConjugationCode.UVerb;

public class UVerbTest {

    /**
     * Tests UVerb conjugation methods by testing the word "帰る" (かえる) "kaeru" "to return," 
     * a UVerb with a "ru" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    void testKaeru()
    {

        UVerb testword = new UVerb("帰る", "かえる", "kaeru", "to return");

        String expected = "kaeru";

    }

    /**
     * Tests UVerb conjugation methods by testing the word "飲む" (のむ) "nomu" "to drink," 
     * a UVerb with a "mu" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    void testNomu()
    {

        UVerb testword = new UVerb("飲む", "のむ", "nomu", "to drink");

    }

    /**
     * Tests UVerb conjugation methods by testing the word "待つ" (まつ) "matsu" "to wait," 
     * a UVerb with a "tsu" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    void testMatsu()
    {

        UVerb testword = new UVerb("待つ", "まつ", "matsu", "to wait");

    }

    /**
     * Tests UVerb conjugation methods by testing the word "死ぬ" (しぬ) "shinu" "to die," 
     * a UVerb with a "nu" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    void testKau()
    {

        UVerb testword = new UVerb("かう", "かう", "kau", "to buy");

    }

}
