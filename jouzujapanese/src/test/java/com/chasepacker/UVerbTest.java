package com.chasepacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chasepacker.ConjugationCode.Verb;
import com.chasepacker.ConjugationCode.UVerb;

public class UVerbTest {


    Verb[] setup()
    {
        Verb[] tests = new Verb[4];
        tests[0] = new UVerb("帰る", "かえる", "kaeru", "to return");
        tests[1] = new UVerb("飲む", "のむ", "nomu", "to drink");
        tests[2] = new UVerb("待つ", "まつ", "matsu", "to wait");
        tests[3] = new UVerb("かう", "かう", "kau", "to buy");
        

        return tests;
    }

    @Test
    void testCasNegCan() {

        Verb[] test = setup();
        String[] results = {"kaerenai", "nomenai", "matenai", "kaenai"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casNegCan());
        }

    }

    @Test
    void testCasNegCaus() {

        Verb[] test = setup();
        String[] results = {"kaerasenai", "nomasenai", "matasenai", "kawasenai"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casNegCaus());
        }

    }

    @Test
    void testCasNegPass() {

        Verb[] test = setup();
        String[] results = {"kaerarenai", "nomarenai", "matarenai", "kawarenai"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casNegPass());
        }

    }

    @Test
    void testCasNegPast() {

        Verb[] test = setup();
        String[] results = {"kaeranakatta", "nomanakatta", "matanakatta", "kawanakatta"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casNegPast());
        }

    }

    @Test
    void testCasNegPres() {

        Verb[] test = setup();
        String[] results = {"kaeranai", "nomanai", "matanai", "kawanai"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casNegPres());
        }

    }

    @Test
    void testCasPosCan() {

        Verb[] test = setup();
        String[] results = {"kaereru", "nomeru", "materu", "kaeru"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casPosCan());
        }

    }

    @Test
    void testCasPosCaus() {

        Verb[] test = setup();
        String[] results = {"kaeraseru", "nomaseru", "mataseru", "kawaseru"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casPosCaus());
        }

    }

    @Test
    void testCasPosPass() {

        Verb[] test = setup();
        String[] results = {"kaerareru", "nomareru", "matareru", "kawareru"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casPosPass());
        }

    }

    @Test
    void testCasPosPast() {

        Verb[] test = setup();
        String[] results = {"kaetta", "nonda", "matta", "katta"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casPosPast());
        }

    }

    @Test
    void testCasPosPres() {

        Verb[] test = setup();
        String[] results = {"kaeru", "nomu", "matsu", "kau"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].casPosPres());
        }

    }

    @Test
    void testForNegCan() {

        Verb[] test = setup();
        String[] results = {"kaeremasen", "nomemasen", "matemasen", "kaemasen"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forNegCan());
        }

    }

    @Test
    void testForNegCaus() {

        Verb[] test = setup();
        String[] results = {"kaerasemasen", "nomasemasen", "matasemasen", "kawasemasen"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forNegCaus());
        }

    }

    @Test
    void testForNegPass() {

        Verb[] test = setup();
        String[] results = {"kaeraremasen", "nomaremasen", "mataremasen", "kawaremasen"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forNegPass());
        }

    }

    @Test
    void testForNegPast() {

        Verb[] test = setup();
        String[] results = {"kaerimasendeshita", "nomimasendeshita", "machimasendeshita", "kaimasendeshita"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forNegPast());
        }

    }

    @Test
    void testForNegPres() {

        Verb[] test = setup();
        String[] results = {"kaerimasen", "nomimasen", "machimasen", "kaimasen"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forNegPres());
        }

    }

    @Test
    void testForPosCan() {

        Verb[] test = setup();
        String[] results = {"kaeremasu", "nomemasu", "matemasu", "kaemasu"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forPosCan());
        }

    }

    @Test
    void testForPosCaus() {

        Verb[] test = setup();
        String[] results = {"kaerasemasu", "nomasemasu", "matasemasu", "kawasemasu"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forPosCaus());
        }

    }

    @Test
    void testForPosPass() {

        Verb[] test = setup();
        String[] results = {"kaeraremasu", "nomaremasu", "mataremasu", "kawaremasu"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forPosPass());
        }

    }

    @Test
    void testForPosPast() {

        Verb[] test = setup();
        String[] results = {"kaerimashita", "nomimashita", "machimashita", "kaimashita"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forPosPast());
        }

    }

    @Test
    void testForPosPres() {

        Verb[] test = setup();
        String[] results = {"kaerimasu", "nomimasu", "machimasu", "kaimasu"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].forPosPres());
        }

    }

    @Test
    void testGetEngMeaning() {

        Verb[] test = setup();
        String[] results = {"to return", "to drink", "to wait", "to buy"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].getEngMeaning());
        }

    }

    @Test
    void testGetHiragana() {

        Verb[] test = setup();
        String[] results = {"かえる", "のむ", "まつ", "かう"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].getHiragana());
        }

    }

    @Test
    void testGetKanji() {

        Verb[] test = setup();
        String[] results = {"帰る", "飲む", "待つ", "かう"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].getKanji());
        }

    }

    @Test
    void testGetRomanji() {

        Verb[] test = setup();
        String[] results = {"kaeru", "nomu", "matsu", "kau"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].getRomanji());
        }

    }

    @Test
    void testGetType() {

        Verb[] test = setup();
        int[] results = {1, 1, 1, 1};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].getType());
        }

    }

    @Test
    void testTe() {

        Verb[] test = setup();
        String[] results = {"kaette", "nonde", "matte", "katte"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].te());
        }

    }

    @Test
    void testBa() {

        Verb[] test = setup();
        String[] results = {"kaereba", "nomeba", "mateba", "kaeba"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].ba());
        }
    }

    @Test
    void testNegBa() {

        Verb[] test = setup();
        String[] results = {"kaeranakereba", "nomanakereba", "matanakereba", "kawanakereba"};

        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i].getRomanji()+ " -> " + results[i]);
            assertEquals(results[i], test[i].negBa());
        }
        
    }
}
