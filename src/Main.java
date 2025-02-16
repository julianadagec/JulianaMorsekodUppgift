import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Skapar ett objekt av min logiklass Translator för att kunna anropa metoderna därifrån
        Translator translator = new Translator();

        // Tar hjälp av scanner för att sedan kunna läsa in bokstäver och morsekod
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose one of the two options below:");
        System.out.println("Option 1. Translate text to morsecode, only aplhabetical letters are valid");
        System.out.println("Option 2. Translate morsecode to text, separate the morsecode letters with space");

        int option = scanner.nextInt();
        scanner.nextLine();

        // Alternativ 1 väljs, att översätta text till morsekod
        if (option == 1) {
            System.out.println("Write the you want to translate: ");
            String inputText = scanner.nextLine().toUpperCase();
            String morse = translator.getMorseFromLetter(inputText);
            System.out.println("Translation: " + morse);
            // Alternativ 2 väljs, att översätta morsekod till text
        } else if (option == 2) {
            System.out.println("Write a morsecode and separate the letters with space.");
            String inputMorse = scanner.nextLine();
            String text = translator.getLetterFromMorse(inputMorse);
            System.out.println("Translation: " + text);
        } else {
            System.out.println("Invalid choice. Restart program and choose option 1 or 2.");
        }
        scanner.close();
    }
}
