import React from 'react';

function KatakanaKeyboard()
{
    return(

        <div className = "katakanaKeyboard">
            <button id = "aKata" className = "A kanaButton" onclick="keyboardPress('ア', 'aKata')">ア</button>
            <button id = "kaKata" className = "Ka kanaButton" onclick="keyboardPress('カ', 'kaKata')">カ</button>
            <button id = "saKata" className = "Sa kanaButton" onclick="keyboardPress('サ', 'saKata')">サ</button>
            <button id = "taKata" className = "Ta kanaButton" onclick="keyboardPress('タ', 'taKata')">タ</button>
            <button id = "naKata" className = "Na kanaButton" onclick="keyboardPress('ナ', 'naKata')">ナ</button>
            <button id = "haKata" className = "Ha kanaButton" onclick="keyboardPress('ハ', 'haKata')">ハ</button>
            <button id = "maKata" className = "Ma kanaButton" onclick="keyboardPress('マ', 'maKata')">マ</button>
            <button id = "yaKata" className = "Ya kanaButton" onclick="keyboardPress('ヤ', 'yaKata')">ヤ</button>
            <button id = "raKata" className = "Ra kanaButton" onclick="keyboardPress('ラ', 'raKata')">ラ</button>
            <button id = "waKata" className = "Wa kanaButton" onclick="keyboardPress('ワ', 'waKata')">ワ</button>
            <button id = "smallYaKata" className = "SmallYa kanaButton" onclick="keyboardPress('ャ', 'smallYaKata')">ャ</button>
            <button id = "dakutenKata" className = "Dakuten kanaButton" onclick="keyboardPress('゛', 'dakutenKata')">゛</button>
            <button id = "iKata" className = "I kanaButton" onclick="keyboardPress('イ', 'iKata')">イ</button>
            <button id = "kiKata" className = "Ki kanaButton" onclick="keyboardPress('キ', 'kiKata')">キ</button>
            <button id = "shiKata" className = "Shi kanaButton" onclick="keyboardPress('シ', 'shiKata')">シ</button>
            <button id = "chiKata" className = "Chi kanaButton" onclick="keyboardPress('チ', 'chiKata')">チ</button>
            <button id = "niKata" className = "Ni kanaButton" onclick="keyboardPress('ニ', 'niKata')">ニ</button>
            <button id = "hiKata" className = "Hi kanaButton" onclick="keyboardPress('ヒ', 'hiKata')">ヒ</button>
            <button id = "miKata" className = "Mi kanaButton" onclick="keyboardPress('ミ', 'miKata')">ミ</button>
            <button id = "riKata" className = "Ri kanaButton" onclick="keyboardPress('リ', 'riKata')">リ</button>
            <button id = "smallYuKata" className = "SmallYu kanaButton" onclick="keyboardPress('ュ', 'smallYuKata')">ュ</button>
            <button id = "handakutenKata" className = "Handakuten kanaButton" onclick="keyboardPress('゜', 'handakutenKata')">゜</button>
            <button id = "uKata" className = "U kanaButton" onclick="keyboardPress('ウ', 'uKata')">ウ</button>
            <button id = "kuKata" className = "Ku kanaButton" onclick="keyboardPress('ク', 'kuKata')">ク</button>
            <button id = "suKata" className = "Su kanaButton" onclick="keyboardPress('ス', 'suKata')">ス</button>
            <button id = "tsuKata" className = "Tsu kanaButton" onclick="keyboardPress('ツ', 'tsuKata')">ツ</button>
            <button id = "nuKata" className = "Nu kanaButton" onclick="keyboardPress('ヌ', 'nuKata')">ヌ</button>
            <button id = "fuKata" className = "Fu kanaButton" onclick="keyboardPress('フ', 'fuKata')">フ</button>
            <button id = "muKata" className = "Mu kanaButton" onclick="keyboardPress('ム', 'muKata')">ム</button>
            <button id = "yuKata" className = "Yu kanaButton" onclick="keyboardPress('ユ', 'yuKata')">ユ</button>
            <button id = "ruKata" className = "Ru kanaButton" onclick="keyboardPress('ル', 'ruKata')">ル</button>
            <button id = "woKata" className = "Wo kanaButton" onclick="keyboardPress('ヲ', 'woKata')">ヲ</button>
            <button id = "smallYoKata" className = "SmallYo kanaButton" onclick="keyboardPress('ョ', 'smallYoKata')">ョ</button>
            <button id = "eKata" className = "E kanaButton" onclick="keyboardPress('エ', 'eKata')">エ</button>
            <button id = "keKata" className = "Ke kanaButton" onclick="keyboardPress('ケ', 'keKata')">ケ</button>
            <button id = "seKata" className = "Se kanaButton" onclick="keyboardPress('セ', 'seKata')">セ</button>
            <button id = "teKata" className = "Te kanaButton" onclick="keyboardPress('テ', 'teKata')">テ</button>
            <button id = "neKata" className = "Ne kanaButton" onclick="keyboardPress('ネ', 'neKata')">ネ</button>
            <button id = "heKata" className = "He kanaButton" onclick="keyboardPress('ヘ', 'heKata')">ヘ</button>
            <button id = "meKata" className = "Me kanaButton" onclick="keyboardPress('メ', 'meKata')">メ</button>
            <button id = "reKata" className = "Re kanaButton" onclick="keyboardPress('レ', 'reKata')">レ</button>
            <button id = "oKata" className = "O kanaButton" onclick="keyboardPress('オ', 'oKata')">オ</button>
            <button id = "koKata" className = "Ko kanaButton" onclick="keyboardPress('コ', 'koKata')">コ</button>
            <button id = "soKata" className = "So kanaButton" onclick="keyboardPress('ソ', 'soKata')">ソ</button>
            <button id = "toKata" className = "To kanaButton" onclick="keyboardPress('ト', 'toKata')">ト</button>
            <button id = "noKata" className = "No kanaButton" onclick="keyboardPress('ノ', 'noKata')">ノ</button>
            <button id = "hoKata" className = "Ho kanaButton" onclick="keyboardPress('ホ', 'hoKata')">ホ</button>
            <button id = "moKata" className = "Mo kanaButton" onclick="keyboardPress('モ', 'moKata')">モ</button>
            <button id = "yoKata" className = "Yo kanaButton" onclick="keyboardPress('ヨ', 'yoKata')">ヨ</button>
            <button id = "roKata" className = "Ro kanaButton" onclick="keyboardPress('ロ', 'roKata')">ロ</button>
        </div>

    );

}

export default KatakanaKeyboard;