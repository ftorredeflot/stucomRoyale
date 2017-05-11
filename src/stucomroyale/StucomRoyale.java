/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyale;

import domain.*;
import java.util.ArrayList;

/**
 *
 * @author ferran
 */
public class StucomRoyale {
    private static ArrayList<Carta> poolCartas = new ArrayList<>();
      private static ArrayList<Player> players = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static void MenuPrincipal() {
        System.out.println("******MENU*******");
        System.out.println("1- Conseguir Cartas");
        System.out.println("2- Batalla");
        System.out.println("3- RANKING");
        System.out.println("4- Salir");
    }

    public static void menubatalla() {
        System.out.println("******STUCOM ROYALE*******");
        System.out.println("1- Añadir carta");
        System.out.println("2- Salir");
    }

    
        public static void initPlay(){
        
        Player p1 = new Player("Javi","1234",0);
        players.add(p1);
        Player p2 = new Player("Jandol","1234",0);
        players.add(p2);
        Player p3 = new Player("topo","1234",0);
        players.add(p3);
        Player p4 = new Player("torrafa","1234",0);
        players.add(p4);
        
   
        
        Tropa tropa1 = new Tropa(20,"tropa1",2,20);
        poolCartas.add(tropa1);
        Tropa tropa2 = new Tropa(30,"tropa2",3,30);
        poolCartas.add(tropa2);
        Tropa tropa3 = new Tropa(40,"tropa3",4,40);
        poolCartas.add(tropa3);
        Tropa tropa4 = new Tropa(50,"tropa4",5,50);
        poolCartas.add(tropa4);
        
        Estructura estructura1 = new Estructura(20,"estructura1",2,20);
        poolCartas.add(estructura1);
        Estructura estructura2 = new Estructura(30,"estructura2",3,30);
        poolCartas.add(estructura2);
        Estructura estructura3 = new Estructura(40,"estructura3",4,40);
        poolCartas.add(estructura3);
        Estructura estructura4 = new Estructura(50,"estructura4",5,50);
        poolCartas.add(estructura4);
        
        Hechizo hechizo1 = new Hechizo(2,"ataque","hechizo1",2,20);
        poolCartas.add(hechizo1);
        Hechizo hechizo2 = new Hechizo(3,"defensa","hechizo2",3,30);
        poolCartas.add(hechizo2);
        Hechizo hechizo3 = new Hechizo(4,"ataque","hechizo3",4,40);
        poolCartas.add(hechizo3);
        Hechizo hechizo4 = new Hechizo(5,"defensa","hechizo4",5,50);
        poolCartas.add(hechizo4);
    }
}
