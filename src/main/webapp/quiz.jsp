<%@ page language="java" %>
<%
 if(session.getAttribute("user") == null){
     response.sendRedirect("login.jsp");
 }
%>

<!DOCTYPE html>
<html>
<head>
<title>Online Quiz</title>
<link rel="stylesheet" href="style.css">
<script src="quiz.js"></script>
</head>

<body onload="loadQuestion()">
<div class="container">
  
<div class="quiz-box">
<h2>Online Quiz</h2>

<p id="timer">Time Left: 10s</p>

<form action="ResultServlet" method="post" id="quizForm">
    <p id="question"></p>

    <input type="radio" name="answer" value="10"> <span id="opt1"></span><br>
    <br>
    <input type="radio" name="answer" value="0"> <span id="opt2"></span><br>

    <input type="hidden" name="score" id="score">

    <br>
    <button type="button" onclick="nextQuestion()">Next</button>
</form>

</div>
  
</div>
<footer class="footer">
    <p>&copy; 2025 Online Quiz System. Made with Love by - Mohammad Faraz</p>
</footer>
</body>
</html>
