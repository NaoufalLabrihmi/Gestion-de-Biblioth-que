package presentation;

import java.time.LocalDate;
import java.util.Scanner;
import metier.Bibliotheque;
import metier.Document;
import metier.Livre;
import metier.Magazine;
import utilitaire.DateUtils;

public class ConsoleUI {
    private Bibliotheque bibliotheque;
    private Scanner scanner;

    public ConsoleUI(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix;
        do {
            System.out.println("=== Menu Bibliothèque ===");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Emprunter un document");
            System.out.println("3. Retourner un document");
            System.out.println("4. Afficher tous les documents");
            System.out.println("5. Rechercher un document");
            System.out.println("6. Quitter");
            System.out.print("Veuillez entrer votre choix (1-6) : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    ajouterDocument();
                    break;
                case 2:
                case 3:
                    traiterDocument(choix == 2 ? "emprunter" : "retourner");
                    break;
                case 4:
                    bibliotheque.afficherTousLesDocuments();
                    break;
                case 5:
                    rechercherDocument();
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 6);
    }
    // private void ajouterDocument() {
    //     System.out.print("Entrez le type de document (livre/magazine) : ");
    //     String type = scanner.nextLine().trim();
    //     String titre = demanderInput("titre");
    //     String auteur = demanderInput("auteur");
    //     LocalDate datePublication = demanderDatePublication();
    //     int nombreDePages = demanderNombreDePages();
    //     scanner.nextLine();
    
    //     if ("livre".equalsIgnoreCase(type)) {
    //         String isbn = demanderISBN();
    //         Livre livre = new Livre(null, titre, auteur, datePublication, nombreDePages, isbn);
    //         bibliotheque.ajouterDocument(livre);
    //         System.out.println("Livre ajouté avec ID : " + livre.getId());
    //     } else if ("magazine".equalsIgnoreCase(type)) {
    //         int numero = demanderNumero();
    //         Magazine magazine = new Magazine(null, titre, auteur, datePublication, nombreDePages, numero);
    //         bibliotheque.ajouterDocument(magazine);
    //         System.out.println("Magazine ajouté avec ID : " + magazine.getId());
    //     } else {
    //         System.out.println("Type de document inconnu. Veuillez entrer 'livre' ou 'magazine'.");
    //     }
    // }

    private void ajouterDocument() {
        System.out.println("Entrez le type de document :");
        System.out.println("1. Livre");
        System.out.println("2. Magazine");
        System.out.print("Votre choix (1 ou 2) : ");
        
        int choixType = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        String titre = demanderInput("titre");
        String auteur = demanderInput("auteur");
        LocalDate datePublication = demanderDatePublication();
        int nombreDePages = demanderNombreDePages();
        scanner.nextLine();
    
        if (choixType == 1) { // 1 for Livre
            String isbn = demanderISBN();
            Livre livre = new Livre(null, titre, auteur, datePublication, nombreDePages, isbn);
            bibliotheque.ajouterDocument(livre);
            System.out.println("Livre ajouté avec ID : " + livre.getId());
        } else if (choixType == 2) { // 2 for Magazine
            int numero = demanderNumero();
            Magazine magazine = new Magazine(null, titre, auteur, datePublication, nombreDePages, numero);
            bibliotheque.ajouterDocument(magazine);
            System.out.println("Magazine ajouté avec ID : " + magazine.getId());
        } else {
            System.out.println("Choix invalide. Veuillez entrer 1 pour Livre ou 2 pour Magazine.");
        }
    }
    
    
    private void traiterDocument(String action) {
        System.out.print("Entrez l'ID du document à " + action + " : ");
        String id = scanner.nextLine().trim();
        if ("emprunter".equals(action)) {
            bibliotheque.emprunterDocument(id);
        } else if ("retourner".equals(action)) {
            bibliotheque.retournerDocument(id);
        }
    }
    private int demanderNumero() {
        System.out.print("Entrez le numéro du magazine : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Numéro invalide. Veuillez entrer un nombre entier.");
            scanner.next(); // Clear the invalid input
            System.out.print("Entrez le numéro du magazine : ");
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return numero;
    }

    private void rechercherDocument() {
        System.out.print("Entrez l'ID du document à rechercher : ");
        String id = scanner.nextLine().trim();
        Document document = bibliotheque.rechercherDocument(id);
        if (document != null) {
            document.afficherDetails();
        } else {
            System.out.println("Aucun document trouvé pour l'ID : " + id);
        }
    }

    private String demanderInput(String label) {
        System.out.print("Entrez le " + label + " : ");
        return scanner.nextLine().trim();
    }

    private int demanderNombreDePages() {
        System.out.print("Entrez le nombre de pages : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Nombre de pages invalide. Veuillez entrer un nombre entier.");
            scanner.next(); // Clear the invalid input
            System.out.print("Entrez le nombre de pages : ");
        }
        return scanner.nextInt();
    }

    private LocalDate demanderDatePublication() {
        LocalDate date = null;
        while (date == null) {
            System.out.print("Entrez la date de publication (format: yyyy-MM-dd) : ");
            String dateInput = scanner.nextLine().trim();
            date = DateUtils.parseDate(dateInput); // Use DateUtils to parse the date

            // Validate the parsed date
            if (!DateUtils.isDateValid(date)) {
                System.out.println("Date invalide ou hors de portée. Veuillez réessayer.");
                date = null; // Reset date to prompt again
            }
        }
        return date;
    }

    private String demanderISBN() {
        while (true) {
            System.out.print("Entrez l'ISBN : ");
            String isbn = scanner.nextLine().trim();
    
            String cleanedIsbn = isbn.replaceAll("[-\\s]", "");
    
            // Validate the ISBN
            if (cleanedIsbn.length() == 13 && cleanedIsbn.matches("\\d+")) {
                return cleanedIsbn;
            } else {
                System.out.println("L'ISBN doit comporter 13 chiffres. Veuillez réessayer.");
            }
        }
    }
}
