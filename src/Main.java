import java.time.LocalDate;
import metier.Bibliotheque;
import metier.Livre;
import metier.Magazine;
import presentation.ConsoleUI;

public class Main {
        public static void main(String[] args) {
                // Create a new Bibliotheque instance
                Bibliotheque bibliotheque = new Bibliotheque();

                // Create sample documents with auto-generated IDs and current date
                Livre livre1 = new Livre("", "Java Programming", "John Doe", LocalDate.now(), 350, "978-3-16-148410-0");
                Livre livre2 = new Livre("", "Advanced Java", "Jane Smith", LocalDate.now(), 450, "978-1-234-56789-7");
                Magazine magazine1 = new Magazine("", "Tech Today", "Various Authors", LocalDate.now(), 60, "2024-08");
                Magazine magazine2 = new Magazine("", "Science Weekly", "Alice Johnson", LocalDate.now(), 45,
                                "2024-09");

                // Add the documents to the library
                bibliotheque.ajouterDocument(livre1);
                bibliotheque.ajouterDocument(livre2);
                bibliotheque.ajouterDocument(magazine1);
                bibliotheque.ajouterDocument(magazine2);

                // Start the ConsoleUI
                ConsoleUI consoleUI = new ConsoleUI(bibliotheque);
                consoleUI.afficherMenu();
        }
}
