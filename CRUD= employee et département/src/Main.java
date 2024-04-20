import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        // Remplir la liste des employés manuellement
        societe.ajouterEmploye(new employes(10, "Doe", "John", "ZFinance", 2));
        societe.ajouterEmploye(new employes(2, "Smith", "Alice", "Ressources Humaines", 2));
        societe.ajouterEmploye(new employes(3, "Brown", "Emma", "Informatique", 4));

        societe.displayEmploye();
        System.out.println("Recherche employé : " + societe.rechercherEmploye("Doe"));
        societe.trierEmployeParId();
        System.out.println("Liste triée par ID :");
        societe.displayEmploye();

        System.out.println(societe.rechercherEmploye("Doke"));
        System.out.println(societe.rechercherEmploye(new employes(3, "Brown", "Emma", "Informatique", 4)));

        societe.supprimerEmploye(new employes(3, "Brown", "Emma", "Informatique", 4));
        societe.displayEmploye();

        societe.trierEmployeParNomDépartementEtGrade();
        System.out.println("Liste triée par salary then par nom :");
        societe.displayEmploye();
       //**********************************************************************


        // Création de quelques départements
        département département1 = new département(1, "Informatique", 50);
        département département2 = new département(2, "Finance", 30);
        département département3 = new département(3, "Ressources Humaines", 20);

        // Création d'une instance de DepartementHashSet
        DepartementHashSet départementHashSet = new DepartementHashSet();

        // Ajout des départements à la HashSet
        départementHashSet.ajouterDepartement(département1);
        départementHashSet.ajouterDepartement(département2);
        départementHashSet.ajouterDepartement(département3);

        // Affichage des départements
        System.out.println("Liste des départements:");
        départementHashSet.displayDepartement();

        // Recherche d'un département par nom
        String nomRecherche = "Informatique";
        System.out.println("\nRecherche du département '" + nomRecherche + "':");
        if (départementHashSet.rechercherDepartement(nomRecherche)) {
            System.out.println("Le département '" + nomRecherche + "' a été trouvé.");
        } else {
            System.out.println("Le département '" + nomRecherche + "' n'a pas été trouvé.");
        }

        // Suppression d'un département
        départementHashSet.supprimerDepartement(département2);

        // Affichage mis à jour des départements
        System.out.println("\nListe des départements après suppression:");
        départementHashSet.displayDepartement();

        // Tri des départements par ID et affichage
        System.out.println("\nListe des départements triés par ID:");
        TreeSet<département> départementsTriés = départementHashSet.trierDepartementById();
        for (département département : départementsTriés) {
            System.out.println(département);
        }


    }

}