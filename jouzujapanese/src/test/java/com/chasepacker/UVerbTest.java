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

    }



}
