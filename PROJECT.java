import java.util.Scanner;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //menushka
        System.out.println(ansi().fg(Ansi.Color.BLUE).a("Welcome to the encryption/decryption!").reset());
        System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Choose an option:").reset());
        System.out.println("1.Caesar encryption");
        System.out.println("2.Caesar decryption");
        System.out.println("3.Vigenere encryption");
        System.out.println("4.Vigenere decryption");
        System.out.println(ansi().fg(Ansi.Color.RED).a("5.Exit").reset());

        int num = input.nextInt();
        input.nextLine();

        if (num == 1) {
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Print a text to encrypt: ").reset());
            String text = input.nextLine();
            while(!text.matches("[a-zA-Z0-9 !?.,:-]+")) {
                System.out.println(ansi().fg(Ansi.Color.RED).a("Please enter a valid text").reset());
                text = input.nextLine();
            }
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Enter number to move: ").reset());
            int move = input.nextInt();
            input.nextLine();
            String encryptedText =CaesarE(text,move);
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("Encrypted text: "+ encryptedText).reset());
        }


        else if (num == 2) {
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Print a text to decrypt: ").reset());
            String text = input.nextLine();
            while(!text.matches("[a-zA-Z0-9 !?.,:-]+")) {
                System.out.println(ansi().fg(Ansi.Color.RED).a("Please enter a valid text").reset());
                text = input.nextLine();
            }
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Enter number to move: ").reset());
            int move = input.nextInt();
            input.nextLine();
            String decryptedText =CaesarD(text,move);
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("Decrypted text: "+ decryptedText).reset());
        }


        else if (num == 3) {
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Print a text to encrypt: ").reset());
            String text = input.nextLine();
            while(!text.matches("[a-zA-Z0-9 !?.,:-]+")) {
                System.out.println(ansi().fg(Ansi.Color.RED).a("Please enter a valid text").reset());
                text = input.nextLine();
            }
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Enter key word to move: ").reset());
            String keyWord = input.nextLine();
            while(!keyWord.matches("[a-zA-Z ]+")){
                System.out.println(ansi().fg(Ansi.Color.RED).a("Please enter a valid text").reset());
                keyWord = input.nextLine();
            }
            String encryptedText=VigenereE(text,keyWord);
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("Encrypted text: "+encryptedText).reset());
        }


        else if (num == 4) {
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Print a text to decrypt: ").reset());
            String text = input.nextLine();
            while(!text.matches("[a-zA-Z0-9 !?.,:-]+")) {
                System.out.println(ansi().fg(Ansi.Color.RED).a("Please enter a valid text").reset());
                text = input.nextLine();
            }
            System.out.println(ansi().fg(Ansi.Color.YELLOW).a("Enter key word to move: ").reset());
            String keyWord = input.nextLine();
            while(!keyWord.matches("[a-zA-Z ]+")){
                System.out.println(ansi().fg(Ansi.Color.RED).a("Please enter a valid text").reset());
                keyWord = input.nextLine();
            }
            String decryptedText=VigenereD(text,keyWord);
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("Decrypted text: "+decryptedText).reset());
        }else{
            Exit();
        }
    }

    //caesarEncryption
    public static String CaesarE(String textCE, long key) {
        StringBuilder encryptedtext = new StringBuilder();

        for (int i = 0; i < textCE.length(); i++) {
            char c = textCE.charAt(i);
            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                if (isUpperCase) {
                    c = Character.toLowerCase(c);
                }

                c = (char) ((c - 'a' + key + 26) % 26 + 'a');

                if (isUpperCase) {
                    c = Character.toUpperCase(c);
                }
            } else if (Character.isDigit(c)) { // encrypting nums
                c = (char) ((c-'0'+key)%10+'0');
        }
            encryptedtext.append(c);
        }
        return encryptedtext.toString();
    }

    //caesarDecryption
    public static String CaesarD(String textCD, long key) {
        StringBuilder decryptedtext = new StringBuilder();

        for (int i = 0; i < textCD.length(); i++) {
            char c = textCD.charAt(i);
            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                if (isUpperCase) {
                    c = Character.toLowerCase(c);
                }

                c = (char) ((c - 'a' - key + 26) % 26 + 'a');

                if (isUpperCase) {
                    c = Character.toUpperCase(c);
                }
            }else if (Character.isDigit(c)) { //decrypting nums
                c = (char) ((c -'0'- key + 10) % 10 + '0');
            }
            decryptedtext.append(c);
        }
        return decryptedtext.toString();
    }

    //vigenereEncryption
    public static String VigenereE(String textVE, String keyword) {
        StringBuilder encryptedtext = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < textVE.length(); i++) {
            char c = textVE.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                char keyChar = keyword.charAt(keyIndex % keyword.length());
                int shift = Character.toLowerCase(keyChar) - 'a';

                //encrypting letters
                if (Character.isLetter(c)) {
                    boolean isUpperCase = Character.isUpperCase(c);
                    c = Character.toLowerCase(c);
                    c = (char) ((c - 'a' + shift + 26) % 26 + 'a');

                    if (isUpperCase) {
                        c = Character.toUpperCase(c);
                    }
                }
                // encrypting nums
                else if (Character.isDigit(c)) {
                    c = (char) ((c - '0' + shift) % 10 + '0');
                }
                keyIndex++;
            }
            encryptedtext.append(c);
        }
        return encryptedtext.toString();
    }


    //vigenereDecryption
    public static String VigenereD(String textVD, String keyword) {
        StringBuilder decryptedtext = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < textVD.length(); i++) {
            char c = textVD.charAt(i);
            char keyChar = keyword.charAt(keyIndex % keyword.length());
            int shift = Character.toLowerCase(keyChar) - 'a';

            //decrypting letters
            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                c = Character.toLowerCase(c);
                c = (char) ((c - 'a' - shift + 26) % 26 + 'a');

                if (isUpperCase) {
                    c = Character.toUpperCase(c);
                }
                keyIndex++;
            }
            //decrypting nums
            else if (Character.isDigit(c)) {
                int numValue = c - '0';
                numValue = (numValue - shift % 10 + 10) % 10;
                c = (char) (numValue + '0');
                keyIndex++;
            }
            decryptedtext.append(c);

        }
        return decryptedtext.toString();
    }

    //exit
    public static void Exit(){
        System.out.println(ansi().fg(Ansi.Color.RED).a("Exiting...").reset());
    }
}
