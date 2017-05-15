package domain;
import java.util.Objects;
/**
 *
 * @author ferran
 */
public class Carta {
    private String nom;
    private int coste;
    private int vida;

    public Carta() {
    }

    public Carta(String nom, int coste, int vida) {
        this.nom = nom;
        this.coste = coste;
        this.vida = vida;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

        @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nom);
        hash = 61 * hash + this.coste;
        hash = 61 * hash + this.vida;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.coste != other.coste) {
            return false;
        }
        if (this.vida != other.vida) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Carta{" + "nom=" + nom + ", coste=" + coste + ", vida=" + vida + '}';
    }

 

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
