package sample;

public class Student {
    private String Nom;
    private String Prenom;
    private int anneeDeNaissance;
    private Promotion promo;
    private Option option;

    public Student(String nom, String prenom, int anneeDeNaissance, Promotion promo, Option option) {
        Nom = nom;
        Prenom = prenom;
        this.anneeDeNaissance = anneeDeNaissance;
        this.promo = promo;
        this.option = option;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getAnneeDeNaissance() {
        return anneeDeNaissance;
    }

    public void setAnneeDeNaissance(int anneeDeNaissance) {
        this.anneeDeNaissance = anneeDeNaissance;
    }

    public Promotion getPromo() {
        return promo;
    }

    public void setPromo(Promotion promo) {
        this.promo = promo;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
