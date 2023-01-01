import java.util.*;
 
public class numberGame {
        public static void playGame(int n) {
                int score = n;
                Scanner no = new Scanner(System.in);
                int number = 1 + (int) (100 * Math.random()); // random number
                int max = 10;// maximum trial
				int k=10;
                int i, guess;
                System.out.println("A number is chosen" + " between 1 to 100.\n" + "Guess the number"
                                + " within 10 trials.");
                // loop for trial
                for (i = 1; i <= max; i++) {
                        System.out.println("Guess the number:     (Trial Left:"+(k--)+")");
                        guess = no.nextInt();
                        if (number == guess) {
                                System.out.println("Congratulations! You guessed the number.");
                                score++;
                                break;
                        } else if ((number > guess) && (i != max )) {
                                System.out.println("The number is " + "greater than " + guess);
                        } else if ((number < guess) && (i != max )) {
                                System.out.println("The number is" + " less than " + guess);
                        }
                }
                if (i == max) {
                        System.out.println("Sorry! Your all trails over");
                        System.out.println("The number was " + number);
                }
                System.out.println("Your score = " + score);
                System.out.println("Play again:\n   1)Yes\n   2)No");
                System.out.println("enter your choice:");
                int choice = no.nextInt();
                if (choice == 1)
                        playGame(score);
        }

        public static void main(String arg[]) {
                int n = 0;
                playGame(n);
        }
}

