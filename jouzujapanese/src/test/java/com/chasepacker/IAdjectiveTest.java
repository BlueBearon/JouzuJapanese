package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Adjective;
import com.chasepacker.ConjugationCode.IAdjective;

public class IAdjectiveTest {

    @Test
    public void testSetters() {

        Adjective adj = new IAdjective("あつい", "あつい", "atsui", "hot");

        String expected = "あつい";

        assertEquals(expected, adj.getKanji());

        expected = "あつい";

        assertEquals(expected, adj.getHiragana());

        expected = "atsui";

        assertEquals(expected, adj.getRomanji());

        expected = "hot";

        assertEquals(expected, adj.getEngMeaning());
    }

    @Test
    public void testAtsui() {

        Adjective testword = new IAdjective("あつい", "あつい", "atsui", "hot");

        String expected = "あつい";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "あつくない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "あつかった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "あつくなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "あついです";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "あつくないです";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "あつかったです";

        assertEquals(expected, testword.formalPositivePast());

        expected = "あつくなかったです";

        assertEquals(expected, testword.formalNegativePast());

        expected = "あつくて";

        assertEquals(expected, testword.te());
    }

    @Test
    public void testSamui() {

        Adjective testword = new IAdjective("さむい", "さむい", "samui", "cold");

        String expected = "さむい";

        assertEquals(expected, testword.casualPositivePresent());

        expected = "さむくない";

        assertEquals(expected, testword.casualNegativePresent());

        expected = "さむかった";

        assertEquals(expected, testword.casualPositivePast());

        expected = "さむくなかった";

        assertEquals(expected, testword.casualNegativePast());

        expected = "さむいです";

        assertEquals(expected, testword.formalPositivePresent());

        expected = "さむくないです";

        assertEquals(expected, testword.formalNegativePresent());

        expected = "さむかったです";

        assertEquals(expected, testword.formalPositivePast());

        expected = "さむくなかったです";

        assertEquals(expected, testword.formalNegativePast());

        expected = "さむくて";

        assertEquals(expected, testword.te());
    }
}