package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bibliotheque {
    private List<Document> documents = new ArrayList<>();
    private Map<String, Document> documentMap = new HashMap<>();
    private static int livreCounter = 1;
    private static int magazineCounter = 1;

    public static synchronized String getNextLivreId() {
        return "L-" + (livreCounter++);
    }

    public static synchronized String getNextMagazineId() {
        return "M-" + (magazineCounter++);
    }

    public void ajouterDocument(Document document) {
        // Automatically assign a unique ID based on the document type
        if (document instanceof Livre) {
            String id = getNextLivreId();
            document.setId(id);
            document.setDatePublication(LocalDate.now());
        } else if (document instanceof Magazine) {
            String id = getNextMagazineId();
            document.setId(id);
            document.setDatePublication(LocalDate.now());
        }

        documents.add(document);
        documentMap.put(document.getId(), document);
    }

    public void emprunterDocument(String id) {
        Document document = documentMap.get(id);
        if (document != null) {
            document.emprunter();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    public void retournerDocument(String id) {
        Document document = documentMap.get(id);
        if (document != null) {
            document.retourner();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    public void afficherTousLesDocuments() {
        documents.forEach(Document::afficherDetails);
    }

    public void afficherDocumentsParCondition(Predicate<Document> condition) {
        documents.stream()
                .filter(condition)
                .forEach(Document::afficherDetails);
    }

    public Document rechercherDocument(String critere) {
        if (critere == null || critere.isEmpty()) {
            throw new IllegalArgumentException("Le critère de recherche ne peut pas être null ou vide.");
        }

        Document document = documentMap.get(critere);
        if (document == null) {
            System.out.println("Aucun document trouvé pour le critère : " + critere);
        }
        return document;
    }

    public List<Document> rechercherDocumentsParCondition(Predicate<Document> condition) {
        return documents.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public void afficherDocumentsParDate(LocalDate date) {
        documents.stream()
                .filter(doc -> doc.getDatePublication().isEqual(date))
                .forEach(Document::afficherDetails);
    }
}