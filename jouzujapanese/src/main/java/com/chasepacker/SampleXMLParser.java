package com.chasepacker;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import com.chasepacker.ConjugationCode.*;

public class SampleXMLParser {

    public static ArrayList<RuVerb> ruVerbs = new ArrayList<RuVerb>();
    public static ArrayList<UVerb> uVerbs = new ArrayList<UVerb>();
    public static ArrayList<IrrVerb> irrVerbs = new ArrayList<IrrVerb>();
    public static ArrayList<IAdjective> iAdjectives = new ArrayList<IAdjective>();
    public static ArrayList<NaAdjective> naAdjectives = new ArrayList<NaAdjective>();


    //Get the root directory of project
    private final static String rootDirectory = System.getProperty("user.dir");

    //D:\Coding\Jouzu\JouzuJapanese\jouzujapanese\src\main\java\com\chasepacker\Words\naAdjectives.xml
    

    private final static String ruVerbXML = rootDirectory + "\\src\\main\\java\\com\\chasepacker\\Words\\ruVerbs.xml";
    private final static String uVerbXML = rootDirectory + "\\src\\main\\java\\com\\chasepacker\\Words\\uVerbs.xml";
    private final static String irrVerbXML = rootDirectory + "\\src\\main\\java\\com\\chasepacker\\Words\\irrVerbs.xml";
    private final static String iAdjectiveXML = rootDirectory + "\\src\\main\\java\\com\\chasepacker\\Words\\iAdjectives.xml";
    private final static String naAdjectiveXML = rootDirectory + "\\src\\main\\java\\com\\chasepacker\\Words\\naAdjectives.xml";



    private static void parseRuVerbs()
    {
        try {
            File inputFile = new File(ruVerbXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("RuVerb");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String kanji = eElement.getElementsByTagName("kanji").item(0).getTextContent();
                    String hiragana = eElement.getElementsByTagName("hiragana").item(0).getTextContent();
                    String romanji = eElement.getElementsByTagName("romanji").item(0).getTextContent();
                    String meaning = eElement.getElementsByTagName("meaning").item(0).getTextContent();

                    // Create a new RuVerb object and use it as needed
                    // RuVerb ruVerb = new RuVerb(kanji, hiragana, romanji, meaning);
                    RuVerb ruVerb = new RuVerb(kanji, hiragana, romanji, meaning);
                    ruVerbs.add(ruVerb);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseUVerbs()
    {
        try {
            File inputFile = new File(uVerbXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("RuVerb");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String kanji = eElement.getElementsByTagName("kanji").item(0).getTextContent();
                    String hiragana = eElement.getElementsByTagName("hiragana").item(0).getTextContent();
                    String romanji = eElement.getElementsByTagName("romanji").item(0).getTextContent();
                    String meaning = eElement.getElementsByTagName("meaning").item(0).getTextContent();

                    // Create a new RuVerb object and use it as needed
                    // RuVerb ruVerb = new RuVerb(kanji, hiragana, romanji, meaning);
                    UVerb uVerb = new UVerb(kanji, hiragana, romanji, meaning);
                    uVerbs.add(uVerb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseIrrVerbs()
    {
        try {
            File inputFile = new File(irrVerbXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("RuVerb");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String kanji = eElement.getElementsByTagName("kanji").item(0).getTextContent();
                    String hiragana = eElement.getElementsByTagName("hiragana").item(0).getTextContent();
                    String romanji = eElement.getElementsByTagName("romanji").item(0).getTextContent();
                    String meaning = eElement.getElementsByTagName("meaning").item(0).getTextContent();

                    // Create a new RuVerb object and use it as needed
                    // RuVerb ruVerb = new RuVerb(kanji, hiragana, romanji, meaning);
                    IrrVerb irrVerb = new IrrVerb(kanji, hiragana, romanji, meaning);
                    irrVerbs.add(irrVerb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseIAdjectives()
    {
        try {
            File inputFile = new File(iAdjectiveXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("RuVerb");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String kanji = eElement.getElementsByTagName("kanji").item(0).getTextContent();
                    String hiragana = eElement.getElementsByTagName("hiragana").item(0).getTextContent();
                    String romanji = eElement.getElementsByTagName("romanji").item(0).getTextContent();
                    String meaning = eElement.getElementsByTagName("meaning").item(0).getTextContent();

                    // Create a new RuVerb object and use it as needed
                    // RuVerb ruVerb = new RuVerb(kanji, hiragana, romanji, meaning);
                    IAdjective iAdjective = new IAdjective(kanji, hiragana, romanji, meaning);
                    iAdjectives.add(iAdjective);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseNaAdjectives()
    {
        try {
            File inputFile = new File(naAdjectiveXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("RuVerb");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String kanji = eElement.getElementsByTagName("kanji").item(0).getTextContent();
                    String hiragana = eElement.getElementsByTagName("hiragana").item(0).getTextContent();
                    String romanji = eElement.getElementsByTagName("romanji").item(0).getTextContent();
                    String meaning = eElement.getElementsByTagName("meaning").item(0).getTextContent();

                    // Create a new RuVerb object and use it as needed
                    // RuVerb ruVerb = new RuVerb(kanji, hiragana, romanji, meaning);
                    NaAdjective naAdjective = new NaAdjective(kanji, hiragana, romanji, meaning);
                    naAdjectives.add(naAdjective);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        
        parseRuVerbs();
        parseUVerbs();
        parseIrrVerbs();
        parseIAdjectives();
        parseNaAdjectives();

        System.out.println("Ru Verbs");
        for (RuVerb ruVerb : ruVerbs) {
            System.out.println(ruVerb.getKanji());
        }

        System.out.println("U Verbs");
        for (UVerb uVerb : uVerbs) {
            System.out.println(uVerb.getKanji());
        }
        

        
    }
    
}
