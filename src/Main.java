import java.util.*;
import static java.lang.System.exit;

public class Main {
    static List<String> given = new ArrayList<>(6);
    static List<String> nGiven = new ArrayList<>(1);
    static List<Character> word = new ArrayList<>();


    public static void main(String[] args) {
        given.add("word");
        given.add("apple");
        given.add("free");
        given.add("helmet");
        given.add("computer");
        given.add("programming");

        int chosen = (int) Math.floor(Math.random() * given.size());
        nGiven.add(given.get(chosen));
        char[] takeG = nGiven.get(0).toCharArray();
        ArrayList<Character> prog = new ArrayList<>();

        for (char i : takeG) {
            word.add(i);
            prog.add(i);
        }
        System.out.println(prog);
        for (int i = 0; i < prog.size(); i++) {
            prog.set(i, '_');
        }

        System.out.println("HANGMAN\n +---+\n \s\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s===\nMissed letters:\n ");
        System.out.println(change(prog));

        Scanner input = new Scanner(System.in);
        int guesses = 0;

        while (prog.contains('_')) {
            System.out.println("Guess a letter.\n");
            String check = input.next();

            if(prog.contains(test(check))) {
                System.out.println("You've already used this letter.");
            }
            else if (word.contains(test(check))) {
                System.out.println("Missed letters:\n");
                prog.set(word.indexOf(test(check)), test(check));
                prog.set(word.lastIndexOf(test(check)), test(check));
                System.out.println(change(prog));
            } else {
                guesses++;
                System.out.println("Wrong. Guess again");
                switch (guesses) {
                    case (1): {
                        System.out.println("HANGMAN\n +---+\n O\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s===\nMissed letters:\n ");
                        break;
                    }
                    case (2): {
                        System.out.println("HANGMAN\n +---+\n O\s\s\s|\n |\s\s\s|\n |\s\s\s|\n\s\s\s===\nMissed letters:\n ");
                        break;
                    }
                    case (3): {
                        System.out.println("HANGMAN\n +---+\n O\s\s\s|\n |\s\s\s|\n |\s\s\s|\n|\s\s\s===\nMissed letters:\n ");
                        break;
                    }
                    case (4): {
                        System.out.println("HANGMAN\n +---+\n O\s\s\s|\n |\s\s\s|\n |\s\s\s|\n|\s|===\nMissed letters:\n ");
                        break;
                    }
                    case (5): {
                        System.out.println("HANGMAN\n +---+\n O\s\s\s|\n" + "/" + "|\s\s\s|\n |\s\s\s|\n|\s|===\nMissed letters:\n ");
                        break;
                    }
                    case (6): {
                        System.out.println("HANGMAN\n +---+\n O\s\s\s|\n" + "/" + "|\\" + "\s\s|\n |\s\s\s|\n|\s|===\nMissed letters:\n ");
                        System.out.println("Game Over. \nWould you like to play again (y/n)?");
                        if (input.next().charAt(0) == 'y') {
                            main(args);
                        } else {
                            exit(0);
                        }
                        break;
                    }
                    default: {
                        System.out.println("error");
                        break;
                    }
                }
            }
        }
        System.out.println("Yes! The secret word is " + change(prog) + "! Would you like to play again (y/n)?");
        if (input.next().charAt(0) == 'y') {
            main(args);
        } else {
            exit(0);
        }
    }

    private static String change(ArrayList prog){
        String changed = prog.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(changed);
        sb.deleteCharAt(sb.indexOf("["));
        sb.deleteCharAt(sb.indexOf("]"));
        changed = sb.toString();
        String newChanged = changed.replaceAll(", " , "");
        return newChanged;
    }

    private static Character test(String check){
        char con = check.charAt(0);
        List<Character> guess = Arrays.asList(con);
        Character letter = 'x';
        boolean x = false;

        while (!x) {
            try {
                int c = Integer.parseInt(check);
                if(c >= -9){
                    x = false;
                    System.out.println("Try again.");
                    Scanner n = new Scanner(System.in);
                    check = n.next();
                }
            } catch (NumberFormatException e) {
                x = true;
            }
        }
        for(int i = 0; i < word.size(); i++){
            if(word.contains(guess.get(0))){
                letter = guess.get(0);
                return letter;
            }
        }
        return letter;
    }
}
