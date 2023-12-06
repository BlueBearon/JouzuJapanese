package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Verb;
import com.chasepacker.ConjugationCode.RuVerb;


public class RuVerbTest {

    /**
     * Tests RuVerb conjugation methods by testing the word "食べる" (たべる) "taberu" "to eat,"
     * 
     * @param args
     * @throws Exception
     */
    @Test
    public void testTaberu()
    {
            
        RuVerb testword = new RuVerb("食べる", "たべる", "taberu", "to eat");
    
        String expected = "taberu";
    }
}
