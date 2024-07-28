import javax.swing.JOptionPane;
import java.util.Random;
class RandomNumberGuessingGameGUI 
{
    public static void main(String[] args) 
    {
        int min = 1;
        int max = 100;
        int generatedNumber=generateRandomNumber(min, max);
        int userGuess;
        int attempts = 0;
        do 
        {
            userGuess = Integer.parseInt(JOptionPane.showInputDialog("Guess the number between " + min + " and " + max + ":"));
            attempts++;
            if (userGuess == generatedNumber) 
            {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
                if (playAgain == JOptionPane.YES_OPTION) 
                {
                    generatedNumber = generateRandomNumber(min, max);
                    attempts = 0;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Thank you for playing!");
                    break;
                }
            } 
            else if (userGuess < generatedNumber) 
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            else 
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
        } 
        while (true);
    }
    private static int generateRandomNumber(int min, int max) 
    {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}