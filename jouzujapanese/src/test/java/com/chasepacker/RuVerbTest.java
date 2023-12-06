package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Verb;
import com.chasepacker.ConjugationCode.RuVerb;


public class RuVerbTest {

    Verb[] setup()
    {
        Verb[] tests = new Verb[4];
        tests[0] = new RuVerb("食べる", "たべる", "taberu", "to eat");
        tests[1] = new RuVerb("見る", "みる", "miru", "to watch");
        tests[2] = new RuVerb("寝る", "ねる", "neru", "to sleep");
        tests[3] = new RuVerb("いる", "いる", "iru", "to exist");
        

        return tests;
    }

    @Test
    void testCasNegCan() {

        Verb[] test = setup();
        String[] results = {"taberarenai", "mirarenai", "nerarenai", "irarenai"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casNegCan());
        }

    }

    @Test
    void testCasNegCaus() {

        Verb[] test = setup();
        String[] results = {"tabesasenai", "misasenai", "nesasenai", "isasenai"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casNegCaus());
        }

    }

    @Test
    void testCasNegPass() {

        Verb[] test = setup();
        String[] results = {"taberarenai", "mirarenai", "nerarenai", "irarenai"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casNegPass());
        }

    }

    @Test
    void testCasNegPast() {

        Verb[] test = setup();
        String[] results = {"tabenakatta", "minakatta", "nenakatta", "inakatta"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casNegPast());
        }

    }

    @Test
    void testCasNegPres() {

        Verb[] test = setup();
        String[] results = {"tabenai", "minai", "nenai", "inai"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casNegPres());
        }

    }

    @Test
    void testCasPosCan() {

        Verb[] test = setup();
        String[] results = {"taberareru", "mirareru", "nerareru", "irareru"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casPosCan());
        }

    }

    @Test
    void testCasPosCaus() {

        Verb[] test = setup();
        String[] results = {"tabesaseru", "misaseru", "nesaseru", "isaseru"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casPosCaus());
        }

    }

    @Test
    void testCasPosPass() {

        Verb[] test = setup();
        String[] results = {"taberareru", "mirareru", "nerareru", "irareru"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casPosPass());
        }

    }

    @Test
    void testCasPosPast() {

        Verb[] test = setup();
        String[] results = {"tabeta", "mita", "neta", "ita"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casPosPast());
        }

    }

    @Test
    void testCasPosPres() {

        Verb[] test = setup();
        String[] results = {"taberu", "miru", "neru", "iru"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].casPosPres());
        }

    }

    @Test
    void testForNegCan() {

        Verb[] test = setup();
        String[] results = {"taberaremasen", "miraremasen", "neraremasen", "iraremasen"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forNegCan());
        }

    }

    @Test
    void testForNegCaus() {

        Verb[] test = setup();
        String[] results = {"tabesasemasen", "misasemasen", "nesasemasen", "isasemasen"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forNegCaus());
        }

    }

    @Test
    void testForNegPass() {

        Verb[] test = setup();
        String[] results = {"taberaremasen", "miraremasen", "neraremasen", "iraremasen"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forNegPass());
        }

    }

    @Test
    void testForNegPast() {

        Verb[] test = setup();
        String[] results = {"tabemasendeshita", "mimasendeshita", "nemasendeshita", "imasendeshita"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forNegPast());
        }

    }

    @Test
    void testForNegPres() {

        Verb[] test = setup();
        String[] results = {"tabemasen", "mimasen", "nemasen", "imasen"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forNegPres());
        }

    }

    @Test
    void testForPosCan() {

        Verb[] test = setup();
        String[] results = {"taberaremasu", "miraremasu", "neraremasu", "iraremasu"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forPosCan());
        }

    }

    @Test
    void testForPosCaus() {

        Verb[] test = setup();
        String[] results = {"tabesasemasu", "misasemasu", "nesasemasu", "isasemasu"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forPosCaus());
        }

    }

    @Test
    void testForPosPass() {

        Verb[] test = setup();
        String[] results = {"taberaremasu", "miraremasu", "neraremasu", "iraremasu"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forPosPass());
        }

    }

    @Test
    void testForPosPast() {

        Verb[] test = setup();
        String[] results = {"tabemashita", "mimashita", "nemashita", "imashita"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forPosPast());
        }

    }

    @Test
    void testForPosPres() {

        Verb[] test = setup();
        String[] results = {"tabemasu", "mimasu", "nemasu", "imasu"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].forPosPres());
        }


    }


    @Test
    void testGetEngMeaning() {

        Verb[] test = setup();
        String[] results = {"to eat", "to watch", "to sleep", "to exist"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].getEngMeaning());
        }


    }

    @Test
    void testGetHiragana() {

        Verb[] test = setup();
        String[] results = {"たべる", "みる", "ねる", "いる"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].getHiragana());
        }

    }

    @Test
    void testGetKanji() {

        Verb[] test = setup();
        String[] results = {"食べる", "見る", "寝る", "いる"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].getKanji());
        }

    }

    @Test
    void testGetRomanji() {

        Verb[] test = setup();
        String[] results = {"taberu", "miru", "neru", "iru"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].getRomanji());
        }

    }

    @Test
    void testGetType() {

        Verb[] test = setup();
        int[] results = {2, 2, 2, 2};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].getType());
        }

    }

    @Test
    void testTe() {

        Verb[] test = setup();
        String[] results = {"tabete", "mite", "nete", "ite"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].te());
        }

    }

    @Test
    void testBa() {

        Verb[] test = setup();
        String[] results = {"tabereba", "mireba", "nereba", "ireba"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].ba());
        }
        
    }

    @Test
    void testNegBa() {

        Verb[] test = setup();
        String[] results = {"tabenakereba", "minakereba", "nenakereba", "inakereba"};

        for(int i = 0; i < test.length; i++)
        {
            assertEquals(results[i], test[i].negBa());
        }
        
    }
}
