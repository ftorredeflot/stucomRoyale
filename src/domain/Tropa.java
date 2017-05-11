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
public class Tropa extends Carta{
    private int ataque;

    public Tropa(int ataque, String nom, int coste, int vida) {
        super(nom, coste, vida);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public int getAtaque2(){
        return (ataque/2);
    }
}
