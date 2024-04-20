import java.util.Objects;

public class département implements Comparable <département>{

    int id;
    String nom_département;
    int nombre_employés;

    public département() {
    }

    public département(int id, String nom_département, int nombre_employés) {
        this.id = id;
        this.nom_département = nom_département;
        this.nombre_employés = nombre_employés;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_département() {
        return nom_département;
    }

    public void setNom_département(String nom_département) {
        this.nom_département = nom_département;
    }

    public int getNombre_employés() {
        return nombre_employés;
    }

    public void setNombre_employés(int nombre_employés) {
        this.nombre_employés = nombre_employés;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        département département = (département) o;
        return id == département.id && Objects.equals(nom_département, département.nom_département);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom_département);
    }

    @Override
    public String toString() {
        return "département{" +
                "id=" + id +
                ", nom_département='" + nom_département + '\'' +
                ", nombre_employés=" + nombre_employés +
                '}';
    }

    public int compareTo (département d1) {
        return this.id - d1.id;
    }
}
