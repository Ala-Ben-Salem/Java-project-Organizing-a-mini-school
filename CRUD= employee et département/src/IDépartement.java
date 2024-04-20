import java.util.TreeSet;

public interface IDépartement <T> {
    public void ajouterDepartement(T t);
    public boolean rechercherDepartement(String nom);
    public boolean rechercherDepartement(T t);
    public void supprimerDepartement(T t);
    public void displayDepartement();
    public TreeSet<T> trierDepartementById();

}
