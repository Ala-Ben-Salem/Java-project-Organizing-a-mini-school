import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DepartementHashSet implements IDépartement <département>{


    Set<département> hashset=new HashSet<>();
// ****************************************************************************************
    @Override
    public void ajouterDepartement(département département) {
        hashset.add(département);
    }
//****************************************************************************************
    @Override
    public boolean rechercherDepartement(String nom) {
        for (département département : hashset) {
            if (département.getNom_département().equals(nom)) {
                return true;
            }
        }
        return false;
    }
//****************************************************************************************
    @Override
    public boolean rechercherDepartement(département département) {
        return hashset.contains(département);
    }
//****************************************************************************************
    @Override
    public void supprimerDepartement(département département) {
        boolean x=hashset.remove(département);
        if(x)
            System.out.println("delete success");
        else
            System.out.println("delete wrong");
    }
//****************************************************************************************
    @Override
    public void displayDepartement() {
        for (département département : hashset) {
            System.out.println(département);
        }
    }
//****************************************************************************************
    @Override
    public TreeSet<département> trierDepartementById() {
      TreeSet<département> tree=new TreeSet<>(hashset);
        return tree;
    }

}
