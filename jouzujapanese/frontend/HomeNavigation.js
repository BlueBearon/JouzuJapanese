var hiraganaButton = document.getElementById("toHiraganaButton");
var katakanaButton = document.getElementById("toKatakanaButton");
var verbButton = document.getElementById("toVerbConjugationButton");
var adjectiveButton = document.getElementById("toAdjectiveConjugationButton");

hiraganaButton.onclick = function() {
    //open D:\Coding\Jouzu\JouzuJapanese\jouzujapanese\frontend\PrototypeKanaPractice.html
    window.location.href = "PrototypeKanaPractice.html?mode=0";
}

katakanaButton.onclick = function() {
    //open D:\Coding\Jouzu\JouzuJapanese\jouzujapanese\frontend\PrototypeKanaPractice.html
    window.location.href = "PrototypeKanaPractice.html?mode=1";
}

verbButton.onclick = function() {
    //open frontend/PrototypeConjugationPractice.html
    window.location.href = "PrototypeConjugationPractice.html?mode=0";
}

adjectiveButton.onclick = function() {
    //open frontend/PrototypeConjugationPractice.html
    window.location.href = "PrototypeConjugationPractice.html?mode=1";
}
