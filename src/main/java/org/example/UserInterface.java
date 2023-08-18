package org.example;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    public String displayMainMenu() {

        System.out.println("===============Welcome to Trivia Land===============");
        System.out.println("=====================Main Menu======================");
        System.out.println("(1) Play");
        System.out.println("(2) Exit");
        System.out.print("Select Option >");

        return scanner.nextLine();
    }

    public void displayExitMessage() {
        System.out.println("Bye for now");
    }

    public void displayInvalidInput() {
        System.out.println("Invalid Input");
    }

    public String displaySubjectChoice() {

        System.out.println("Please Select a Topic that you would like to explore");
        System.out.println("(1) Russian Literature");
        System.out.print("Select Option >");

        return scanner.nextLine();
    }

    public String displayQuestion(String posedQuestion) {
        System.out.println(posedQuestion);

        return scanner.nextLine();
    }

    public void displayScoreReport(int correctResponses, int incorrectResponses) {
        System.out.println("You have responded correctly to " + correctResponses + " questions and incorrectly to " + incorrectResponses + " questions");
    }
}
