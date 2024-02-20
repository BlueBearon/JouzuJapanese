
var mode = 0;

question = ["", "", ""]; // [question, answer, type]

var question_count = 0;
var correct_count = 0;

var submitButton = document.getElementById("submitButton");
var nextButton = document.getElementById("nextButton");
var nextButton2 = document.getElementById("nextButton2");
var optionsbutton = document.getElementById("optionsButton");
var closeOptionsButton = document.getElementById("closeOptionsButton");


var kanaButtons = [
    "aHira", "iHira", "uHira", "eHira", "oHira",
    "kaHira", "kiHira", "kuHira", "keHira", "koHira",
    "saHira", "shiHira", "suHira", "seHira", "soHira",
    "taHira", "chiHira", "tsuHira", "teHira", "toHira",
    "naHira", "niHira", "nuHira", "neHira", "noHira",
    "haHira", "hiHira", "fuHira", "heHira", "hoHira",
    "maHira", "miHira", "muHira", "meHira", "moHira",
    "yaHira", "yuHira", "yoHira",
    "raHira", "riHira", "ruHira", "reHira", "roHira",
    "waHira", "woHira",
    "smallYaHira", "smallYuHira", "smallYoHira",
    "dakutenHira", "handakutenHira",
    "aKata", "iKata", "uKata", "eKata", "oKata",
    "kaKata", "kiKata", "kuKata", "keKata", "koKata",
    "saKata", "shiKata", "suKata", "seKata", "soKata",
    "taKata", "chiKata", "tsuKata", "teKata", "toKata",
    "naKata", "niKata", "nuKata", "neKata", "noKata",
    "haKata", "hiKata", "fuKata", "heKata", "hoKata",
    "maKata", "miKata", "muKata", "meKata", "moKata",
    "yaKata", "yuKata", "yoKata",
    "raKata", "riKata", "ruKata", "reKata", "roKata",
    "waKata", "woKata",
    "smallYaKata", "smallYuKata", "smallYoKata",
    "dakutenKata", "handakutenKata"
];


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

function setMode()
{
    const urlParams = new URLSearchParams(window.location.search);

    mode = urlParams.get('mode');

    console.log("Mode: " + mode);
}

function updateStats()
{
    document.getElementById("outOf").innerHTML = correct_count + "/" + question_count;
    if(question_count == 0)
    {
        document.getElementById("percentage").innerHTML = "0%";
    }
    else
    {
        document.getElementById("percentage").innerHTML = Math.round(correct_count/question_count * 100) + "%";
    }
}

function setAllCheckboxes(value)
{
    var checkboxes = document.querySelectorAll('input[type=checkbox]');

    for (var i = 0; i < checkboxes.length; i++) 
    {
        checkboxes[i].checked = value;
    }
}

function retrieveHiraganaQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Hiragana Question");

    //random number 0 or 1
    var random = Math.floor(Math.random() * 2);

    if (options[0] && (!options[1] || random == 0))
    {
        //return ["た", "ta", "KANA"];
        var possibleQuestions = [
            ["た", "ta", "KANA"],
            ["い", "i", "KANA"],
            ["か", "ka", "KANA"],
            ["ぬ", "nu", "KANA"],
            ["せ", "se", "KANA"],
            ["ろ", "ro", "KANA"],
            ["み", "mi", "KANA"],
            ["ね", "ne", "KANA"],
            ["ゆ", "yu", "KANA"],
            ["を", "wo", "KANA"],
            ["が", "ga", "KANA"],
            ["ぢ", "ji", "KANA"],
            ["ぶ", "bu", "KANA"],
            ["ぽ", "po", "KANA"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
    else
    {
        //return ["ta", "た", "ROMANJI"];
        var possibleQuestions = [
            ["ta", "た", "ROMANJI"],
            ["i", "い", "ROMANJI"],
            ["ka", "か", "ROMANJI"],
            ["nu", "ぬ", "ROMANJI"],
            ["se", "せ", "ROMANJI"],
            ["ro", "ろ", "ROMANJI"],
            ["mi", "み", "ROMANJI"],
            ["ne", "ね", "ROMANJI"],
            ["yu", "ゆ", "ROMANJI"],
            ["wo", "を", "ROMANJI"],
            ["ga", "が", "ROMANJI"],
            ["ji", "ぢ", "ROMANJI"],
            ["bu", "ぶ", "ROMANJI"],
            ["po", "ぽ", "ROMANJI"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
}

function retrieveKatakanaQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Katakana Question");

    //random number 0 or 1
    var random = Math.floor(Math.random() * 2);

    if (options[0] && (!options[1] || random == 0))
    {
        //return ["タ", "ta", "KANA"];
        var possibleQuestions = [
            ["タ", "ta", "KANA"],
            ["イ", "i", "KANA"],
            ["カ", "ka", "KANA"],
            ["ヌ", "nu", "KANA"],
            ["セ", "se", "KANA"],
            ["ロ", "ro", "KANA"],
            ["ミ", "mi", "KANA"],
            ["ネ", "ne", "KANA"],
            ["ユ", "yu", "KANA"],
            ["ヲ", "wo", "KANA"],
            ["ガ", "ga", "KANA"],
            ["ヂ", "ji", "KANA"],
            ["ブ", "bu", "KANA"],
            ["ポ", "po", "KANA"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
    else
    {
        //return ["ta", "タ", "ROMANJI"];
        var possibleQuestions = [
            ["ta", "タ", "ROMANJI"],
            ["i", "イ", "ROMANJI"],
            ["ka", "カ", "ROMANJI"],
            ["nu", "ヌ", "ROMANJI"],
            ["se", "セ", "ROMANJI"],
            ["ro", "ロ", "ROMANJI"],
            ["mi", "ミ", "ROMANJI"],
            ["ne", "ネ", "ROMANJI"],
            ["yu", "ユ", "ROMANJI"],
            ["wo", "ヲ", "ROMANJI"],
            ["ga", "ガ", "ROMANJI"],
            ["ji", "ヂ", "ROMANJI"],
            ["bu", "ブ", "ROMANJI"],
            ["po", "ポ", "ROMANJI"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
    

}

function showQuestion(question, answer)
{
    console.log("Updating UI");
    document.getElementById("kana").innerHTML = question[0];

}

function hiraganaPractice()
{
    console.log("Hiragana Practice");

    var includeKanaToRomaji = document.getElementById("kanaToRomanji").checked;
    var includeRomajiToKana = document.getElementById("romanjiToKana").checked;
    var includeSpecialKana = document.getElementById("dakutenhandakuten").checked;
    var includeExtendedKana = document.getElementById("extended").checked;

    var options = [includeKanaToRomaji, includeRomajiToKana, includeSpecialKana, includeExtendedKana];

    console.log("Options: " + options);

    question = retrieveHiraganaQuestion(options);

    console.log(question[2] + " | " + question[1] + " | " + question[0]);

    showQuestion(question);

    document.getElementById("katakanaKeyboard").style.display = "none";

    if (question[2] == "ROMANJI")
    {
        console.log("Preparing hiragana keyboard")
        document.getElementById("userInputBox").style.display = "none";
        document.getElementById("hiraganaKeyboard").style.display = "grid";
    }
    else
    {
        document.getElementById("userInputBox").style.display = "flex";
        document.getElementById("hiraganaKeyboard").style.display = "none";
    }
}

function katakanaPractice()
{
    console.log("Katakana Practice");

    var includeKanaToRomaji = document.getElementById("kanaToRomanji").checked;
    var includeRomajiToKana = document.getElementById("romanjiToKana").checked;
    var includeSpecialKana = document.getElementById("dakutenhandakuten").checked;
    var includeExtendedKana = document.getElementById("extended").checked;

    var options = [includeKanaToRomaji, includeRomajiToKana, includeSpecialKana, includeExtendedKana];

    console.log("Options: " + options);

    question = retrieveKatakanaQuestion(options);

    console.log(question[2] + " | " + question[1] + " | " + question[0]);

    showQuestion(question);

    document.getElementById("hiraganaKeyboard").style.display = "none";

    if (question[2] == "ROMANJI")
    {
        document.getElementById("userInputBox").style.display = "none";
        document.getElementById("katakanaKeyboard").style.display = "grid";
    }
    else
    {
        document.getElementById("userInputBox").style.display = "flex";
        document.getElementById("katakanaKeyboard").style.display = "none";
    }
}

function checkAnswer()
{
    var userAnswer = document.getElementById("userInputBox").value;

    console.log("User Answer: " + userAnswer);
    console.log("Correct Answer: " + question[1]);

    question_count++;

    if (userAnswer == question[1])
    {
        console.log("Correct");
        document.getElementById("question").style.display = "none";
        document.getElementById("correctAnswer").style.display = "flex";
        document.getElementById("questionsymbol").innerHTML = question[0];
        document.getElementById("conjugationWordAnswerText").innerHTML = question[1];

        correct_count++;

        updateStats();
        
    }
    else
    {
        console.log("Incorrect");
        document.getElementById("question").style.display = "none";
        document.getElementById("wrongAnswer").style.display = "flex";
        document.getElementById("questionsymbol2").innerHTML = question[0];
        document.getElementById("incorrectAnswerText").textContent = userAnswer;
        document.getElementById("correctAnswerText2").innerHTML = question[1];

        updateStats();
    }
}

function nextQuestion()
{
    document.getElementById("userInputBox").value = "";

    document.getElementById("correctAnswer").style.display = "none";
    document.getElementById("wrongAnswer").style.display = "none";
    document.getElementById("question").style.display = "flex";


    resetKeyBoard();

    if (mode == 0)
    {
        hiraganaPractice();
    }
    else
    {
        katakanaPractice();
    }
}

submitButton.onclick = function() {
    checkAnswer();
}



nextButton.onclick = function() {
    nextQuestion();
}

nextButton2.onclick = function() {
    nextQuestion();
}

document.addEventListener('keyup', function(event) {
    if (event.key === 'Enter') 
    {
        if(document.getElementById("correctAnswer").style.display == "flex" || document.getElementById("wrongAnswer").style.display == "flex")
        {
            nextQuestion();
        }
        else
        {
            checkAnswer();
        }
    }
});

function keyboardPress(key, id)
{
    console.log("Key Pressed: " + key);

    var currentInput = document.getElementById("userInputBox").value;

    if (key == "゛")
    {
        if(currentInput.length > 0 && currentInput[currentInput.length - 1] in dakutenConversions)
        {
            document.getElementById("userInputBox").value = currentInput.substring(0, currentInput.length - 1) + dakutenConversions[currentInput[currentInput.length - 1]];
            document.getElementById(id).style.backgroundColor = "#e6e6e6";
            document.getElementById(id).style.border = "1px solid green";
        }
    }
    else if (key == "゜")
    {
        if(currentInput.length > 0 && currentInput[currentInput.length - 1] in handakutenConversions)
        {
            document.getElementById("userInputBox").value = currentInput.substring(0, currentInput.length - 1) + handakutenConversions[currentInput[currentInput.length - 1]];
            document.getElementById(id).style.backgroundColor = "#e6e6e6";
            document.getElementById(id).style.border = "1px solid green";
        }
    }
    else
    {
        document.getElementById("userInputBox").value += key;
        document.getElementById(id).style.backgroundColor = "#e6e6e6";
        document.getElementById(id).style.border = "1px solid green";
    }


    

}


function resetKeyBoard()
{
    for (var i = 0; i < kanaButtons.length; i++) 
    {
        document.getElementById(kanaButtons[i]).style.border = "none";
        //Default is no color
        document.getElementById(kanaButtons[i]).style.backgroundColor = "transparent";
    }
}

optionsbutton.onclick = function() {

    var options = document.getElementById("options");
    
    options.style.display = 'block';
    var optionscontainer = document.getElementById("kanaOptionsContainer");
    optionscontainer.style.display = 'grid';


}

closeOptionsButton.onclick = function() {
    var options = document.getElementById("options");
    options.style.display = 'none';

    var optionscontainer = document.getElementById("kanaOptionsContainer");
    optionscontainer.style.display = 'none';

    if(mode == 0)
    {
        hiraganaPractice();
    }
    else
    {
        katakanaPractice();
    }

}


//Option Validation Functions

function validateKanaOptions()
{
    var includeKanaToRomaji = document.getElementById("kanaToRomanji").checked;
    var includeRomajiToKana = document.getElementById("romanjiToKana").checked;

    if(includeKanaToRomaji == false && includeRomajiToKana == false)
    {
        return false;
    }

    return true;
}

var kanaToRomanjiCheckbox = document.getElementById("kanaToRomanji");

kanaToRomanjiCheckbox.addEventListener('change', function() {
    if(!this.checked) {
        if(!validateKanaOptions())
        {
            this.checked = true;
        }
    }
});

var romanjiToKanaCheckbox = document.getElementById("romanjiToKana");

romanjiToKanaCheckbox.addEventListener('change', function() {
    if(!this.checked) {
        if(!validateKanaOptions())
        {
            this.checked = true;
        }
    }
});



function init()
{
    updateStats();

    setMode();

    setAllCheckboxes(true);

    if (mode == 0)
    {
        hiraganaPractice();
    }
    else
    {
        katakanaPractice();
    }

}

init();


