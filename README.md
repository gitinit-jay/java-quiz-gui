
#This is a GUI based project which we have given name "Java Quiz Application". In this project we followed all the concept we had told to use like Oops concept(Polymorphism, Inheritance, Exception Handling, Interfaces), java collections and generics, etc.
#A simple Java Swing quiz application that shows multiple-choice questions and displays a final score.
Requirements: JDK 8+ and any IDE (VS Code/IntelliJ).
Setup: Download the project files and open the folder in your IDE.
Run: Compile and run Main.java to start the quiz.

How It Works
The QuestionManager loads all questions into an ArrayList.
QuizFrame displays each question and options using radio buttons.
User selects an answer and clicks Next.
Application stores the response and moves to the next question.
After the final question, ResultFrame shows the total score.
User can close the quiz or restart it.
  Concepts Demonstrated 
  Object-Oriented Design
Questions are modeled as objects.
Different question types use method overriding (polymorphism).
Common structure defined through interfaces.
 Exception Handling 
 Handles:
Invalid selections
Out-of-range errors
Null value issues
Custom exception: InvalidOptionException
 Collections Framework
Uses ArrayList<Question> with generics for type safety.
 Swing UI Programming


