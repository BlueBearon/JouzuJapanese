package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Verb;
import com.chasepacker.ConjugationCode.RuVerb;


public class RuVerbTest {

    /**
    * Tests setters for the IrrVerb class
    */
    @Test
    public void testSetters() {

        Verb verb = new RuVerb("食べる", "たべる", "taberu", "to eat");

        String expected = "食べる";

        assertEquals(expected, verb.getKanji());

        expected = "たべる";

        assertEquals(expected, verb.getHiragana());

        expected = "taberu";

        assertEquals(expected, verb.getRomanji());

        expected = "to eat";

        assertEquals(expected, verb.getEngMeaning());
    }

    /**
     * Tests RuVerb conjugation methods by testing the word "食べる" (たべる) "taberu" "to eat,"
     * 
     * @param args
     * @throws Exception
     */
    @Test
    public void testTaberu()
    {
            
        Verb testword = new RuVerb("食べる", "たべる", "taberu", "to eat");
    
        String expected = "たべる";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "たべない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "たべた";

        assertEquals(expected, testword.casualPositivePast());

        expected = "たべなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "たべます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "たべません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "たべました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "たべませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "たべて";

        assertEquals(expected, testword.te());

        expected = "たべられる";

        assertEquals(expected, testword.potential());

        expected = "たべさせる";

        assertEquals(expected, testword.causative());

        expected = "たべられる";

        assertEquals(expected, testword.passive());

        expected = "たべよう";

        assertEquals(expected, testword.volitional());

    }
}
