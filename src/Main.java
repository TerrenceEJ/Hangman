import javax.swing.text.StyledEditorKit;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.awt.font.TextAttribute.*;
import static java.lang.System.exit;

public class Main {
    static List<Character> word = Arrays.asList('c', 'a', 't');

    public static void main(String[] args) {
        ArrayList<Character> prog = new ArrayList<>(word.size());
        prog.add('_');
        prog.add('_');
        prog.add('_');


        System.out.println("HANGMAN\n +---+\n \s\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s===\nMissed letters:\n " );
        System.out.println(change(prog));
        Scanner input = new Scanner(System.in);
        int guesses = 0;

        while(!change(prog).equals("cat")) {
            System.out.println("Guess a letter.\n");
            String check = input.next();
            switch (test(check)) {
                case ('c'): {
                    if(prog.get(0) == 'c'){
                        System.out.println("You've already guessed that letter, try again.");
                    }else {
                        prog.set(0, test(check));
                        System.out.println("Missed letters:\n\n" + change(prog));
                    }
                    break;
                }
                case ('a'): {
                    if(prog.get(1) == 'a'){
                        System.out.println("You've already guessed that letter, try again.");
                    }else {
                        prog.set(1, test(check));
                        System.out.println("Missed letters:\n\n" + change(prog));
                    }
                    break;
                }
                case ('t'): {
                    if(prog.get(2) == 't') {
                        System.out.println("You've already guessed that letter, try again.");
                    } else{
                        prog.set(2, test(check));
                        System.out.println("Missed letters:\n\n" + change(prog));
                    }
                    break;
                }
                default:{
                    guesses++;
                    System.out.println(guesses);
                    System.out.println("Wrong. Guess again");
                    switch (guesses){
                        case(1):{
                            System.out.println("HANGMAN\n +---+\n O\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s|\n\s\s\s\s\s===\nMissed letters:\n " );
                            break;
                        }
                        case(2):{
                            System.out.println("HANGMAN\n +---+\n O\s\s\s|\n |\s\s\s|\n |\s\s\s|\n\s\s\s===\nMissed letters:\n " );
                            break;
                        }
                        case(3):{
                            System.out.println("HANGMAN\n +---+\n O\s\s\s|\n |\s\s\s|\n |\s\s\s|\n|\s\s\s===\nMissed letters:\n " );
                            break;
                        }
                        case(4):{
                            System.out.println("HANGMAN\n +---+\n O\s\s\s|\n |\s\s\s|\n |\s\s\s|\n|\s|===\nMissed letters:\n " );
                            break;
                        }
                        case(5):{
                            System.out.println("HANGMAN\n +---+\n O\s\s\s|\n" + "/" +"|\s\s\s|\n |\s\s\s|\n|\s|===\nMissed letters:\n " );
                            break;
                        }
                        case(6):{
                            System.out.println("HANGMAN\n +---+\n O\s\s\s|\n" + "/" + "|\\" + "\s\s|\n |\s\s\s|\n|\s|===\nMissed letters:\n " );
                            System.out.println("Game Over \n Would you like to play again (y/n)?");
                            if(input.next().charAt(0) == 'y'){
                                main(args);
                            } else{
                                exit(0);
                            }
                            break;
                        }
                        default:{
                            System.out.println("error");
                            break;
                        }
                    }
                }
            }
       }
        System.out.println("Yes! The secret word is \"cat!\"" + "Would you like to play again (y/n)?");
        if(input.next().charAt(0) == 'y'){
            main(args);
        } else{
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
