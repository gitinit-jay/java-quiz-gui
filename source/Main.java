import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizFrame quiz = new QuizFrame();
            quiz.setVisible(true);
        });
    }
}
