import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class employes implements Comparable <employes> {
    int identifian;
    String nom;
    String prenom;
    String nom_departement;
    int grade;

    public employes(int identifian, String nom, String prenom, String nom_departement, int grade) {
        this.identifian = identifian;
        this.nom = nom;
        this.prenom = prenom;
        this.nom_departement = nom_departement;
        this.grade = grade;
    }

    public employes(){
    }

    public int getIdentifian() {
        return identifian;
    }

    public void setIdentifian(int identifian) {
        this.identifian = identifian;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom_departement() {
        return nom_departement;
    }

    public void setNom_departement(String nom_departement) {
        this.nom_departement = nom_departement;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employes employes = (employes) o;
        return identifian == employes.identifian && Objects.equals(nom, employes.nom);
    }

    @Override
    public String toString() {
        return "employes{" +
                "identifian=" + identifian +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom_departement='" + nom_departement + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int compareTo (employes e1) {
        return this.identifian-e1.identifian;
    }

}
