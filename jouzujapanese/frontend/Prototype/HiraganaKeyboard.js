import React from "react";

function HiraganaKeyboard()
{
    return(

        <HiraganaKeyboard className = "hiraganaKeyboard">
            <button id = "aHira" class = "A" onclick="keyboardPress('あ', 'aHira')">あ</button>
            <button id = "kaHira" class = "Ka" onclick="keyboardPress('か', 'kaHira')">か</button>
            <button id = "saHira" class = "Sa" onclick="keyboardPress('さ', 'saHira')">さ</button>
            <button id = "taHira" class = "Ta" onclick="keyboardPress('た', 'taHira')">た</button>
            <button id = "naHira" class = "Na" onclick="keyboardPress('な', 'naHira')">な</button>
            <button id = "haHira" class = "Ha" onclick="keyboardPress('は', 'haHira')">は</button>
            <button id = "maHira" class = "Ma" onclick="keyboardPress('ま', 'maHira')">ま</button>
            <button id = "yaHira" class = "Ya" onclick="keyboardPress('や', 'yaHira')">や</button>
            <button id = "raHira" class = "Ra" onclick="keyboardPress('ら', 'raHira')">ら</button>
            <button id = "waHira" class = "Wa" onclick="keyboardPress('わ', 'waHira')">わ</button>
            <button id = "smallYaHira" class = "SmallYa" onclick="keyboardPress('ゃ', 'smallYaHira')">ゃ</button>
            <button id = "dakutenHira" class = "Dakuten" onclick="keyboardPress('゛', 'dakutenHira')">゛</button>
            <button id = "iHira" class = "I" onclick="keyboardPress('い', 'iHira')">い</button>
            <button id = "kiHira" class = "Ki" onclick="keyboardPress('き', 'kiHira')">き</button>
            <button id = "shiHira" class = "Shi" onclick="keyboardPress('し', 'shiHira')">し</button>
            <button id = "chiHira" class = "Chi" onclick="keyboardPress('ち', 'chiHira')">ち</button>
            <button id = "niHira" class = "Ni" onclick="keyboardPress('に', 'niHira')">に</button>
            <button id = "hiHira" class = "Hi" onclick="keyboardPress('ひ', 'hiHira')">ひ</button>
            <button id = "miHira" class = "Mi" onclick="keyboardPress('み', 'miHira')">み</button>
            <button id = "riHira" class = "Ri" onclick="keyboardPress('り', 'riHira')">り</button>
            <button id = "smallYuHira" class = "SmallYu" onclick="keyboardPress('ゅ', 'smallYuHira')">ゅ</button>
            <button id = "handakutenHira" class = "Handakuten" onclick="keyboardPress('゜', 'handakutenHira')">゜</button>
            <button id = "uHira" class = "U" onclick="keyboardPress('う', 'uHira')">う</button>
            <button id = "kuHira" class = "Ku" onclick="keyboardPress('く', 'kuHira')">く</button>
            <button id = "suHira" class = "Su" onclick="keyboardPress('す', 'suHira')">す</button>
            <button id = "tsuHira" class = "Tsu" onclick="keyboardPress('つ', 'tsuHira')">つ</button>
            <button id = "nuHira" class = "Nu" onclick="keyboardPress('ぬ', 'nuHira')">ぬ</button>
            <button id = "fuHira" class = "Fu" onclick="keyboardPress('ふ', 'fuHira')">ふ</button>
            <button id = "muHira" class = "Mu" onclick="keyboardPress('む', 'muHira')">む</button>
            <button id = "yuHira" class = "Yu" onclick="keyboardPress('ゆ', 'yuHira')">ゆ</button>
            <button id = "ruHira" class = "Ru" onclick="keyboardPress('る', 'ruHira')">る</button>
            <button id = "woHira" class = "Wo" onclick="keyboardPress('を', 'woHira')">を</button>
            <button id = "smallYoHira" class = "SmallYo" onclick="keyboardPress('ょ', 'smallYoHira')">ょ</button>
            <button id = "eHira" class = "E" onclick="keyboardPress('え', 'eHira')">え</button>
            <button id = "keHira" class = "Ke" onclick="keyboardPress('け', 'keHira')">け</button>
            <button id = "seHira" class = "Se" onclick="keyboardPress('せ', 'seHira')">せ</button>
            <button id = "teHira" class = "Te" onclick="keyboardPress('て', 'teHira')">て</button>
            <button id = "neHira" class = "Ne" onclick="keyboardPress('ね', 'neHira')">ね</button>
            <button id = "heHira" class = "He" onclick="keyboardPress('へ', 'heHira')">へ</button>
            <button id = "meHira" class = "Me" onclick="keyboardPress('め', 'meHira')">め</button>
            <button id = "reHira" class = "Re" onclick="keyboardPress('れ', 'reHira')">れ</button>
            <button id = "oHira" class = "O" onclick="keyboardPress('お', 'oHira')">お</button>
            <button id = "koHira" class = "Ko" onclick="keyboardPress('こ', 'koHira')">こ</button>
            <button id = "soHira" class = "So" onclick="keyboardPress('そ', 'soHira')">そ</button>
            <button id = "toHira" class = "To" onclick="keyboardPress('と', 'toHira')">と</button>
            <button id = "noHira" class = "No" onclick="keyboardPress('の', 'noHira')">の</button>
            <button id = "hoHira" class = "Ho" onclick="keyboardPress('ほ', 'hoHira')">ほ</button>
            <button id = "moHira" class = "Mo" onclick="keyboardPress('も', 'moHira')">も</button>
            <button id = "yoHira" class = "Yo" onclick="keyboardPress('よ', 'yoHira')">よ</button>
            <button id = "roHira" class = "Ro" onclick="keyboardPress('ろ', 'roHira')">ろ</button>
        

        </HiraganaKeyboard>

    );
}

export default HiraganaKeyboard;

