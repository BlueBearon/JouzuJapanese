package com.chasepacker;

import static org.junit.Assert.assertEquals;
import com.chasepacker.ConjugationCode.Verb;
import com.chasepacker.ConjugationCode.IrrVerb;


import org.junit.Test;
/**
 * mvn jacoco:prepare-agent test install jacoco:report
 */
public class IrrVerbTest {


    /**
     * Tests setters for the IrrVerb class
    */
    @Test
    public void testSetters() {
        Verb verb = new IrrVerb("する", "する", "suru", "to do");
        
        String expected = "する";

        assertEquals(expected, verb.getKanji());

        expected = "する";

        assertEquals(expected, verb.getHiragana());

        expected = "suru";

        assertEquals(expected, verb.getRomanji());

        expected = "to do";

        assertEquals(expected, verb.getEngMeaning());
    }
    
    /**
     * Tests the conjugation of the verb suru (to do) in all forms
     */
    @Test
    public void testSuru() {
        Verb verb = new IrrVerb("する", "する", "suru", "to do");
        
        String expected = "する";

        assertEquals(expected, verb.casualPositivePresent());

        expected = "しない";

        assertEquals(expected, verb.casualNegativePresent());

        expected = "した";

        assertEquals(expected, verb.casualPositivePast());

        expected = "しなかった";

        assertEquals(expected, verb.casualNegativePast());

        expected = "します";

        assertEquals(expected, verb.formalPositivePresent());

        expected = "しません";

        assertEquals(expected, verb.formalNegativePresent());

        expected = "しました";

        assertEquals(expected, verb.formalPositivePast());

        expected = "しませんでした";

        assertEquals(expected, verb.formalNegativePast());

        expected = "して";

        assertEquals(expected, verb.te());

        expected = "しよう";

        assertEquals(expected, verb.volitional());

        expected = "できる";

        assertEquals(expected, verb.potential());

        expected = "される";

        assertEquals(expected, verb.passive());

        expected = "させる";

        assertEquals(expected, verb.causative());
    }

    /**
     * Tests the conjugation of the verb kuru (to come) in all forms
     */
    @Test
    public void testKuru() {
        Verb verb = new IrrVerb("くる", "くる", "kuru", "to come");
        
        String expected = "くる";

        assertEquals(expected, verb.casualPositivePresent());

        expected = "こない";

        assertEquals(expected, verb.casualNegativePresent());

        expected = "きた";

        assertEquals(expected, verb.casualPositivePast());

        expected = "こなかった";

        assertEquals(expected, verb.casualNegativePast());

        expected = "きます";

        assertEquals(expected, verb.formalPositivePresent());

        expected = "きません";

        assertEquals(expected, verb.formalNegativePresent());

        expected = "きました";

        assertEquals(expected, verb.formalPositivePast());

        expected = "きませんでした";

        assertEquals(expected, verb.formalNegativePast());

        expected = "きて";

        assertEquals(expected, verb.te());

        expected = "こよう";

        assertEquals(expected, verb.volitional());

        expected = "こられる";

        assertEquals(expected, verb.potential());

        expected = "こさせる";

        assertEquals(expected, verb.causative());

        expected = "こられる";

        assertEquals(expected, verb.passive());
    }

    /**
     * Tests the conjugation of suru (to do) even though it is an the end of a noun
     */
    @Test
    public void testSentakusuru() {
        Verb verb = new IrrVerb("選択する", "せんたくする", "sentakusuru", "to choose");
        
        String expected = "せんたくする";

        assertEquals(expected, verb.casualPositivePresent());

        expected = "せんたくしない";

        assertEquals(expected, verb.casualNegativePresent());

        expected = "せんたくした";

        assertEquals(expected, verb.casualPositivePast());

        expected = "せんたくしなかった";

        assertEquals(expected, verb.casualNegativePast());

        expected = "せんたくします";

        assertEquals(expected, verb.formalPositivePresent());

        expected = "せんたくしません";

        assertEquals(expected, verb.formalNegativePresent());

        expected = "せんたくしました";

        assertEquals(expected, verb.formalPositivePast());

        expected = "せんたくしませんでした";

        assertEquals(expected, verb.formalNegativePast());

        expected = "せんたくして";

        assertEquals(expected, verb.te());

        expected = "せんたくしよう";

        assertEquals(expected, verb.volitional());

        expected = "せんたくできる";

        assertEquals(expected, verb.potential());

        expected = "せんたくさせる";

        assertEquals(expected, verb.causative());

        expected = "せんたくされる";

        assertEquals(expected, verb.passive());
    }

    /**
     * Tests the conjugation of kuru (to come) even though it is an the end of a noun
     */
    @Test
    public void testMukaenikuru() {
        Verb verb = new IrrVerb("迎えにくる", "むかえにくる", "mukaenikuru", "to come to pick up");
        
        String expected = "むかえにくる";

        assertEquals(expected, verb.casualPositivePresent());

        expected = "むかえにこない";

        assertEquals(expected, verb.casualNegativePresent());

        expected = "むかえにきた";

        assertEquals(expected, verb.casualPositivePast());

        expected = "むかえにこなかった";

        assertEquals(expected, verb.casualNegativePast());

        expected = "むかえにきます";

        assertEquals(expected, verb.formalPositivePresent());

        expected = "むかえにきません";

        assertEquals(expected, verb.formalNegativePresent());

        expected = "むかえにきました";

        assertEquals(expected, verb.formalPositivePast());

        expected = "むかえにきませんでした";

        assertEquals(expected, verb.formalNegativePast());

        expected = "むかえにきて";

        assertEquals(expected, verb.te());

        expected = "むかえにこよう";

        assertEquals(expected, verb.volitional());

        expected = "むかえにこられる";

        assertEquals(expected, verb.potential());

        expected = "むかえにこさせる";

        assertEquals(expected, verb.causative());

        expected = "むかえにこられる";

        assertEquals(expected, verb.passive());
    }

   
}
