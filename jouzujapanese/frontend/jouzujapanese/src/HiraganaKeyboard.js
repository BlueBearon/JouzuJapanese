import React, {useRef } from "react";
import Key from "./Key.js";
import "./Keyboard.css";


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





function HiraganaKeyboard(props) {

    console.log("Rendering HiraganaKeyboard");

    const userInput = useRef("");


    function keyboardPress(kana) {
        // Toggle the pressed state of the button

        var result;


        if(kana === '゛')
        {
            if(userInput.current.length == 0)
            {
                console.log("HiraganaKeyboard.js: dakuten pressed with no previous kana");
                return false;
            }

            if(dakutenConversions[userInput.current[userInput.current.length - 1]] === undefined)
            {
                console.log("HiraganaKeyboard.js: dakuten pressed with no compatible previous kana");
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
                console.log("HiraganaKeyboard.js: handakuten pressed with no previous kana");
                return false;
            }

            if(handakutenConversions[userInput.current[userInput.current.length - 1]] === undefined)
            {
                console.log("HiraganaKeyboard.js: handakuten pressed with no compatible previous kana");
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
                console.log("HiraganaKeyboard.js: User has already selected their answer");
                return false;
            }

            if(userInput.current.length == 1)
            {
                if(kana !== "ゃ" && kana !== "ゅ" && kana !== "ょ" && kana !== "゛" && kana !== "゜")
                {
                    console.log("HiraganaKeyboard.js: User has already selected their answer");
                    return false;
                }
            }

            userInput.current = userInput.current + kana;
            props.keyboardPress(userInput.current);
            console.log("Keyboard User Input: " + userInput.current);
            return true;
        }
    }

    return (
        <div className="hiraganaKeyboard">
            <Key kana="あ" roma="A" updateUserInput={keyboardPress} />
            <Key kana="か" roma="Ka" updateUserInput={keyboardPress} />
            <Key kana="さ" roma="Sa" updateUserInput={keyboardPress} />
            <Key kana="た" roma="Ta" updateUserInput={keyboardPress} />
            <Key kana="な" roma="Na" updateUserInput={keyboardPress} />
            <Key kana="は" roma="Ha" updateUserInput={keyboardPress} />
            <Key kana="ま" roma="Ma" updateUserInput={keyboardPress} />
            <Key kana="や" roma="Ya" updateUserInput={keyboardPress} />
            <Key kana="ら" roma="Ra" updateUserInput={keyboardPress} />
            <Key kana="わ" roma="Wa" updateUserInput={keyboardPress} />
            <Key kana="ゃ" roma="smallYa" updateUserInput={keyboardPress} />
            <Key kana="゛" roma="dakuten" updateUserInput={keyboardPress} />
            <Key kana="い" roma="I" updateUserInput={keyboardPress} />
            <Key kana="き" roma="Ki" updateUserInput={keyboardPress} />
            <Key kana="し" roma="Shi" updateUserInput={keyboardPress} />
            <Key kana="ち" roma="Chi" updateUserInput={keyboardPress} />
            <Key kana="に" roma="Ni" updateUserInput={keyboardPress} />
            <Key kana="ひ" roma="Hi" updateUserInput={keyboardPress} />
            <Key kana="み" roma="Mi" updateUserInput={keyboardPress} />
            <Key kana="り" roma="Ri" updateUserInput={keyboardPress} />
            <Key kana="ゅ" roma="smallYu" updateUserInput={keyboardPress} />
            <Key kana="゜" roma="handakuten" updateUserInput={keyboardPress} />
            <Key kana="う" roma="U" updateUserInput={keyboardPress} />
            <Key kana="く" roma="Ku" updateUserInput={keyboardPress} />
            <Key kana="す" roma="Su" updateUserInput={keyboardPress} />
            <Key kana="つ" roma="Tsu" updateUserInput={keyboardPress} />
            <Key kana="ぬ" roma="Nu" updateUserInput={keyboardPress} />
            <Key kana="ふ" roma="Fu" updateUserInput={keyboardPress} />
            <Key kana="む" roma="Mu" updateUserInput={keyboardPress} />
            <Key kana="ゆ" roma="Yu" updateUserInput={keyboardPress} />
            <Key kana="る" roma="Ru" updateUserInput={keyboardPress} />
            <Key kana="を" roma="Wo" updateUserInput={keyboardPress} />
            <Key kana="ょ" roma="smallYo" updateUserInput={keyboardPress} />
            <Key kana="え" roma="E" updateUserInput={keyboardPress} />
            <Key kana="け" roma="Ke" updateUserInput={keyboardPress} />
            <Key kana="せ" roma="Se" updateUserInput={keyboardPress} />
            <Key kana="て" roma="Te" updateUserInput={keyboardPress} />
            <Key kana="ね" roma="Ne" updateUserInput={keyboardPress} />
            <Key kana="へ" roma="He" updateUserInput={keyboardPress} />
            <Key kana="め" roma="Me" updateUserInput={keyboardPress} />
            <Key kana="れ" roma="Re" updateUserInput={keyboardPress} />
            <Key kana="お" roma="O" updateUserInput={keyboardPress} />
            <Key kana="こ" roma="Ko" updateUserInput={keyboardPress} />
            <Key kana="そ" roma="So" updateUserInput={keyboardPress} />
            <Key kana="と" roma="To" updateUserInput={keyboardPress} />
            <Key kana="の" roma="No" updateUserInput={keyboardPress} />
            <Key kana="ほ" roma="Ho" updateUserInput={keyboardPress} />
            <Key kana="も" roma="Mo" updateUserInput={keyboardPress} />
            <Key kana="よ" roma="Yo" updateUserInput={keyboardPress} />
            <Key kana="ろ" roma="Ro" updateUserInput={keyboardPress} />
            <Key kana="ん" roma="N" updateUserInput={keyboardPress} />
        </div>
    );
}

export default HiraganaKeyboard;



