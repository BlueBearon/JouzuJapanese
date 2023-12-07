package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Adjective;
import com.chasepacker.ConjugationCode.NaAdjective;

public class NaAdjectiveTest {

    @Test
    public void testSetters() {

        Adjective adj = new NaAdjective("きれい", "きれい", "kirei", "beautiful");

        String expected = "きれい";

        assertEquals(expected, adj.getKanji());

        expected = "きれい";

        assertEquals(expected, adj.getHiragana());

        expected = "kirei";

        assertEquals(expected, adj.getRomanji());

        expected = "beautiful";

        assertEquals(expected, adj.getEngMeaning());
    }

    @Test
    public void testKirei() {

        Adjective testword = new NaAdjective("きれい", "きれい", "kirei", "beautiful");

        String expected = "きれいだ";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "きれいじゃない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "きれいだった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "きれいじゃなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "きれいです";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "きれいじゃないです";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "きれいでした";

        assertEquals(expected, testword.formalPositivePast());

        expected = "きれいじゃなかったです";

        assertEquals(expected, testword.formalNegativePast());

        expected = "きれいで";

        assertEquals(expected, testword.te());
    }

    @Test
    public void testBenri() {

        Adjective testword = new NaAdjective("べんり", "べんり", "benri", "convenient");

        String expected = "べんりだ";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "べんりじゃない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "べんりだった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "べんりじゃなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "べんりです";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "べんりじゃないです";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "べんりでした";

        assertEquals(expected, testword.formalPositivePast());

        expected = "べんりじゃなかったです";

        assertEquals(expected, testword.formalNegativePast());

        expected = "べんりで";

        assertEquals(expected, testword.te());
    }
}
