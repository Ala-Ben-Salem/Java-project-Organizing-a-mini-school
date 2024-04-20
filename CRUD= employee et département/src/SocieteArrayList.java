import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Collections;

public class SocieteArrayList implements IGestion <employes> {

    ArrayList<employes> listemployes= new ArrayList<>();


    //****************************************************************************************
    @Override
    public void ajouterEmploye(employes employes) {
        this.listemployes.add(employes);
    }
    //***************************************************************************************
    @Override
    public boolean rechercherEmploye(String nom) {
        for (employes e:listemployes)
        {
            if(e.getNom().equals(nom))
                return true;
        }
        return false;
    }
    //***************************************************************************************
    @Override
    public boolean rechercherEmploye(employes employes) {
        return this.listemployes.contains(employes);
    }
    //***************************************************************************************
    @Override
    public void supprimerEmploye(employes employes) {
        boolean x= this.listemployes.remove(employes);
        if(x)
            System.out.println("delete success");
        else
            System.out.println("delete wrong");
    }
    //**************************************************************************************
    @Override
    public void displayEmploye() {
        for (employes employes :listemployes)
        {
            System.out.println(employes.toString());
        }
    }
    //***************************************************************************************
    @Override
    public void trierEmployeParId() {
        Collections.sort(listemployes);
    }
    //*****************************************************************************************
    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        Comparator<employes> nomComparator = new Comparator<employes>() {
            @Override
            public int compare(employes o1, employes o2) {
                return o1.getNom_departement().compareTo(o2.getNom_departement());
            }
        };
        Comparator<employes> ageComparator = new Comparator<employes>() {
            @Override
            public int compare(employes o1, employes o2) {
                return o1.getGrade() - o2.getGrade();
            }
        };
        Collections.sort(listemployes, ageComparator.thenComparing(nomComparator));

    }
}
