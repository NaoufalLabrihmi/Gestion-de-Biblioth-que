package metier;

import java.time.LocalDate;
import utilitaire.DateUtils;

public class Magazine extends Document {
    private int  numero;

    public Magazine(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages,
            int numero) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void afficherDetails() {
    System.out.println("Détails du Magazine :");
    System.out.println("----------------------");
    System.out.println("ID                   : " + getId());
    System.out.println("Titre                : " + getTitre());
    System.out.println("Auteur               : " + getAuteur());
    System.out.println("Date de Publication  : " + DateUtils.formatDate(getDatePublication()));
    System.out.println("Nombre de Pages      : " + getNombreDePages());
    System.out.println("Numéro               : " + numero);
    System.out.println("Emprunté             : " + (isEmprunte() ? "Oui" : "Non"));
    System.out.println("----------------------");
    }


    @Override
    public void emprunter() {
        if (isEmprunte()) {
            System.out.println("Le magazine est déjà emprunté : " + getTitre());
        } else {
            setEmprunte(true);
            System.out.println("Magazine emprunté : " + getTitre());
        }
    }

    @Override
    public void retourner() {
        if (isEmprunte()) {
            setEmprunte(false);
            System.out.println("Magazine retourné : " + getTitre());
        } else {
            System.out.println("Le magazine n'était pas emprunté : " + getTitre());
        }
    }

    // Method to set ID after object creation if needed
    public void setId(String id) {
        super.setId(id);
    }
}
