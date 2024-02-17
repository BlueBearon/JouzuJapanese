/**
 * @fileoverview This file contains the KatakanaKeyboard component which is used to display the katakana keyboard
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2021
 */

import React, {useRef} from 'react';
import Key from "./Key.js";
import "./css/Keyboard.css";

//Dakuten and handakuten conversions
var dakutenConversions = {
    "か": "が",
    "き": "ぎ",
    "く": "ぐ",
    "け": "げ",
    "こ": "ご",
    "さ": "ざ",
    "し": "じ",
    "す": "ず",
    "せ": "ぜ",
    "そ": "ぞ",
    "た": "だ",
    "ち": "ぢ",
    "つ": "づ",
    "て": "で",
    "と": "ど",
    "は": "ば",
    "ひ": "び",
    "ふ": "ぶ",
    "へ": "べ",
    "ほ": "ぼ",
    "カ": "ガ",
    "キ": "ギ",
    "ク": "グ",
    "ケ": "ゲ",
    "コ": "ゴ",
    "サ": "ザ",
    "シ": "ジ",
    "ス": "ズ",
    "セ": "ゼ",
    "ソ": "ゾ",
    "タ": "ダ",
    "チ": "ヂ",
    "ツ": "ヅ",
    "テ": "デ",
    "ト": "ド",
    "ハ": "バ",
    "ヒ": "ビ",
    "フ":"ブ",
    "ㇸ":"ベ",
    "ホ":"ボ"
};

var handakutenConversions = {
    "は": "ぱ",
    "ひ": "ぴ",
    "ふ": "ぷ",
    "へ": "ぺ",
    "ほ": "ぽ",
    "ハ": "パ",
    "ヒ": "ピ",
    "フ": "プ",
    "ㇸ": "ペ",
    "ホ": "ポ"
};

/**
 * Returns the katakana keyboard
 * 
 * Contains all 46 regular katakana characters, as well as the dakuten and handakuten characters and the small ya, yu, and yo characters
 * 
 * @returns {HTMLDivElement} The katakana keyboard
 */
