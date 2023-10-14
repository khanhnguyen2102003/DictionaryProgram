package Controller;

import Model.Dictionary;
import View.DictionaryView;

public class Manager {
    private Dictionary model;
    private DictionaryView view;

    public Manager() {
        model = new Dictionary();
        view = new DictionaryView();
    }

    public void run() {
        while (true) {
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    addNewWord();
                    break;
                case 2:
                    deleteWord();
                    break;
                case 3:
                    translate();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void addNewWord() {
        view.displayMessage("========= ADD NEW WORD =========");
        String english = view.getEnglishInput();
        if (model.wordExists(english)) {
            view.displayMessage("Word already exists. Do you want to replace (Y/N)?");
            if (view.getInputForTranslation().equalsIgnoreCase("Y")) {
                String vietnamese = view.getVietnameseInput();
                model.addWord(english, vietnamese);
                view.displayMessage("Add successful.");
            }
        } else {
            String vietnamese = view.getVietnameseInput();
            model.addWord(english, vietnamese);
            view.displayMessage("Add successful.");
        }
    }

    private void deleteWord() {
        view.displayMessage("========= DELETE WORD =========");
        String english = view.getEnglishInput();
        if (model.wordExists(english)) {
            model.deleteWord(english);
            view.displayMessage("Delete successful.");
        } else {
            view.displayMessage("Word not found.");
        }
    }

    private void translate() {
        view.displayMessage("========= TRANSLATE =========");
        String english = view.getInputForTranslation();
        String translation = model.translateWord(english);
        if (translation != null) {
            view.displayMessage("Vietnamese: " + translation);
        } else {
            view.displayMessage("Not found in data.");
        }
    }

    public static void main(String[] args) {
        Manager controller = new Manager();
        controller.run();
    }
}
