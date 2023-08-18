package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Jeopardy {

    UserInterface ui = new UserInterface();
    Map<String, String> subjectFileMatcher = new HashMap<>();
    List<Question> questions = new ArrayList<>();
    Map<Integer,String> fileIndexMap = new HashMap<>();

    public static void main(String[] args) {
        Jeopardy jeopardy = new Jeopardy();
        jeopardy.run();
    }


    public void run() {
        String menuChoice = ui.displayMainMenu();

        while (true) {
            if (menuChoice.equals("1")) {
                selectSubject();
            }
            else if (menuChoice.equals("2")) {
                ui.displayExitMessage();
                return;
            }
            else ui.displayInvalidInput();
        }
    }

    public void selectSubject() {
        subjectFileMatcher.put("Russian Literature", "RussianLiterature.txt");
        fileIndexMap.put(1,"Russian Literature");
        String userSubjectChoice = ui.displaySubjectChoice();
        readSubjectFile(userSubjectChoice);
    }


    public void readSubjectFile(String  userSubjectChoice) {
        int subjectNumberChoice = Integer.parseInt(userSubjectChoice);
        String chosenSubject = fileIndexMap.get(subjectNumberChoice);
        String fileToUpload = subjectFileMatcher.get(chosenSubject);
        try {
            File input = new File(fileToUpload);
            Scanner fs = new Scanner(input);
            while (fs.hasNextLine()) {
                String line = fs.nextLine();
                String[] questionPairs = line.split(",");

                String question = questionPairs[0];
                String answer = questionPairs[1];

                Question q = new Question(question,answer);
                questions.add(q);

            }

        } catch (FileNotFoundException e) {
            ui.displayInvalidInput();
        }
        poseQuestion();

    }

    public void poseQuestion() {
        int correctResponses = 0;
        int incorrectResponses = 0;
        int questionCounter = 0;


        for (int i = 0; i < questions.size(); i++) {
            String posedQuestion = questions.get(i).getQuestion();
            String submittedAnswer = ui.displayQuestion(posedQuestion);
            if (submittedAnswer.equals(questions.get(i).getAnswer())) {
                correctResponses++;
            } else {
                incorrectResponses++;
            }

        }
        ui.displayScoreReport(correctResponses,incorrectResponses);
        ui.displayMainMenu();
    }


    // Space for adding Subject and File matching pairs as they are created



}

