import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QuizFrame extends JFrame {

    private ArrayList<Question> questions = new ArrayList<>();
    private int index = 0;
    private int score = 0;

    // GUI components
    private JLabel questionLabel;
    private JButton[] optionButtons;

    public QuizFrame() {
        setTitle("Java Quiz - GUI Version");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center screen
        setLayout(new BorderLayout());

        // Add questions
        loadQuestions();

        // NORTH: Question text
        questionLabel = new JLabel("Question");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        // CENTER: Options
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1, 10, 10));
        optionButtons = new JButton[4];

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton("Option " + (i + 1));
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 16));
            optionButtons[i].addActionListener(new OptionButtonListener(i + 1));
            optionsPanel.add(optionButtons[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);

        // load first question
        displayQuestion();
    }

    private void loadQuestions() {
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "implements"}, 3
        ));

        questions.add(new Question(
                "What is the size of int in Java?",
                new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on OS"}, 2
        ));

        questions.add(new Question(
                "Which is not an OOP concept?",
                new String[]{"Encapsulation", "Polymorphism", "Compilation", "Inheritance"}, 3
        ));
    }

    private void displayQuestion() {
        if (index >= questions.size()) {
            showResult();
            return;
        }

        Question q = questions.get(index);
        questionLabel.setText("Q" + (index + 1) + ": " + q.getQuestion());

        String[] opts = q.getOptions();
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(opts[i]);
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this,
                "Quiz Completed!\nYour Score: " + score + "/" + questions.size(),
                "Result",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

    private class OptionButtonListener implements ActionListener {
        private int optionNumber;

        public OptionButtonListener(int optionNumber) {
            this.optionNumber = optionNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Question q = questions.get(index);

            if (optionNumber == q.getCorrectOption()) {
                JOptionPane.showMessageDialog(null, "Correct!");
                score++;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Wrong!\nCorrect answer: " + q.getOptions()[q.getCorrectOption() - 1]);
            }

            index++;
            displayQuestion();
        }
    }
}
