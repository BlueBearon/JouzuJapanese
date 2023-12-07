package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Verb;
import com.chasepacker.ConjugationCode.UVerb;

public class UVerbTest {

    /**
    * Tests setters for the IrrVerb class
    */
    @Test
    public void testSetters() {

        Verb verb = new UVerb("行く", "いく", "iku", "to go");

        String expected = "行く";

        assertEquals(expected, verb.getKanji());

        expected = "いく";

        assertEquals(expected, verb.getHiragana());

        expected = "iku";

        assertEquals(expected, verb.getRomanji());

        expected = "to go";

        assertEquals(expected, verb.getEngMeaning());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "帰る" (かえる) "kaeru" "to return," 
     * a UVerb with a "ru" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    public void testKaeru()
    {

        UVerb testword = new UVerb("帰る", "かえる", "kaeru", "to return");

        String expected = "かえる";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "かえらない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "かえった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "かえらなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "かえります";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "かえりません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "かえりました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "かえりませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "かえって";

        assertEquals(expected, testword.te());

        expected = "かえれる";

        assertEquals(expected, testword.potential());

        expected = "かえらせる";

        assertEquals(expected, testword.causative());

        expected = "かえられる";

        assertEquals(expected, testword.passive());

        expected = "かえろう";

        assertEquals(expected, testword.volitional());

        expected = "かえれない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "かえれた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "かえれなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "かえれます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "かえれません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "かえれました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "かえれませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "かえられない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "かえられた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "かえられなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "かえられます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "かえられません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "かえられました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "かえられませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "かえらせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "かえらせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "かえらせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "かえらせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "かえらせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "かえらせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "かえらせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "かえりましょう";

        assertEquals(expected, testword.volitionalFormal());
    }

    /**
     * Tests UVerb conjugation methods by testing the word "飲む" (のむ) "nomu" "to drink," 
     * a UVerb with a "mu" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    public void testNomu()
    {

        UVerb testword = new UVerb("飲む", "のむ", "nomu", "to drink");
        
        String expected = "のむ";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "のまない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "のんだ";

        assertEquals(expected, testword.casualPositivePast());

        expected = "のまなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "のみます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "のみません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "のみました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "のみませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "のんで";

        assertEquals(expected, testword.te());

        expected = "のめる";

        assertEquals(expected, testword.potential());

        expected = "のませる";

        assertEquals(expected, testword.causative());

        expected = "のまれる";

        assertEquals(expected, testword.passive());

        expected = "のもう";

        assertEquals(expected, testword.volitional());

        expected = "のめない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "のめた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "のめなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "のめます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "のめません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "のめました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "のめませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "のまれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "のまれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "のまれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "のまれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "のまれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "のまれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "のまれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "のませない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "のませた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "のませなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "のませます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "のませません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "のませました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "のませませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "のみましょう";

        assertEquals(expected, testword.volitionalFormal());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "待つ" (まつ) "matsu" "to wait," 
     * a UVerb with a "tsu" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    public void testMatsu()
    {

        UVerb testword = new UVerb("待つ", "まつ", "matsu", "to wait");

        String expected = "まつ";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "またない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "まった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "またなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "まちます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "まちません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "まちました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "まちませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "まって";

        assertEquals(expected, testword.te());

        expected = "まてる";

        assertEquals(expected, testword.potential());

        expected = "またせる";

        assertEquals(expected, testword.causative());

        expected = "またれる";

        assertEquals(expected, testword.passive());

        expected = "まとう";

        assertEquals(expected, testword.volitional());

        expected = "まてない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "まてた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "まてなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "まてます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "まてません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "まてました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "まてませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "またれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "またれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "またれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "またれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "またれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "またれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "またれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "またせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "またせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "またせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "またせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "またせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "またせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "またせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "まちましょう";

        assertEquals(expected, testword.volitionalFormal());
    }

    /**
     * Tests UVerb conjugation methods by testing the word "死ぬ" (しぬ) "shinu" "to die," 
     * a UVerb with a "nu" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    public void testKau()
    {

        UVerb testword = new UVerb("かう", "かう", "kau", "to buy");

        String expected = "かう";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "かわない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "かった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "かわなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "かいます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "かいません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "かいました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "かいませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "かって";

        assertEquals(expected, testword.te());

        expected = "かえる";

        assertEquals(expected, testword.potential());

        expected = "かわせる";

        assertEquals(expected, testword.causative());

        expected = "かわれる";

        assertEquals(expected, testword.passive());

        expected = "かおう";

        assertEquals(expected, testword.volitional());

        expected = "かえない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "かえた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "かえなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "かえます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "かえません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "かえました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "かえませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "かわれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "かわれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "かわれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "かわれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "かわれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "かわれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "かわれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "かわせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "かわせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "かわせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "かわせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "かわせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "かわせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "かわせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "かいましょう";

        assertEquals(expected, testword.volitionalFormal());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "死ぬ" (しぬ) "shinu" "to die," 
     * a UVerb with a "nu" ending.
     * 
     * @param args
     * @throws Exception
     */
    @Test
    public void testShinu()
    {

        UVerb testword = new UVerb("死ぬ", "しぬ", "shinu", "to die");

        String expected = "しぬ";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "しなない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "しんだ";

        assertEquals(expected, testword.casualPositivePast());

        expected = "しななかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "しにます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "しにません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "しにました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "しにませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "しんで";

        assertEquals(expected, testword.te());

        expected = "しねる";

        assertEquals(expected, testword.potential());

        expected = "しなせる";

        assertEquals(expected, testword.causative());

        expected = "しなれる";

        assertEquals(expected, testword.passive());

        expected = "しのう";

        assertEquals(expected, testword.volitional());

        expected = "しねない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "しねた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "しねなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "しねます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "しねません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "しねました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "しねませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "しなれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "しなれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "しなれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "しなれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "しなれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "しなれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "しなれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "しなせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "しなせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "しなせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "しなせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "しなせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "しなせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "しなせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "しにましょう";

        assertEquals(expected, testword.volitionalFormal());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "直す" (なおす) "naosu" "to fix,"
     * a UVerb with a "su" ending.
     */
    @Test
    public void testNaosu()
    {

        UVerb testword = new UVerb("直す", "なおす", "naosu", "to fix");

        String expected = "なおす";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "なおさない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "なおした";

        assertEquals(expected, testword.casualPositivePast());

        expected = "なおさなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "なおします";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "なおしません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "なおしました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "なおしませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "なおして";

        assertEquals(expected, testword.te());

        expected = "なおせる";

        assertEquals(expected, testword.potential());

        expected = "なおさせる";

        assertEquals(expected, testword.causative());

        expected = "なおされる";

        assertEquals(expected, testword.passive());

        expected = "なおそう";

        assertEquals(expected, testword.volitional());

        expected = "なおせない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "なおせた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "なおせなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "なおせます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "なおせません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "なおせました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "なおせませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "なおされない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "なおされた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "なおされなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "なおされます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "なおされません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "なおされました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "なおされませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "なおさせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "なおさせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "なおさせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "なおさせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "なおさせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "なおさせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "なおさせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "なおしましょう";

        assertEquals(expected, testword.volitionalFormal());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "泳ぐ" (およぐ) "oyogu" "to swim,"
     * a UVerb with a "gu" ending.
     */
    @Test
    public void testOyogu()
    {

        UVerb testword = new UVerb("泳ぐ", "およぐ", "oyogu", "to swim");

        String expected = "およぐ";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "およがない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "およいだ";

        assertEquals(expected, testword.casualPositivePast());

        expected = "およがなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "およぎます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "およぎません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "およぎました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "およぎませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "およいで";

        assertEquals(expected, testword.te());

        expected = "およげる";

        assertEquals(expected, testword.potential());

        expected = "およがせる";

        assertEquals(expected, testword.causative());

        expected = "およがれる";

        assertEquals(expected, testword.passive());

        expected = "およごう";

        assertEquals(expected, testword.volitional());

        expected = "およげない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "およげた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "およげなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "およげます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "およげません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "およげました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "およげませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "およがれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "およがれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "およがれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "およがれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "およがれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "およがれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "およがれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "およがせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "およがせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "およがせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "およがせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "およがせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "およがせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "およがせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "およぎましょう";

        assertEquals(expected, testword.volitionalFormal());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "開く" (ひらく) "hiraku" "to open,"
     * a UVerb with a "ku" ending.
     */
    @Test
    public void testHiraku()
    {

        UVerb testword = new UVerb("開く", "ひらく", "hiraku", "to open");

        String expected = "ひらく";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "ひらかない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "ひらいた";

        assertEquals(expected, testword.casualPositivePast());

        expected = "ひらかなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "ひらきます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "ひらきません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "ひらきました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "ひらきませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "ひらいて";

        assertEquals(expected, testword.te());

        expected = "ひらける";

        assertEquals(expected, testword.potential());

        expected = "ひらかせる";

        assertEquals(expected, testword.causative());

        expected = "ひらかれる";

        assertEquals(expected, testword.passive());

        expected = "ひらこう";

        assertEquals(expected, testword.volitional());

        expected = "ひらけない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "ひらけた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "ひらけなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "ひらけます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "ひらけません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "ひらけました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "ひらけませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "ひらかれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "ひらかれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "ひらかれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "ひらかれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "ひらかれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "ひらかれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "ひらかれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "ひらかせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "ひらかせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "ひらかせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "ひらかせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "ひらかせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "ひらかせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "ひらかせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "ひらきましょう";

        assertEquals(expected, testword.volitionalFormal());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "遊ぶ" (あそぶ) "asobu" "to play,"
     * a UVerb with a "bu" ending.
     */
    @Test
    public void testAsobu()
    {

        UVerb testword = new UVerb("遊ぶ", "あそぶ", "asobu", "to play");

        String expected = "あそぶ";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "あそばない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "あそんだ";

        assertEquals(expected, testword.casualPositivePast());

        expected = "あそばなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "あそびます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "あそびません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "あそびました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "あそびませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "あそんで";

        assertEquals(expected, testword.te());

        expected = "あそべる";

        assertEquals(expected, testword.potential());

        expected = "あそばせる";

        assertEquals(expected, testword.causative());

        expected = "あそばれる";

        assertEquals(expected, testword.passive());

        expected = "あそぼう";

        assertEquals(expected, testword.volitional());

        expected = "あそべない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "あそべた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "あそべなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "あそべます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "あそべません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "あそべました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "あそべませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "あそばれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "あそばれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "あそばれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "あそばれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "あそばれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "あそばれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "あそばれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "あそばせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "あそばせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "あそばせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "あそばせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "あそばせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "あそばせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "あそばせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "あそびましょう";

        assertEquals(expected, testword.volitionalFormal());

    }

    /**
     * Tests UVerb conjugation methods by testing the word "行く" (いく) "iku" "to go,"
     * which while a UVerb ending in "ku", has an irregular te form and casual past tense
     */
    @Test
    public void testIku()
    {

        UVerb testword = new UVerb("行く", "いく", "iku", "to go");

        String expected = "いく";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "いかない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "いった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "いかなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "いきます";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "いきません";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "いきました";

        assertEquals(expected, testword.formalPositivePast());

        expected = "いきませんでした";

        assertEquals(expected, testword.formalNegativePast());

        expected = "いって";

        assertEquals(expected, testword.te());

        expected = "いける";

        assertEquals(expected, testword.potential());

        expected = "いかせる";

        assertEquals(expected, testword.causative());

        expected = "いかれる";

        assertEquals(expected, testword.passive());

        expected = "いこう";

        assertEquals(expected, testword.volitional());

        expected = "いけない";

        assertEquals(expected, testword.potentialCasualNegativePresent());

        expected = "いけた";

        assertEquals(expected, testword.potentialCasualPositivePast());

        expected = "いけなかった";

        assertEquals(expected, testword.potentialCasualNegativePast());

        expected = "いけます";

        assertEquals(expected, testword.potentialFormalPositivePresent());

        expected = "いけません";

        assertEquals(expected, testword.potentialFormalNegativePresent());

        expected = "いけました";

        assertEquals(expected, testword.potentialFormalPositivePast());

        expected = "いけませんでした";

        assertEquals(expected, testword.potentialFormalNegativePast());

        expected = "いかれない";

        assertEquals(expected, testword.passiveCasualNegativePresent());

        expected = "いかれた";

        assertEquals(expected, testword.passiveCasualPositivePast());

        expected = "いかれなかった";

        assertEquals(expected, testword.passiveCasualNegativePast());

        expected = "いかれます";

        assertEquals(expected, testword.passiveFormalPositivePresent());

        expected = "いかれません";

        assertEquals(expected, testword.passiveFormalNegativePresent());

        expected = "いかれました";

        assertEquals(expected, testword.passiveFormalPositivePast());

        expected = "いかれませんでした";

        assertEquals(expected, testword.passiveFormalNegativePast());

        expected = "いかせない";

        assertEquals(expected, testword.causativeCasualNegativePresent());

        expected = "いかせた";

        assertEquals(expected, testword.causativeCasualPositivePast());

        expected = "いかせなかった";

        assertEquals(expected, testword.causativeCasualNegativePast());

        expected = "いかせます";

        assertEquals(expected, testword.causativeFormalPositivePresent());

        expected = "いかせません";

        assertEquals(expected, testword.causativeFormalNegativePresent());

        expected = "いかせました";

        assertEquals(expected, testword.causativeFormalPositivePast());

        expected = "いかせませんでした";

        assertEquals(expected, testword.causativeFormalNegativePast());

        expected = "いきましょう";

        assertEquals(expected, testword.volitionalFormal());

    }



}
