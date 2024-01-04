import React from 'react';

function KatakanaKeyboard()
{
    return(

        <KatakanaKeyboard className = "katakanaKeyboard">
            <button id = "aKata" class = "A" onclick="keyboardPress('ア', 'aKata')">ア</button>
            <button id = "kaKata" class = "Ka" onclick="keyboardPress('カ', 'kaKata')">カ</button>
            <button id = "saKata" class = "Sa" onclick="keyboardPress('サ', 'saKata')">サ</button>
            <button id = "taKata" class = "Ta" onclick="keyboardPress('タ', 'taKata')">タ</button>
            <button id = "naKata" class = "Na" onclick="keyboardPress('ナ', 'naKata')">ナ</button>
            <button id = "haKata" class = "Ha" onclick="keyboardPress('ハ', 'haKata')">ハ</button>
            <button id = "maKata" class = "Ma" onclick="keyboardPress('マ', 'maKata')">マ</button>
            <button id = "yaKata" class = "Ya" onclick="keyboardPress('ヤ', 'yaKata')">ヤ</button>
            <button id = "raKata" class = "Ra" onclick="keyboardPress('ラ', 'raKata')">ラ</button>
            <button id = "waKata" class = "Wa" onclick="keyboardPress('ワ', 'waKata')">ワ</button>
            <button id = "smallYaKata" class = "SmallYa" onclick="keyboardPress('ャ', 'smallYaKata')">ャ</button>
            <button id = "dakutenKata" class = "Dakuten" onclick="keyboardPress('゛', 'dakutenKata')">゛</button>
            <button id = "iKata" class = "I" onclick="keyboardPress('イ', 'iKata')">イ</button>
            <button id = "kiKata" class = "Ki" onclick="keyboardPress('キ', 'kiKata')">キ</button>
            <button id = "shiKata" class = "Shi" onclick="keyboardPress('シ', 'shiKata')">シ</button>
            <button id = "chiKata" class = "Chi" onclick="keyboardPress('チ', 'chiKata')">チ</button>
            <button id = "niKata" class = "Ni" onclick="keyboardPress('ニ', 'niKata')">ニ</button>
            <button id = "hiKata" class = "Hi" onclick="keyboardPress('ヒ', 'hiKata')">ヒ</button>
            <button id = "miKata" class = "Mi" onclick="keyboardPress('ミ', 'miKata')">ミ</button>
            <button id = "riKata" class = "Ri" onclick="keyboardPress('リ', 'riKata')">リ</button>
            <button id = "smallYuKata" class = "SmallYu" onclick="keyboardPress('ュ', 'smallYuKata')">ュ</button>
            <button id = "handakutenKata" class = "Handakuten" onclick="keyboardPress('゜', 'handakutenKata')">゜</button>
            <button id = "uKata" class = "U" onclick="keyboardPress('ウ', 'uKata')">ウ</button>
            <button id = "kuKata" class = "Ku" onclick="keyboardPress('ク', 'kuKata')">ク</button>
            <button id = "suKata" class = "Su" onclick="keyboardPress('ス', 'suKata')">ス</button>
            <button id = "tsuKata" class = "Tsu" onclick="keyboardPress('ツ', 'tsuKata')">ツ</button>
            <button id = "nuKata" class = "Nu" onclick="keyboardPress('ヌ', 'nuKata')">ヌ</button>
            <button id = "fuKata" class = "Fu" onclick="keyboardPress('フ', 'fuKata')">フ</button>
            <button id = "muKata" class = "Mu" onclick="keyboardPress('ム', 'muKata')">ム</button>
            <button id = "yuKata" class = "Yu" onclick="keyboardPress('ユ', 'yuKata')">ユ</button>
            <button id = "ruKata" class = "Ru" onclick="keyboardPress('ル', 'ruKata')">ル</button>
            <button id = "woKata" class = "Wo" onclick="keyboardPress('ヲ', 'woKata')">ヲ</button>
            <button id = "smallYoKata" class = "SmallYo" onclick="keyboardPress('ョ', 'smallYoKata')">ョ</button>
            <button id = "eKata" class = "E" onclick="keyboardPress('エ', 'eKata')">エ</button>
            <button id = "keKata" class = "Ke" onclick="keyboardPress('ケ', 'keKata')">ケ</button>
            <button id = "seKata" class = "Se" onclick="keyboardPress('セ', 'seKata')">セ</button>
            <button id = "teKata" class = "Te" onclick="keyboardPress('テ', 'teKata')">テ</button>
            <button id = "neKata" class = "Ne" onclick="keyboardPress('ネ', 'neKata')">ネ</button>
            <button id = "heKata" class = "He" onclick="keyboardPress('ヘ', 'heKata')">ヘ</button>
            <button id = "meKata" class = "Me" onclick="keyboardPress('メ', 'meKata')">メ</button>
            <button id = "reKata" class = "Re" onclick="keyboardPress('レ', 'reKata')">レ</button>
            <button id = "oKata" class = "O" onclick="keyboardPress('オ', 'oKata')">オ</button>
            <button id = "koKata" class = "Ko" onclick="keyboardPress('コ', 'koKata')">コ</button>
            <button id = "soKata" class = "So" onclick="keyboardPress('ソ', 'soKata')">ソ</button>
            <button id = "toKata" class = "To" onclick="keyboardPress('ト', 'toKata')">ト</button>
            <button id = "noKata" class = "No" onclick="keyboardPress('ノ', 'noKata')">ノ</button>
            <button id = "hoKata" class = "Ho" onclick="keyboardPress('ホ', 'hoKata')">ホ</button>
            <button id = "moKata" class = "Mo" onclick="keyboardPress('モ', 'moKata')">モ</button>
            <button id = "yoKata" class = "Yo" onclick="keyboardPress('ヨ', 'yoKata')">ヨ</button>
            <button id = "roKata" class = "Ro" onclick="keyboardPress('ロ', 'roKata')">ロ</button>
        </KatakanaKeyboard>
    );

}

export default KatakanaKeyboard;