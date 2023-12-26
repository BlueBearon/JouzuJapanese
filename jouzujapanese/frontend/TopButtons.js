backbutton = document.getElementById("backButton");
optionsbutton = document.getElementById("optionsButton");

backbutton.onclick = function() {
    //open D:\Coding\Jouzu\JouzuJapanese\jouzujapanese\frontend\PrototypeHomePage.html
    window.location.href = "PrototypeHomePage.html";
}

optionsbutton.onclick = function() {
    //open modal
    console.log("Options button clicked");
}

window.onpopstate = function(event) {
    if(window.location.href.includes("ConjugationPractice.html") || window.location.href.includes("KanaPractice.html")) {
        window.location.href = "PrototypeHomePage.html";
    }
    else
    {
        window.history.back();
    }
};