function KatakanaKeyboard(props)
{

    console.log("Rendering KatakanaKeyboard");

    const userInput = useRef("");

    /**
     * Updates the user's input, and calls the parent's keyboardPress function
     * @param {*} kana: the kana that was pressed
     * @returns true or false to indicate whether the button press was valid and the button color should change
     */
    function keyboardPress(kana) {
        // Toggle the pressed state of the button

        var result;


        if(kana === '゛')//If the dakuten button is pressed
        {   
            if(userInput.current.length == 0)//If there is no previous kana, do nothing and return false
            {
                console.log("KatakanaKeyboard.js: dakuten pressed with no previous kana");
                return false;
            }

            if(dakutenConversions[userInput.current[userInput.current.length - 1]] === undefined)//If the previous kana is not compatible with dakuten, do nothing and return false
            {
                console.log("KatakanaKeyboard.js: dakuten pressed with no compatible previous kana");
                return false;
            }

            //Otherwise, convert the previous kana to the dakuten version, update the user's input, call the parent's keyboardPress function, and return true
            result = userInput.current.substring(0, userInput.current.length - 1) + dakutenConversions[userInput.current[userInput.current.length - 1]];
            userInput.current = result;
            props.keyboardPress(result);
            console.log("Keyboard User Input: " + result);
            return true;
        }
        else if(kana === '゜')
        {
            if(userInput.current.length == 0)//If there is no previous kana, do nothing and return false
            {
                console.log("KatakanaKeyboard.js: handakuten pressed with no previous kana");
                return false;
            }

            if(handakutenConversions[userInput.current[userInput.current.length - 1]] === undefined)//If the previous kana is not compatible with handakuten, do nothing and return false
            {
                console.log("KatakanaKeyboard.js: handakuten pressed with no compatible previous kana");
                return false;
            }

            //Otherwise, convert the previous kana to the handakuten version, update the user's input, call the parent's keyboardPress function, and return true
            result = userInput.current.substring(0, userInput.current.length - 1) + handakutenConversions[userInput.current[userInput.current.length - 1]];
            userInput.current = result;
            props.keyboardPress(result);
            console.log("Keyboard User Input: " + result);
            return true;
        }
        else
        {
            if(userInput.current.length > 1)//If the user has already selected their answer, do nothing and return false
            {
                console.log("KatakanaKeyboard.js: User has already selected their answer");
                return false;
            }

            if(userInput.current.length == 1)//If the user has selected one kana, check if it is a small ya, yu, or yo character
            {
                if(userInput.current[0] !== 'ャ' || userInput.current[0] !== 'ュ' || userInput.current[0] !== 'ョ')//If it is not a small ya, yu, or yo character, do nothing and return false
                {
                    console.log("KatakanaKeyboard.js: User has already selected their answer");
                    return false;
                }
            }

            //Otherwise, update the user's input, call the parent's keyboardPress function, and return true
            userInput.current = userInput.current + kana;
            props.keyboardPress(userInput.current);
            console.log("Keyboard User Input: " + userInput.current);
            return true;
        }
    }

    return(//A key for each kana, provide css information and the keyboardPress function

        <div className="katakanaKeyboard">
            <Key kana="ア" roma="A" updateUserInput={keyboardPress} />
            <Key kana="カ" roma="Ka" updateUserInput={keyboardPress} />
            <Key kana="サ" roma="Sa" updateUserInput={keyboardPress} />
            <Key kana="タ" roma="Ta" updateUserInput={keyboardPress} />
            <Key kana="ナ" roma="Na" updateUserInput={keyboardPress} />
            <Key kana="ハ" roma="Ha" updateUserInput={keyboardPress} />
            <Key kana="マ" roma="Ma" updateUserInput={keyboardPress} />
            <Key kana="ヤ" roma="Ya" updateUserInput={keyboardPress} />
            <Key kana="ラ" roma="Ra" updateUserInput={keyboardPress} />
            <Key kana="ワ" roma="Wa" updateUserInput={keyboardPress} />
            <Key kana="ャ" roma="SmallYa" updateUserInput={keyboardPress} />
            <Key kana="゛" roma="dakuten" updateUserInput={keyboardPress} />
            <Key kana="イ" roma="I" updateUserInput={keyboardPress} />
            <Key kana="キ" roma="Ki" updateUserInput={keyboardPress} />
            <Key kana="シ" roma="Shi" updateUserInput={keyboardPress} />
            <Key kana="チ" roma="Chi" updateUserInput={keyboardPress} />
            <Key kana="ニ" roma="Ni" updateUserInput={keyboardPress} />
            <Key kana="ヒ" roma="Hi" updateUserInput={keyboardPress} />
            <Key kana="ミ" roma="Mi" updateUserInput={keyboardPress} />
            <Key kana="リ" roma="Ri" updateUserInput={keyboardPress} />
            <Key kana="ュ" roma="smallYu" updateUserInput={keyboardPress} />
            <Key kana="゜" roma="handakuten" updateUserInput={keyboardPress} />
            <Key kana="ウ" roma="U" updateUserInput={keyboardPress} />
            <Key kana="ク" roma="Ku" updateUserInput={keyboardPress} />
            <Key kana="ス" roma="Su" updateUserInput={keyboardPress} />
            <Key kana="ツ" roma="Tsu" updateUserInput={keyboardPress} />
            <Key kana="ヌ" roma="Nu" updateUserInput={keyboardPress} />
            <Key kana="フ" roma="Fu" updateUserInput={keyboardPress} />
            <Key kana="ム" roma="Mu" updateUserInput={keyboardPress} />
            <Key kana="ユ" roma="Yu" updateUserInput={keyboardPress} />
            <Key kana="ル" roma="Ru" updateUserInput={keyboardPress} />
            <Key kana="ヲ" roma="Wo" updateUserInput={keyboardPress} />
            <Key kana="ョ" roma="smallYo" updateUserInput={keyboardPress} />
            <Key kana="エ" roma="E" updateUserInput={keyboardPress} />
            <Key kana="ケ" roma="Ke" updateUserInput={keyboardPress} />
            <Key kana="セ" roma="Se" updateUserInput={keyboardPress} />
            <Key kana="テ" roma="Te" updateUserInput={keyboardPress} />
            <Key kana="ネ" roma="Ne" updateUserInput={keyboardPress} />
            <Key kana="ヘ" roma="He" updateUserInput={keyboardPress} />
            <Key kana="メ" roma="Me" updateUserInput={keyboardPress} />
            <Key kana="レ" roma="Re" updateUserInput={keyboardPress} />
            <Key kana="オ" roma="O" updateUserInput={keyboardPress} />
            <Key kana="コ" roma="Ko" updateUserInput={keyboardPress} />
            <Key kana="ソ" roma="So" updateUserInput={keyboardPress} />
            <Key kana="ト" roma="To" updateUserInput={keyboardPress} />
            <Key kana="ノ" roma="No" updateUserInput={keyboardPress} />
            <Key kana="ホ" roma="Ho" updateUserInput={keyboardPress} />
            <Key kana="モ" roma="Mo" updateUserInput={keyboardPress} />
            <Key kana="ヨ" roma="Yo" updateUserInput={keyboardPress} />
            <Key kana="ロ" roma="Ro" updateUserInput={keyboardPress} />
            <Key kana="ン" roma="N" updateUserInput={keyboardPress} />
        </div>

    );

}

export default KatakanaKeyboard;