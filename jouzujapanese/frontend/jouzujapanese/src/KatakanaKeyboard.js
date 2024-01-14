import React, {useRef} from 'react';
import Key from "./Key.js";

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


    function keyboardPress(kana) {
        // Toggle the pressed state of the button

        var result;


        if(kana === '゛')
        {
            if(userInput.current.length == 0)
            {
                console.log("KatakanaKeyboard.js: dakuten pressed with no previous kana");
                return false;
            }

            if(dakutenConversions[userInput.current[userInput.current.length - 1]] === undefined)
            {
                console.log("KatakanaKeyboard.js: dakuten pressed with no compatible previous kana");
                return false;
            }

            result = userInput.current.substring(0, userInput.current.length - 1) + dakutenConversions[userInput.current[userInput.current.length - 1]];
            userInput.current = result;
            props.keyboardPress(result);
            console.log("Keyboard User Input: " + result);
            return true;
        }
        else if(kana === '゜')
        {
            if(userInput.current.length == 0)
            {
                console.log("KatakanaKeyboard.js: handakuten pressed with no previous kana");
                return false;
            }

            if(handakutenConversions[userInput.current[userInput.current.length - 1]] === undefined)
            {
                console.log("KatakanaKeyboard.js: handakuten pressed with no compatible previous kana");
                return false;
            }
            result = userInput.current.substring(0, userInput.current.length - 1) + handakutenConversions[userInput.current[userInput.current.length - 1]];
            userInput.current = result;
            props.keyboardPress(result);
            console.log("Keyboard User Input: " + result);
            return true;
        }
        else
        {
            if(userInput.current.length > 1)
            {
                console.log("KatakanaKeyboard.js: User has already selected their answer");
                return false;
            }

            if(userInput.current.length == 1)
            {
                if(userInput.current[0] === 'ャ' || userInput.current[0] === 'ュ' || userInput.current[0] === 'ョ')
                {
                    console.log("KatakanaKeyboard.js: User has already selected their answer");
                    return false;
                }
            }

            userInput.current = userInput.current + kana;
            props.keyboardPress(userInput.current);
            console.log("Keyboard User Input: " + userInput.current);
            return true;
        }
    }

    return(

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