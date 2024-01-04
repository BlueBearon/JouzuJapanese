var hiraganaTab = document.getElementById("toHiraganaTab")
var katakanaTab = document.getElementById("toKatakanaTab")
var verbTab = document.getElementById("toVerbConjugationTab")
var adjectiveTab = document.getElementById("toAdjectiveConjugationTab")

verbTab.onclick = function() {
    //open frontend/PrototypeConjugationPractice.html
    window.location.href = "PrototypeConjugationPractice.html?mode=0";
}

adjectiveTab.onclick = function() {
    //open frontend/PrototypeConjugationPractice.html
    window.location.href = "PrototypeConjugationPractice.html?mode=1";
}

hiraganaTab.onclick = function() {
    //open D:\Coding\Jouzu\JouzuJapanese\jouzujapanese\frontend\PrototypeKanaPractice.html
    window.location.href = "PrototypeKanaPractice.html?mode=0";
}

katakanaTab.onclick = function() {
    //open D:\Coding\Jouzu\JouzuJapanese\jouzujapanese\frontend\PrototypeKanaPractice.html
    window.location.href = "PrototypeKanaPractice.html?mode=1";
}


