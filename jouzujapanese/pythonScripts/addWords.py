import xml.etree.ElementTree as ET
import os
import sys

current_dir = os.path.dirname(os.path.abspath(__file__))
parent_dir = os.path.dirname(current_dir)

ruVerbXML = parent_dir + os.sep + 'src' + os.sep + 'main' + os.sep + 'java' + os.sep + 'com' + os.sep + 'chasepacker' + os.sep + 'Words' + os.sep + 'ruVerbs.xml'
uVerbXML = parent_dir + os.sep + 'src' + os.sep + 'main' + os.sep + 'java' + os.sep + 'com' + os.sep + 'chasepacker' + os.sep + 'Words' + os.sep + 'uVerbs.xml'
irrVerbXML = parent_dir + os.sep + 'src' + os.sep + 'main' + os.sep + 'java' + os.sep + 'com' + os.sep + 'chasepacker' + os.sep + 'Words' + os.sep + 'irrVerbs.xml'
iAdjectiveXML = parent_dir + os.sep + 'src' + os.sep + 'main' + os.sep + 'java' + os.sep + 'com' + os.sep + 'chasepacker' + os.sep + 'Words' + os.sep + 'iAdjectives.xml'
naAdjectiveXML = parent_dir + os.sep + 'src' + os.sep + 'main' + os.sep + 'java' + os.sep + 'com' + os.sep + 'chasepacker' + os.sep + 'Words' + os.sep + 'naAdjectives.xml'


def add_ruVerb(kanji, hiragana, romanji, meaning):
    tree = ET.parse(ruVerbXML)
    root = tree.getroot()

    ruverb = ET.SubElement(root, 'RuVerb')

    kanji_elem = ET.SubElement(ruverb, 'kanji')
    kanji_elem.text = kanji

    hiragana_elem = ET.SubElement(ruverb, 'hiragana')
    hiragana_elem.text = hiragana

    romanji_elem = ET.SubElement(ruverb, 'romanji')
    romanji_elem.text = romanji

    meaning_elem = ET.SubElement(ruverb, 'meaning')
    meaning_elem.text = meaning

    tree.write(ruVerbXML, encoding='utf-8')


def add_uVerb(kanji, hiragana, romanji, meaning):
    tree = ET.parse(uVerbXML)
    root = tree.getroot()

    uverb = ET.SubElement(root, 'UVerb')

    kanji_elem = ET.SubElement(uverb, 'kanji')
    kanji_elem.text = kanji

    hiragana_elem = ET.SubElement(uverb, 'hiragana')
    hiragana_elem.text = hiragana

    romanji_elem = ET.SubElement(uverb, 'romanji')
    romanji_elem.text = romanji

    meaning_elem = ET.SubElement(uverb, 'meaning')
    meaning_elem.text = meaning

    tree.write(uVerbXML, encoding='utf-8')

def add_irrVerb(kanji, hiragana, romanji, meaning):
    tree = ET.parse(irrVerbXML)
    root = tree.getroot()

    irrverb = ET.SubElement(root, 'IrrVerb')

    kanji_elem = ET.SubElement(irrverb, 'kanji')
    kanji_elem.text = kanji

    hiragana_elem = ET.SubElement(irrverb, 'hiragana')
    hiragana_elem.text = hiragana

    romanji_elem = ET.SubElement(irrverb, 'romanji')
    romanji_elem.text = romanji

    meaning_elem = ET.SubElement(irrverb, 'meaning')
    meaning_elem.text = meaning

    tree.write(irrVerbXML, encoding='utf-8')

def add_iAdjective(kanji, hiragana, romanji, meaning):
    tree = ET.parse(iAdjectiveXML)
    root = tree.getroot()

    iadjective = ET.SubElement(root, 'IAdjective')

    kanji_elem = ET.SubElement(iadjective, 'kanji')
    kanji_elem.text = kanji

    hiragana_elem = ET.SubElement(iadjective, 'hiragana')
    hiragana_elem.text = hiragana

    romanji_elem = ET.SubElement(iadjective, 'romanji')
    romanji_elem.text = romanji

    meaning_elem = ET.SubElement(iadjective, 'meaning')
    meaning_elem.text = meaning

    tree.write(iAdjectiveXML, encoding='utf-8')

def add_naAdjective(kanji, hiragana, romanji, meaning):
    tree = ET.parse(naAdjectiveXML)
    root = tree.getroot()

    naadjective = ET.SubElement(root, 'NaAdjective')

    kanji_elem = ET.SubElement(naadjective, 'kanji')
    kanji_elem.text = kanji

    hiragana_elem = ET.SubElement(naadjective, 'hiragana')
    hiragana_elem.text = hiragana

    romanji_elem = ET.SubElement(naadjective, 'romanji')
    romanji_elem.text = romanji

    meaning_elem = ET.SubElement(naadjective, 'meaning')
    meaning_elem.text = meaning

    tree.write(naAdjectiveXML, encoding='utf-8')


def main():

    while True:

        type = input('Enter type of word (ruVerb, uVerb, irrVerb, iAdjective, naAdjective): ')

        type = type.lower()

        if type == 'exit':
            sys.exit()
        elif type == 'ruverb':
            kanji = input('Enter kanji: ')
            hiragana = input('Enter hiragana: ')
            romanji = input('Enter romanji: ')
            meaning = input('Enter meaning: ')
            add_ruVerb(kanji, hiragana, romanji, meaning)
        elif type == 'uverb':
            kanji = input('Enter kanji: ')
            hiragana = input('Enter hiragana: ')
            romanji = input('Enter romanji: ')
            meaning = input('Enter meaning: ')
            add_uVerb(kanji, hiragana, romanji, meaning)
        elif type == 'irrverb':
            kanji = input('Enter kanji: ')
            hiragana = input('Enter hiragana: ')
            romanji = input('Enter romanji: ')
            meaning = input('Enter meaning: ')
            add_irrVerb(kanji, hiragana, romanji, meaning)
        elif type == 'iadjective':
            kanji = input('Enter kanji: ')
            hiragana = input('Enter hiragana: ')
            romanji = input('Enter romanji: ')
            meaning = input('Enter meaning: ')
            add_iAdjective(kanji, hiragana, romanji, meaning)
        elif type == 'naadjective':
            kanji = input('Enter kanji: ')
            hiragana = input('Enter hiragana: ')
            romanji = input('Enter romanji: ')
            meaning = input('Enter meaning: ')
            add_naAdjective(kanji, hiragana, romanji, meaning)
        else:
            print('Invalid type')
        


if __name__ == '__main__':
    main()