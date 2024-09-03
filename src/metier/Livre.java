package metier;

import java.time.LocalDate;
import utilitaire.DateUtils;

public class Livre extends Document {
    private String isbn;

    public Livre(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void afficherDetails() {
    System.out.println("Détails du Livre :");
    System.out.println("----------------------");
    System.out.println("ID                   : " + getId());
    System.out.println("Titre                : " + getTitre());
    System.out.println("Auteur               : " + getAuteur());
    System.out.println("Date de Publication  : " + DateUtils.formatDate(getDatePublication()));
    System.out.println("Nombre de Pages      : " + getNombreDePages());
    System.out.println("ISBN                 : " + (this instanceof Livre ? ((Livre) this).getIsbn() : "N/A"));
    System.out.println("Emprunté             : " + (isEmprunte() ? "Oui" : "Non"));
    System.out.println("----------------------");
    }


    @Override
    public void emprunter() {
        if (isEmprunte()) {
            System.out.println("Le livre est déjà emprunté : " + getTitre());
        } else {
            setEmprunte(true);
            System.out.println("Livre emprunté : " + getTitre());
        }
    }

    @Override
    public void retourner() {
        if (isEmprunte()) {
            setEmprunte(false);
            System.out.println("Livre retourné : " + getTitre());
        } else {
            System.out.println("Le livre n'était pas emprunté : " + getTitre());
        }
    }

    // Method to set ID after object creation if needed
    public void setId(String id) {
        super.setId(id);
    }
}
