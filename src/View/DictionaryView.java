package View;
import Controller.Validation;
import java.util.Scanner;

public class DictionaryView {
    private Scanner scanner;

    public DictionaryView() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("========= Dictionary program =========");
        System.out.println("||1. Add new word.                  ||");
        System.out.println("||2. Delete word.                   ||");
        System.out.println("||3. Translate.                     ||");
        System.out.println("||4. Exit.                          ||");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
        return Validation.checkInputIntLimit(1, 4);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getEnglishInput() {
        System.out.print("Enter English: ");
        return Validation.checkInputString();
    }

    public String getVietnameseInput() {
        System.out.print("Enter Vietnamese: ");
        return Validation.checkInputString();
    }

    public String getInputForTranslation() {
        System.out.print("Enter English word to translate: ");
        return Validation.checkInputString();
    }
}
