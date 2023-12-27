
var mode = 0;

question = ["", "", ""]; // [question, answer, type]

var question_count = 0;
var correct_count = 0;

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

function retrieveHiraganaQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Hiragana Question");

    //random number 0 or 1
    var random = Math.floor(Math.random() * 2);

    if (random == 0)
    {
        return ["た", "ta", "KANA"];
    }
    else
    {
        return ["ta", "た", "ROMANJI"];
    }
}

function retrieveKatakanaQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Katakana Question");

    //random number 0 or 1
    var random = Math.floor(Math.random() * 2);

    if (random == 0)
    {
        return ["タ", "ta", "KANA"];
    }
    else
    {
        return ["ta", "タ", "ROMANJI"];
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

    var includeKanaToRomaji = true; //TODO: get from options
    var includeRomajiToKana = true; //TODO: get from options
    var includeSpecialKana = true; //TODO: get from options
    var includeExtendedKana = true; //TODO: get from options

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

    var includeKanaToRomaji = true; //TODO: get from options
    var includeRomajiToKana = true; //TODO: get from options
    var includeSpecialKana = true; //TODO: get from options
    var includeExtendedKana = true; //TODO: get from options

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
        document.getElementById("incorrectAnswerText").innerHTML = userAnswer;
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

    if (mode == 0)
    {
        hiraganaPractice();
    }
    else
    {
        katakanaPractice();
    }
}

var submitButton = document.getElementById("submitButton");

submitButton.onclick = function() {
    checkAnswer();
}

var nextButton = document.getElementById("nextButton");
var nextButton2 = document.getElementById("nextButton2");

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

function keyboardPress(key)
{
    console.log("Key Pressed: " + key);

    if (key == "dakutenhira" || key == "dakutenkata")
    {
        //TODO
    }
    else if (key == "handakutenhira" || key == "handakutenkata")
    {
        //TODO
    }
    else
    {
        document.getElementById("userInputBox").value += key;
    }

}


updateStats();

setMode();

if (mode == 0)
{
    hiraganaPractice();
}
else
{
    katakanaPractice();
}


