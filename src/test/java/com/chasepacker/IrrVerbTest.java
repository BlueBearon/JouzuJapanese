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

        expected = "できない";

        assertEquals(expected, verb.potentialCasualNegativePresent());

        expected = "できた";

        assertEquals(expected, verb.potentialCasualPositivePast());

        expected = "できなかった";

        assertEquals(expected, verb.potentialCasualNegativePast());

        expected = "できます";

        assertEquals(expected, verb.potentialFormalPositivePresent());

        expected = "できません";

        assertEquals(expected, verb.potentialFormalNegativePresent());

        expected = "できました";

        assertEquals(expected, verb.potentialFormalPositivePast());

        expected = "できませんでした";

        assertEquals(expected, verb.potentialFormalNegativePast());

        expected = "させない";

        assertEquals(expected, verb.causativeCasualNegativePresent());

        expected = "させた";

        assertEquals(expected, verb.causativeCasualPositivePast());

        expected = "させなかった";

        assertEquals(expected, verb.causativeCasualNegativePast());

        expected = "させます";

        assertEquals(expected, verb.causativeFormalPositivePresent());

        expected = "させません";

        assertEquals(expected, verb.causativeFormalNegativePresent());

        expected = "させました";

        assertEquals(expected, verb.causativeFormalPositivePast());

        expected = "させませんでした";

        assertEquals(expected, verb.causativeFormalNegativePast());

        expected = "されない";

        assertEquals(expected, verb.passiveCasualNegativePresent());

        expected = "された";

        assertEquals(expected, verb.passiveCasualPositivePast());

        expected = "されなかった";

        assertEquals(expected, verb.passiveCasualNegativePast());

        expected = "されます";

        assertEquals(expected, verb.passiveFormalPositivePresent());

        expected = "されません";

        assertEquals(expected, verb.passiveFormalNegativePresent());

        expected = "されました";

        assertEquals(expected, verb.passiveFormalPositivePast());

        expected = "されませんでした";

        assertEquals(expected, verb.passiveFormalNegativePast());

        expected = "しましょう";

        assertEquals(expected, verb.volitionalFormal());
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

        expected = "こられない";

        assertEquals(expected, verb.potentialCasualNegativePresent());

        expected = "こられた";

        assertEquals(expected, verb.potentialCasualPositivePast());

        expected = "こられなかった";

        assertEquals(expected, verb.potentialCasualNegativePast());

        expected = "こられます";

        assertEquals(expected, verb.potentialFormalPositivePresent());

        expected = "こられません";

        assertEquals(expected, verb.potentialFormalNegativePresent());

        expected = "こられました";

        assertEquals(expected, verb.potentialFormalPositivePast());

        expected = "こられませんでした";

        assertEquals(expected, verb.potentialFormalNegativePast());

        expected = "こさせない";

        assertEquals(expected, verb.causativeCasualNegativePresent());

        expected = "こさせた";

        assertEquals(expected, verb.causativeCasualPositivePast());

        expected = "こさせなかった";

        assertEquals(expected, verb.causativeCasualNegativePast());

        expected = "こさせます";

        assertEquals(expected, verb.causativeFormalPositivePresent());

        expected = "こさせません";

        assertEquals(expected, verb.causativeFormalNegativePresent());

        expected = "こさせました";

        assertEquals(expected, verb.causativeFormalPositivePast());

        expected = "こさせませんでした";

        assertEquals(expected, verb.causativeFormalNegativePast());

        expected = "こられない";

        assertEquals(expected, verb.passiveCasualNegativePresent());

        expected = "こられた";

        assertEquals(expected, verb.passiveCasualPositivePast());

        expected = "こられなかった";

        assertEquals(expected, verb.passiveCasualNegativePast());

        expected = "こられます";

        assertEquals(expected, verb.passiveFormalPositivePresent());

        expected = "こられません";

        assertEquals(expected, verb.passiveFormalNegativePresent());

        expected = "こられました";

        assertEquals(expected, verb.passiveFormalPositivePast());

        expected = "こられませんでした";

        assertEquals(expected, verb.passiveFormalNegativePast());

        expected = "きましょう";

        assertEquals(expected, verb.volitionalFormal());
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

        expected = "せんたくできない";

        assertEquals(expected, verb.potentialCasualNegativePresent());

        expected = "せんたくできた";

        assertEquals(expected, verb.potentialCasualPositivePast());

        expected = "せんたくできなかった";

        assertEquals(expected, verb.potentialCasualNegativePast());

        expected = "せんたくできます";

        assertEquals(expected, verb.potentialFormalPositivePresent());

        expected = "せんたくできません";

        assertEquals(expected, verb.potentialFormalNegativePresent());

        expected = "せんたくできました";

        assertEquals(expected, verb.potentialFormalPositivePast());

        expected = "せんたくできませんでした";

        assertEquals(expected, verb.potentialFormalNegativePast());

        expected = "せんたくさせない";

        assertEquals(expected, verb.causativeCasualNegativePresent());

        expected = "せんたくさせた";

        assertEquals(expected, verb.causativeCasualPositivePast());

        expected = "せんたくさせなかった";

        assertEquals(expected, verb.causativeCasualNegativePast());

        expected = "せんたくさせます";

        assertEquals(expected, verb.causativeFormalPositivePresent());

        expected = "せんたくさせません";

        assertEquals(expected, verb.causativeFormalNegativePresent());

        expected = "せんたくさせました";

        assertEquals(expected, verb.causativeFormalPositivePast());

        expected = "せんたくさせませんでした";

        assertEquals(expected, verb.causativeFormalNegativePast());

        expected = "せんたくされない";

        assertEquals(expected, verb.passiveCasualNegativePresent());

        expected = "せんたくされた";

        assertEquals(expected, verb.passiveCasualPositivePast());

        expected = "せんたくされなかった";

        assertEquals(expected, verb.passiveCasualNegativePast());

        expected = "せんたくされます";

        assertEquals(expected, verb.passiveFormalPositivePresent());

        expected = "せんたくされません";

        assertEquals(expected, verb.passiveFormalNegativePresent());

        expected = "せんたくされました";

        assertEquals(expected, verb.passiveFormalPositivePast());

        expected = "せんたくされませんでした";

        assertEquals(expected, verb.passiveFormalNegativePast());

        expected = "せんたくしましょう";

        assertEquals(expected, verb.volitionalFormal());
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

        expected = "むかえにこられない";

        assertEquals(expected, verb.potentialCasualNegativePresent());

        expected = "むかえにこられた";

        assertEquals(expected, verb.potentialCasualPositivePast());

        expected = "むかえにこられなかった";

        assertEquals(expected, verb.potentialCasualNegativePast());

        expected = "むかえにこられます";

        assertEquals(expected, verb.potentialFormalPositivePresent());

        expected = "むかえにこられません";

        assertEquals(expected, verb.potentialFormalNegativePresent());

        expected = "むかえにこられました";

        assertEquals(expected, verb.potentialFormalPositivePast());

        expected = "むかえにこられませんでした";

        assertEquals(expected, verb.potentialFormalNegativePast());

        expected = "むかえにこさせない";

        assertEquals(expected, verb.causativeCasualNegativePresent());

        expected = "むかえにこさせた";

        assertEquals(expected, verb.causativeCasualPositivePast());

        expected = "むかえにこさせなかった";

        assertEquals(expected, verb.causativeCasualNegativePast());

        expected = "むかえにこさせます";

        assertEquals(expected, verb.causativeFormalPositivePresent());

        expected = "むかえにこさせません";

        assertEquals(expected, verb.causativeFormalNegativePresent());

        expected = "むかえにこさせました";

        assertEquals(expected, verb.causativeFormalPositivePast());

        expected = "むかえにこさせませんでした";

        assertEquals(expected, verb.causativeFormalNegativePast());

        expected = "むかえにこられない";

        assertEquals(expected, verb.passiveCasualNegativePresent());

        expected = "むかえにこられた";

        assertEquals(expected, verb.passiveCasualPositivePast());

        expected = "むかえにこられなかった";

        assertEquals(expected, verb.passiveCasualNegativePast());

        expected = "むかえにこられます";

        assertEquals(expected, verb.passiveFormalPositivePresent());

        expected = "むかえにこられません";

        assertEquals(expected, verb.passiveFormalNegativePresent());

        expected = "むかえにこられました";

        assertEquals(expected, verb.passiveFormalPositivePast());

        expected = "むかえにこられませんでした";

        assertEquals(expected, verb.passiveFormalNegativePast());

        expected = "むかえにきましょう";

        assertEquals(expected, verb.volitionalFormal());
    }

   
}
