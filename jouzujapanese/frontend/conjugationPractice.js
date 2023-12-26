
var mode = 0; // 0 = verb, 1 = adjective

question = ["", "", ""]; // [answer, word, conjugationtype]


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


function retrieveVerbQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Verb Question");

    return ["たべられます", "たべる", "Potential Formal Positive Present"];
}

function retrieveAdjectiveQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Adjective Question");

    return ["たかいです", "たかい", "Formal Positive Present"];

}

function showQuestion(conjugationType, word)
{
    console.log("Updating UI");
    document.getElementById("conjugationParameters").innerHTML = conjugationType;
    document.getElementById("conjugationWord").innerHTML = word;
}

function verbPractice()
{

    console.log("Verb Practice");

    var includeRu = true;//Will be replaced by checkbox in options
    var includeU = true;
    var includeIrr = true;

    var includeFormal = true;
    var includeCasual = true;

    var includePositive = true;
    var includeNegative = true;

    var includePresent = true;
    var includePast = true;

    var includePotential = true;
    var includePassive = true;
    var includeCausative = true;
    var includeVolitional = true;

    var options = [includeRu, includeU, includeIrr, includeFormal, includeCasual, includePositive, includeNegative, includePresent, includePast, includePotential, includePassive, includeCausative, includeVolitional];

    console.log(options);

    question = retrieveVerbQuestion(options);

    //console.log("Conjugation Type: ${question[2]} | Word: ${question[1]} | Answer: ${question[0]}");
    console.log(question[2] + " | " + question[1] + " | " + question[0])

    showQuestion(question[2], question[1]);

}

function adjectivePractice()
{

    console.log("Adjective Practice");

    var includeIAdjective = true;//Will be replaced by checkbox in options
    var includeNaAdjective = true;

    var includeFormal = true;
    var includeCasual = true;

    var includePositive = true;
    var includeNegative = true;

    var includePresent = true;
    var includePast = true;

    var options = [includeIAdjective, includeNaAdjective, includeFormal, includeCasual, includePositive, includeNegative, includePresent, includePast];

    console.log(options);

    question =  retrieveAdjectiveQuestion(options);

    showQuestion(question[2], question[1]);

}


function checkAnswer()
{
    var userAnswer = document.getElementById("userInputBox").value;

    question_count++;

    if (userAnswer == question[0])
    {
        console.log("Correct");
        document.getElementById("question").style.display = "none";
        document.getElementById("correctAnswer").style.display = "flex";
        document.getElementById("conjugationParametersAnswer").innerHTML = question[2];
        document.getElementById("conjugationWordAnswerText").innerHTML = question[0];

        correct_count++;

        updateStats();
        
    }
    else
    {
        console.log("Incorrect");
        document.getElementById("question").style.display = "none";
        document.getElementById("wrongAnswer").style.display = "flex";
        document.getElementById("conjugationParametersAnswer").innerHTML = question[2];
        document.getElementById("incorrectAnswerText").innerHTML = userAnswer;
        document.getElementById("correctWordAnswerText2").innerHTML = question[0];

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
        verbPractice();
    }
    else
    {
        adjectivePractice();
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


updateStats();

setMode();

if (mode == 0)
{
    verbPractice();
}
else
{
    adjectivePractice();
}