let questions = [
 { q: "Java is a?", a: "Programming Language", b: "Database" },
 { q: "JSP stands for?", a: "Java Server Pages", b: "Java Simple Program" },
 { q: "JDBC package?", a: "java.sql", b: "java.io" },
 { q: "Secure method?", a: "POST", b: "GET" },
 { q: "MySQL Driver?", a: "com.mysql.cj.jdbc.Driver", b: "oracle.jdbc.Driver" }
];

let index = 0;
let totalScore = 0;
let time = 10;
let timer;

function loadQuestion(){
    if(index == questions.length){
        document.getElementById("score").value = totalScore;
        document.getElementById("quizForm").submit();
        return;
    }

    document.getElementById("question").innerHTML = questions[index].q;
    document.getElementById("opt1").innerHTML = questions[index].a;
    document.getElementById("opt2").innerHTML = questions[index].b;

    let radios = document.getElementsByName("answer");
    for(let r of radios) r.checked = false;

    time = 10;
    document.getElementById("timer").innerHTML = "Time Left: 10s";

    clearInterval(timer);
    timer = setInterval(countdown, 1000);
}

function countdown(){
    time--;
    document.getElementById("timer").innerHTML = "Time Left: " + time + "s";

    if(time == 0){
        nextQuestion();
    }
}

function nextQuestion(){
    clearInterval(timer);

    let ans = document.querySelector('input[name="answer"]:checked');
    if(ans){
        totalScore += parseInt(ans.value);
    }

    index++;
    loadQuestion();
}
