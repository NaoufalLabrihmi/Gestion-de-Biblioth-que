package metier;

import java.time.LocalDate;

public abstract class Document {
    private String id;
    private String titre;
    private String auteur;
    private LocalDate datePublication;
    private int nombreDePages;
    private boolean estEmprunte;

    public Document(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.estEmprunte = false; // Default to not borrowed
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public boolean isEmprunte() {
        return estEmprunte;
    }

    protected void setEmprunte(boolean emprunte) {
        this.estEmprunte = emprunte;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public abstract void afficherDetails();

    public abstract void emprunter();

    public abstract void retourner();
}
