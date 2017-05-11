/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author ferran
 */
public class Estructura extends Carta {

    private int defensa;

    public Estructura(int defensa, String nom, int coste, int vida) {
        super(nom, coste, vida);
        this.defensa = defensa;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDefensa2() {
        return defensa + 8;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
