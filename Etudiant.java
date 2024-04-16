import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;

    // Constructeur
    public Etudiant(int id, String nom, String prenom, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    // Méthode pour lire tous les étudiants depuis le fichier texte
    public static List<Etudiant> lireEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String ligne;

        try (BufferedReader reader = new BufferedReader(new FileReader("etudiants.txt"))) {
            while ((ligne = reader.readLine()) != null) {
                String[] infos = ligne.split(",");
                if (infos.length == 4) {
                    int id = Integer.parseInt(infos[0]);
                    String nom = infos[1];
                    String prenom = infos[2];
                    String sexe = infos[3];
                    etudiants.add(new Etudiant(id, nom, prenom, sexe));
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return etudiants;
    }

    // Méthode pour ajouter un étudiant au fichier texte
    public static void ajouterEtudiant(Etudiant etudiant) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("etudiants.txt", true))) {
            writer.write(etudiant.id + "," + etudiant.nom + "," + etudiant.prenom + "," + etudiant.sexe);
            writer.newLine();
            System.out.println("Étudiant ajouté avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

    // Méthode pour supprimer un étudiant du fichier texte
    public static void supprimerEtudiant(int id) {
        List<Etudiant> etudiants = lireEtudiants();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("etudiants.txt"))) {
            for (Etudiant etudiant : etudiants) {
                if (etudiant.getId() != id) {
                    writer.write(etudiant.id + "," + etudiant.nom + "," + etudiant.prenom + "," + etudiant.sexe);
                    writer.newLine();
                }
            }
            System.out.println("Étudiant supprimé avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

    // Méthode pour mettre à jour les informations d'un étudiant
    public static void mettreAJourEtudiant(Etudiant etudiant) {
        List<Etudiant> etudiants = lireEtudiants();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("etudiants.txt"))) {
            for (Etudiant e : etudiants) {
                if (e.getId() == etudiant.getId()) {
                    writer.write(etudiant.id + "," + etudiant.nom + "," + etudiant.prenom + "," + etudiant.sexe);
                } else {
                    writer.write(e.id + "," + e.nom + "," + e.prenom + "," + e.sexe);
                }
                writer.newLine();
            }
            System.out.println("Étudiant mis à jour avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Lire tous les étudiants");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Mettre à jour un étudiant");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Sexe : ");
                    String sexe = scanner.nextLine();

                    Etudiant.ajouterEtudiant(new Etudiant(id, nom, prenom, sexe));
                    break;
                case 2:
                    List<Etudiant> tousLesEtudiants = Etudiant.lireEtudiants();
                    System.out.println("Liste de tous les étudiants :");
                    for (Etudiant etudiant : tousLesEtudiants) {
                        System.out.println("ID: " + etudiant.getId() + ", Nom: " + etudiant.getNom() + ", Prénom: "
                                + etudiant.getPrenom() + ", Sexe: " + etudiant.getSexe());
                    }
                    break;
                case 3:
                    System.out.print("ID de l'étudiant à supprimer : ");
                    int idASupprimer = scanner.nextInt();
                    Etudiant.supprimerEtudiant(idASupprimer);
                    break;
                case 4:
                    System.out.print("ID de l'étudiant à mettre à jour : ");
                    int idAMettreAJour = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer la nouvelle ligne
                    System.out.print("Nouveau Nom : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Nouveau Prénom : ");
                    String nouveauPrenom = scanner.nextLine();
                    System.out.print("Nouveau Sexe : ");
                    String nouveauSexe = scanner.nextLine();

                    Etudiant.mettreAJourEtudiant(new Etudiant(idAMettreAJour, nouveauNom, nouveauPrenom, nouveauSexe));
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        }
    }
}
