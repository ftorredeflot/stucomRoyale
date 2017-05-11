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
public class Hechizo extends Carta{
    private int rango;
    private String modo;

    public Hechizo(int rango, String modo, String nom, int coste, int vida) {
        super(nom, coste, vida);
        this.rango = rango;
        this.modo = modo;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
    public int getHechizoAtaque(){
        return (rango*(2/3));
    }
    public int getHechizoDefensa(){
        return (rango*(2/3));
    }
    
    
    
    
}
