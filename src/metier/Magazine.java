package metier;

import java.time.LocalDate;

public class Magazine extends Document {
    private String numero;

    public Magazine(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages,
            String numero) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine [ID=" + getId() +
                ", Titre=" + getTitre() +
                ", Auteur=" + getAuteur() +
                ", Date de Publication=" + getDatePublication() +
                ", Nombre de Pages=" + getNombreDePages() +
                ", Numéro=" + numero +
                ", Emprunté=" + (isEmprunte() ? "Oui" : "Non") + "]");
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
