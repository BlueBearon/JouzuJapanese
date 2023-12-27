
var mode = 0; // 0 = verb, 1 = adjective

question = ["", "", ""]; // [answer, word, conjugationtype]


var question_count = 0;
var correct_count = 0;

var submitButton = document.getElementById("submitButton");
var nextButton = document.getElementById("nextButton");
var nextButton2 = document.getElementById("nextButton2");
var optionsbutton = document.getElementById("optionsButton");
var closeOptionsButton = document.getElementById("closeOptionsButton");

function setMode()
{
    const urlParams = new URLSearchParams(window.location.search);

    mode = urlParams.get('mode');

    console.log("Mode: " + mode);
}



//Backend Functions


function retrieveVerbQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Verb Question");

    //return ["たべられます", "たべる", "Potential Formal Positive Present"];

    var possibleQuestions = [
        ["たべられます", "たべる", "Potential Formal Positive Present"],
        ["のまれました", "のむ", "Passive Formal Positive Past"],
        ["よませます", "よむ", "Causative Formal Positive Present"],
        ["はなされません", "はなす", "Passive Formal Negative Present"],
        ["およぎます", "およぐ", "Potential Formal Positive Present"],
        ["しりませんでした", "しる", "Informal Negative Past"],
        ["おくれる", "おく", "Potential Informal Positive Present"],
        ["かえられる", "かえる", "Potential Informal Positive Present"],
        ["かかせます", "かく", "Causative Formal Positive Present"]
    ];

    return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
}

function retrieveAdjectiveQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Adjective Question");

    //return ["たかいです", "たかい", "Formal Positive Present"];

    var possibleQuestions = [
        ["たかいです", "たかい", "Formal Positive Present"],
        ["ねむくなかったです", "ねむい", "Formal Negative Past"],
        ["あつくありません", "あつい", "Formal Negative Present"],
        ["おおきくなります", "おおきい", "Formal Positive Future"],
        ["やさしかったです", "やさしい", "Formal Positive Past"],
        ["たのしいです", "たのしい", "Formal Positive Present"],
        ["さびしかったです", "さびしい", "Formal Positive Past"],
        ["しずかでした", "しずか", "Casual Positive Past"],
        ["こわいです", "こわい", "Formal Positive Present"],
        ["あたたかくないです", "あたたかい", "Formal Negative Present"]
        
    ];

    return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];

}

//UI Functions

function showQuestion(conjugationType, word)
{
    console.log("Updating UI");
    document.getElementById("conjugationParameters").innerHTML = conjugationType;
    document.getElementById("conjugationWord").innerHTML = word;
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

//Practice Functions

function verbPractice()
{

    console.log("Verb Practice");

    var includeRu = document.getElementById("ruVerbs").checked;
    var includeU = document.getElementById("uVerbs").checked;
    var includeIrr = document.getElementById("irregularVerbs").checked;

    var includeFormal = document.getElementById("formal").checked;
    var includeCasual = document.getElementById("casual").checked;

    var includePositive = document.getElementById("positive").checked;
    var includeNegative = document.getElementById("negative").checked;

    var includePresent = document.getElementById("present").checked;
    var includePast = document.getElementById("past").checked;

    var includePotential = document.getElementById("potential").checked;
    var includePassive = document.getElementById("passive").checked;
    var includeCausative = document.getElementById("causative").checked;
    var includeVolitional = document.getElementById("volitional").checked;

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

    var includeIAdjective = document.getElementById("iAdjectives").checked;
    var includeNaAdjective = document.getElementById("naAdjectives").checked;

    var includeFormal = document.getElementById("adjectiveFormal").checked;
    var includeCasual = document.getElementById("adjectiveCasual").checked;

    var includePositive = document.getElementById("adjectivePositive").checked;
    var includeNegative = document.getElementById("adjectiveNegative").checked;

    var includePresent = document.getElementById("adjectivePresent").checked;
    var includePast = document.getElementById("adjectivePast").checked;

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



//Event Listeners

submitButton.onclick = function() {
    checkAnswer();
}

nextButton.onclick = function() {
    nextQuestion();
}

nextButton2.onclick = function() {
    nextQuestion();
}

optionsbutton.onclick = function() {

    var options = document.getElementById("options");
    
    if (mode == 0)
    {
        options.style.display = 'block';
        var optionscontainer = document.getElementById("verboptionsContainer");
        optionscontainer.style.display = 'grid';

    }
    else
    {
        options.style.display = 'block';
        var optionscontainer = document.getElementById("adjectiveoptionsContainer");
        optionscontainer.style.display = 'grid';
    }
}

closeOptionsButton.onclick = function() {
    var options = document.getElementById("options");
    options.style.display = 'none';

    if (mode == 0)
    {
        var optionscontainer = document.getElementById("verboptionsContainer");
        optionscontainer.style.display = 'none';
        verbPractice();
    }
    else
    {
        var optionscontainer = document.getElementById("adjectiveoptionsContainer");
        optionscontainer.style.display = 'none';
        adjectivePractice();
    }
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


//Option Validation Functions

function validateVerbOptions()
{
    var includeRu = document.getElementById("ruVerbs").checked;
    var includeU = document.getElementById("uVerbs").checked;
    var includeIrr = document.getElementById("irregularVerbs").checked;

    if (includeRu || includeU || includeIrr)
    {
        return true;
    }
    else
    {
        return false;
    }
}


var ruCheck = document.getElementById("ruVerbs");

ruCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbOptions())
        {
            this.checked = true;
        }
    }
});

