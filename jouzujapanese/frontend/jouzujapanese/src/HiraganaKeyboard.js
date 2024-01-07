import React from "react";

function HiraganaKeyboard()
{
    return(

        <div className = "hiraganaKeyboard">
            <button id = "aHira" className = "A kanaButton" onclick="keyboardPress('あ', 'aHira')">あ</button>
            <button id = "kaHira" className = "Ka kanaButton" onclick="keyboardPress('か', 'kaHira')">か</button>
            <button id = "saHira" className = "Sa kanaButton" onclick="keyboardPress('さ', 'saHira')">さ</button>
            <button id = "taHira" className = "Ta kanaButton" onclick="keyboardPress('た', 'taHira')">た</button>
            <button id = "naHira" className = "Na kanaButton" onclick="keyboardPress('な', 'naHira')">な</button>
            <button id = "haHira" className = "Ha kanaButton" onclick="keyboardPress('は', 'haHira')">は</button>
            <button id = "maHira" className = "Ma kanaButton" onclick="keyboardPress('ま', 'maHira')">ま</button>
            <button id = "yaHira" className = "Ya kanaButton" onclick="keyboardPress('や', 'yaHira')">や</button>
            <button id = "raHira" className = "Ra kanaButton" onclick="keyboardPress('ら', 'raHira')">ら</button>
            <button id = "waHira" className = "Wa kanaButton" onclick="keyboardPress('わ', 'waHira')">わ</button>
            <button id = "smallYaHira" className = "smallYa kanaButton" onclick="keyboardPress('ゃ', 'smallYaHira')">ゃ</button>
            <button id = "dakutenHira" className = "dakuten kanaButton" onclick="keyboardPress('゛', 'dakutenHira')">゛</button>
            <button id = "iHira" className = "I kanaButton" onclick="keyboardPress('い', 'iHira')">い</button>
            <button id = "kiHira" className = "Ki kanaButton" onclick="keyboardPress('き', 'kiHira')">き</button>
            <button id = "shiHira" className = "Shi kanaButton" onclick="keyboardPress('し', 'shiHira')">し</button>
            <button id = "chiHira" className = "Chi kanaButton" onclick="keyboardPress('ち', 'chiHira')">ち</button>
            <button id = "niHira" className = "Ni kanaButton" onclick="keyboardPress('に', 'niHira')">に</button>
            <button id = "hiHira" className = "Hi kanaButton" onclick="keyboardPress('ひ', 'hiHira')">ひ</button>
            <button id = "miHira" className = "Mi kanaButton" onclick="keyboardPress('み', 'miHira')">み</button>
            <button id = "riHira" className = "Ri kanaButton" onclick="keyboardPress('り', 'riHira')">り</button>
            <button id = "smallYuHira" className = "smallYu kanaButton" onclick="keyboardPress('ゅ', 'smallYuHira')">ゅ</button>
            <button id = "handakutenHira" className = "handakuten kanaButton" onclick="keyboardPress('゜', 'handakutenHira')">゜</button>
            <button id = "uHira" className = "U kanaButton" onclick="keyboardPress('う', 'uHira')">う</button>
            <button id = "kuHira" className = "Ku kanaButton" onclick="keyboardPress('く', 'kuHira')">く</button>
            <button id = "suHira" className = "Su kanaButton" onclick="keyboardPress('す', 'suHira')">す</button>
            <button id = "tsuHira" className = "Tsu kanaButton" onclick="keyboardPress('つ', 'tsuHira')">つ</button>
            <button id = "nuHira" className = "Nu kanaButton" onclick="keyboardPress('ぬ', 'nuHira')">ぬ</button>
            <button id = "fuHira" className = "Fu kanaButton" onclick="keyboardPress('ふ', 'fuHira')">ふ</button>
            <button id = "muHira" className = "Mu kanaButton" onclick="keyboardPress('む', 'muHira')">む</button>
            <button id = "yuHira" className = "Yu kanaButton" onclick="keyboardPress('ゆ', 'yuHira')">ゆ</button>
            <button id = "ruHira" className = "Ru kanaButton" onclick="keyboardPress('る', 'ruHira')">る</button>
            <button id = "woHira" className = "Wo kanaButton" onclick="keyboardPress('を', 'woHira')">を</button>
            <button id = "smallYoHira" className = "smallYo kanaButton" onclick="keyboardPress('ょ', 'smallYoHira')">ょ</button>
            <button id = "eHira" className = "E kanaButton" onclick="keyboardPress('え', 'eHira')">え</button>
            <button id = "keHira" className = "Ke kanaButton" onclick="keyboardPress('け', 'keHira')">け</button>
            <button id = "seHira" className = "Se kanaButton" onclick="keyboardPress('せ', 'seHira')">せ</button>
            <button id = "teHira" className = "Te kanaButton" onclick="keyboardPress('て', 'teHira')">て</button>
            <button id = "neHira" className = "Ne kanaButton" onclick="keyboardPress('ね', 'neHira')">ね</button>
            <button id = "heHira" className = "He kanaButton" onclick="keyboardPress('へ', 'heHira')">へ</button>
            <button id = "meHira" className = "Me kanaButton" onclick="keyboardPress('め', 'meHira')">め</button>
            <button id = "reHira" className = "Re kanaButton" onclick="keyboardPress('れ', 'reHira')">れ</button>
            <button id = "oHira" className = "O kanaButton" onclick="keyboardPress('お', 'oHira')">お</button>
            <button id = "koHira" className = "Ko kanaButton" onclick="keyboardPress('こ', 'koHira')">こ</button>
            <button id = "soHira" className = "So kanaButton" onclick="keyboardPress('そ', 'soHira')">そ</button>
            <button id = "toHira" className = "To kanaButton" onclick="keyboardPress('と', 'toHira')">と</button>
            <button id = "noHira" className = "No kanaButton" onclick="keyboardPress('の', 'noHira')">の</button>
            <button id = "hoHira" className = "Ho kanaButton" onclick="keyboardPress('ほ', 'hoHira')">ほ</button>
            <button id = "moHira" className = "Mo kanaButton" onclick="keyboardPress('も', 'moHira')">も</button>
            <button id = "yoHira" className = "Yo kanaButton" onclick="keyboardPress('よ', 'yoHira')">よ</button>
            <button id = "roHira" className = "Ro kanaButton" onclick="keyboardPress('ろ', 'roHira')">ろ</button>
        

        </div>

    );
}

export default HiraganaKeyboard;



