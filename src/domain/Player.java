/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author ferran
 */
public class Player {
    private String usu;
    private String password;
    private int trofeos;
    private ArrayList<Carta> cartas;

    public Player(String usu, String password, int trofeos) {
        this.usu = usu;
        this.password = password;
        this.trofeos = trofeos;
        cartas = new ArrayList<>();
    }
    public Player(){}

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCarta(ArrayList<Carta> carta) {
        cartas = carta;
    }
    
    public void agregarCarta(Carta carta){
        cartas.add(carta);
    }
}