var uCheck = document.getElementById("uVerbs");

uCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbOptions())
        {
            this.checked = true;
        }
    }
});

var irrCheck = document.getElementById("irregularVerbs");

irrCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbOptions())
        {
            this.checked = true;
        }
    }
});

function validateAdjectiveOptions()
{
    var includeIAdjective = document.getElementById("iAdjectives").checked;
    var includeNaAdjective = document.getElementById("naAdjectives").checked;

    if (includeIAdjective || includeNaAdjective)
    {
        return true;
    }
    else
    {
        return false;
    }
}

var iCheck = document.getElementById("iAdjectives");

iCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectiveOptions())
        {
            this.checked = true;
        }
    }
});

var naCheck = document.getElementById("naAdjectives");

naCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectiveOptions())
        {
            this.checked = true;
        }
    }
});

function validateVerbFormalalityOptions()
{
    var includeFormal = document.getElementById("formal").checked;
    var includeCasual = document.getElementById("casual").checked;

    if (includeFormal || includeCasual)
    {
        return true;
    }
    else
    {
        return false;
    }
}

var formalCheck = document.getElementById("formal");

formalCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbFormalalityOptions())
        {
            this.checked = true;
        }
    }
});

var casualCheck = document.getElementById("casual");

casualCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbFormalalityOptions())
        {
            this.checked = true;
        }
    }
});


function validateAdjectiveFormalalityOptions()
{
    var includeFormal = document.getElementById("adjectiveFormal").checked;
    var includeCasual = document.getElementById("adjectiveCasual").checked;

    if (includeFormal || includeCasual)
    {
        return true;
    }
    else
    {
        return false;
    }
}

var adjectiveFormalCheck = document.getElementById("adjectiveFormal");

adjectiveFormalCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectiveFormalalityOptions())
        {
            this.checked = true;
        }
    }
});

var adjectiveCasualCheck = document.getElementById("adjectiveCasual");

adjectiveCasualCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectiveFormalalityOptions())
        {
            this.checked = true;
        }
    }
});

function validateVerbPolarityOptions()
{
    var includePositive = document.getElementById("positive").checked;
    var includeNegative = document.getElementById("negative").checked;

    if (includePositive || includeNegative)
    {
        return true;
    }
    else
    {
        return false;
    }
}

var positiveCheck = document.getElementById("positive");

positiveCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbPolarityOptions())
        {
            this.checked = true;
        }
    }
});

var negativeCheck = document.getElementById("negative");

negativeCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbPolarityOptions())
        {
            this.checked = true;
        }
    }
});

function validateAdjectivePolarityOptions()
{
    var includePositive = document.getElementById("adjectivePositive").checked;
    var includeNegative = document.getElementById("adjectiveNegative").checked;

    if (includePositive || includeNegative)
    {
        return true;
    }
    else
    {
        return false;
    }
}

var adjectivePositiveCheck = document.getElementById("adjectivePositive");

adjectivePositiveCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectivePolarityOptions())
        {
            this.checked = true;
        }
    }
});

var adjectiveNegativeCheck = document.getElementById("adjectiveNegative");

adjectiveNegativeCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectivePolarityOptions())
        {
            this.checked = true;
        }
    }
});


function validateVerbTimeOptions()
{
    var includePresent = document.getElementById("present").checked;
    var includePast = document.getElementById("past").checked;

    if (includePresent || includePast)
    {
        return true;
    }
    else
    {
        return false;
    }
}

var presentCheck = document.getElementById("present");

presentCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbTimeOptions())
        {
            this.checked = true;
        }
    }
});

var pastCheck = document.getElementById("past");

pastCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateVerbTimeOptions())
        {
            this.checked = true;
        }
    }
});

function validateAdjectiveTimeOptions()
{
    var includePresent = document.getElementById("adjectivePresent").checked;
    var includePast = document.getElementById("adjectivePast").checked;

    if (includePresent || includePast)
    {
        return true;
    }
    else
    {
        return false;
    }
}

var adjectivePresentCheck = document.getElementById("adjectivePresent");

adjectivePresentCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectiveTimeOptions())
        {
            this.checked = true;
        }
    }
});

var adjectivePastCheck = document.getElementById("adjectivePast");

adjectivePastCheck.addEventListener('change', function() {
    if(!this.checked) 
    {
        if (!validateAdjectiveTimeOptions())
        {
            this.checked = true;
        }
    }
});


//Initialization

function init()
{
    updateStats();

    setMode();

    setAllCheckboxes(true);

    if (mode == 0)
    {
        verbPractice();
    }
    else
    {
        adjectivePractice();
    }
}


init();
