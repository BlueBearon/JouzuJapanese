package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Word;

public class WordTest {
    @Test
    public void testRomanjiParser() {

        String[] tests = {"taberu", "nomu", "suru", "kuru", "asobu", "nonde",
        "asobiniikumaenitabemonowotabenakerebanarimasen", 
        "nondeiruhitodesunedokonisundeimasuka",
        "tabenakatta"};
        String[] results = {"たべる", "のむ", "する", "くる", "あそぶ", "のんで", 
        "あそびにいくまえにたべものをたべなければなりません", 
        "のんでいるひとですねどこにすんでいますか",
        "たべなかった"};

        for(int i = 0; i < tests.length; i++)
        {
            System.out.println(tests[i]);
            System.out.println(Word.romanjiParser(tests[i]));
            System.out.println(results[i]);
            assertEquals(results[i], Word.romanjiParser(tests[i]));
        }

    }

    @Test
    public void testSetupMap() {

        Word.setupMap();

        for(int i = 0; i < Word.ROMANJI.length; i++)
        {
            assertEquals(Word.ROMATOHIRA.get(Word.ROMANJI[i]), Word.HIRAGANA[i]);
        }
        

    }

    @Test
    public void testHiraganaParser() {

        String[] results = {"taberu", "nomu", "suru", "kuru", "asobu", "nonde",
        "asobiniikumaenitabemonowotabenakerebanarimasen", 
        "nondeiruhitodesunedokonisundeimasuka",
        "tabenakatta", "matteiru"};
        String[] tests = {"たべる", "のむ", "する", "くる", "あそぶ", "のんで", 
        "あそびにいくまえにたべものをたべなければなりません", 
        "のんでいるひとですねどこにすんでいますか",
        "たべなかった", "まっている"};

        for(int i = 0; i < tests.length; i++)
        {
            System.out.println(Word.hiraganaParser(tests[i]));
            System.out.println(results[i]);
            assertEquals(results[i], Word.hiraganaParser(tests[i]));
        }
        
    }
}
