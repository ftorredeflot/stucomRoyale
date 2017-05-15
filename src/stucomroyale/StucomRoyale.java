/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyale;

import domain.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import tools.*;

/**
 *
 * @author ferran
 */
public class StucomRoyale {

    private static ArrayList<Carta> poolCartas = new ArrayList<>();
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static ArrayList<Jugador> rank = new ArrayList<>();
    private static Map<Integer, Jugador> ranking = new TreeMap<Integer, Jugador>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        int opcion2;
        int vcheck = 0;
        int vcheck2 = 0;
        int guanyador;
        String usua = "";
        String pass = "";
        String usua2 = "";
        String pass2 = "";
        initPlay();

        for (Jugador a : jugadores) {
            System.out.println(a.toString());
            ranking.put(a.getTrofeos(), a);
        }
        do {
            MenuPrincipal();
            opcion = InputData.pedirEntero("Escoge una opción");

            switch (opcion) {
                case 1:
                    usua = InputData.pedirCadena("Introduce tu usuario: ");
                    pass = InputData.pedirCadena("Introduce tu password: ");
                    vcheck = check(vcheck, usua, pass);
                    switch (vcheck) {
                        case 1:
                            System.out.println("El usuario no existe:");
                            break;
                        case 2:
                            System.out.println("Pass Incorrecto");
                            break;
                        default:
                            System.out.println(usua);
                            System.out.println(pass);
                            System.out.println("Usuario correcto");
                            opcion1(usua, pass);
                            break;
                    }
                    break;
                case 2:
                    usua = InputData.pedirCadena("Introduce tu usuario: ");
                    pass = InputData.pedirCadena("Introduce tu password: ");
                    vcheck = check(vcheck, usua, pass);
                    usua2 = InputData.pedirCadena("Introduce tu usuario: ");
                    pass2 = InputData.pedirCadena("Introduce tu password: ");
                    vcheck2 = check2(vcheck, usua, pass);
                    if (vcheck == 0 && vcheck2 == 0) {
                        guanyador = combate(usua, usua2);
                        if (guanyador == 1) {
                            for (Jugador a : jugadores) {
                                if (a.getUsu().equals(usua)) {
                                    a.setTrofeos((a.getTrofeos() + 5));
                                }
                            }
                        }
                        if (guanyador == 1) {
                            for (Jugador a : jugadores) {
                                if (a.getUsu().equals(usua2)) {
                                    a.setTrofeos((a.getTrofeos() + 5));
                                }
                            }
                        }
                    } else {
                        System.out.println("Uno o los dos usuarios no son correctos");
                    }
                    break;
                case 3:
//                    Iterator it = ranking.keySet().iterator();
//                    while(it.hasNext()){
//                        Object key = it.next();
//                        System.out.println("Trofeos: " + key + "Jugador: " + ranking.get(key));
//                    }
                    rank = jugadores;
                    Jugador b = rank.get(0);
                    Jugador c = rank.get(0);
                    do {
                        for (Jugador a : rank) {
                            if (a.getTrofeos() > b.getTrofeos()) {
                                c = a;
                            }
                            b = a;
                        }
                        System.out.println("Trofeos: " + c.getTrofeos() + "->" + c.getUsu()); //hace un bucle infinito
                        rank.remove(c);
                    } while (rank != null);
                    break;
                case 4:
                    System.out.println("Hasta pronto!!");
                    break;
                default:
                    break;
            }

        } while (opcion != 4);
    }

    public static void MenuPrincipal() {
        System.out.println("******MENU*******");
        System.out.println("1- Conseguir Cartas");
        System.out.println("2- Batalla");
        System.out.println("3- RANKING");
        System.out.println("4- Salir");
    }

    public static void menu2() {
        System.out.println("******STUCOM ROYALE*******");
        System.out.println("1- Añadir carta");
        System.out.println("2- Mostrar cartas");
        System.out.println("3- Salir");
    }
    public static void mostrarcartasts(){
    
         for(Carta a : poolCartas){
            System.out.println(a.toString());
        }
    }
     public static void mostrarCartas(){
        for(Carta a : poolCartas){
            mostrarCarta(a);
        }
    }
    public static void mostrarCarta(Carta carta){
        if(carta instanceof Tropa){
            System.out.println("Nombre carta: " + ((Tropa) carta).getNom());
            System.out.println("Coste: " + ((Tropa) carta).getCoste());;
            System.out.println("Vida: " + ((Tropa) carta).getVida());;
            System.out.println("Ataque: " + ((Tropa) carta).getAtaque());     
        }
        if(carta instanceof Estructura){
            System.out.println("Nombre carta: " + ((Estructura) carta).getNom());
            System.out.println("Coste: " + ((Estructura) carta).getCoste());;
            System.out.println("Vida: " + ((Estructura) carta).getVida());;
            System.out.println("Defensa: " + ((Estructura) carta).getDefensa());
        }
        if(carta instanceof Hechizo){
            System.out.println("Nombre carta: " + ((Hechizo) carta).getNom());
            System.out.println("Coste: " + ((Hechizo) carta).getCoste());;
            System.out.println("Vida: " + ((Hechizo) carta).getVida());;
            System.out.println("Rango: " + ((Hechizo) carta).getRango());
            System.out.println("Modo: " + ((Hechizo) carta).getModo());
        }      
    }   

    
    public static void initPlay() {

        Jugador p1 = new Jugador("Javi", "1234", 0);
        jugadores.add(p1);
        Jugador p2 = new Jugador("Jandol", "1234", 0);
        jugadores.add(p2);
        Jugador p3 = new Jugador("topo", "1234", 0);
        jugadores.add(p3);
        Jugador p4 = new Jugador("torrafa", "1234", 0);
        jugadores.add(p4);

        Tropa tropa1 = new Tropa(20, "tropa1", 2, 20);
        poolCartas.add(tropa1);
        Tropa tropa2 = new Tropa(30, "tropa2", 3, 30);
        poolCartas.add(tropa2);
        Tropa tropa3 = new Tropa(40, "tropa3", 4, 40);
        poolCartas.add(tropa3);
        Tropa tropa4 = new Tropa(50, "tropa4", 5, 50);
        poolCartas.add(tropa4);

        Estructura estructura1 = new Estructura(20, "estructura1", 2, 20);
        poolCartas.add(estructura1);
        Estructura estructura2 = new Estructura(30, "estructura2", 3, 30);
        poolCartas.add(estructura2);
        Estructura estructura3 = new Estructura(40, "estructura3", 4, 40);
        poolCartas.add(estructura3);
        Estructura estructura4 = new Estructura(50, "estructura4", 5, 50);
        poolCartas.add(estructura4);

        Hechizo hechizo1 = new Hechizo(2, "ataque", "hechizo1", 2, 20);
        poolCartas.add(hechizo1);
        Hechizo hechizo2 = new Hechizo(3, "defensa", "hechizo2", 3, 30);
        poolCartas.add(hechizo2);
        Hechizo hechizo3 = new Hechizo(4, "ataque", "hechizo3", 4, 40);
        poolCartas.add(hechizo3);
        Hechizo hechizo4 = new Hechizo(5, "defensa", "hechizo4", 5, 50);
        poolCartas.add(hechizo4);
    }
    
     public static int check(int check, String usua, String pass){
        int existe = 0;
        int passok = 0;
                    for(Jugador a : jugadores){
                        if(a.getUsu().equals(usua)){
                            existe = 1;
                            if(a.getPassword().equals(pass)){
                                passok = 1;
                            }
                        }
                    }
                    if(existe == 0){
                        check=1;
                    }
                    else if(existe==1 && passok ==0){
                        check=2;
                    }
        return check;
    }
    public static int check2(int check2, String usua, String pass){
        int existe = 0;
        int passok = 0;
                    for(Jugador a : jugadores){
                        if(a.getUsu().equals(usua)){
                            existe = 1;
                            if(a.getPassword().equals(pass)){
                                passok = 1;
                            }
                        }
                    }
                    if(existe == 0){
                        check2=1;
                    }
                    else if(existe==1 && passok ==0){
                        check2=2;
                    }
        return check2;
    }
    public static void opcion1(String usua, String pass){
        String cartanueva;
        mostrarCartas();
        System.out.println(usua);
        System.out.println(pass);
        //ArrayList<Carta> cartasJugador = new ArrayList<>();
        for(Jugador a : jugadores){
            int cartasn=0; //sirve para contar cuantas cartas tiene al inicio
            if(a.getUsu().equals(usua)){
            for(Carta cartaj : a.getCartas()){
                    cartasn++;
                }   
                int opcion=0;
                do{
                   menu2();
                   opcion=InputData.pedirEntero("Introduce una opcion");
                   switch(opcion){
                        case 1:
                            if(cartasn<6){
                            int checkcarta = 0;
                            cartanueva = InputData.pedirCadena("Introduce el nombre de la carta que quieres añadir");
                            for(Carta cartaa : poolCartas){
                                if(cartaa.getNom().equals(cartanueva)){ //we find it
                                    for(Carta cartaj : a.getCartas()){
                                        if(cartaj.getNom().equals(cartanueva)){ //ya la tiene
                                            checkcarta = 1;
                                        }
                                    }
                                    if(checkcarta == 0){ //no la tiene
                                        a.agregarCarta(cartaa);
                                        cartasn++;
                                        checkcarta = 2;
                                    }
                                }
                            }
                   switch (checkcarta) {
                       case 1:
                           System.out.println("Ya tienes esa carta");
                           break;
                       case 0:
                           System.out.println("La carta no existe");
                           break;
                       case 2:
                           System.out.println("Carta introducida correctamente");
                           break;
                   }
                            }
                            else{
                                System.out.println("Ya has alcanzado el numero mazimo de cartas");
                            }
                            break;
                        case 2:
                            mostrarcartasts();
                            break;
                        case 3:
                            //salir
                            System.out.println("Hasta pronto!!");
                            break;
                        default:
                            break;
                   }
                }while(opcion!=2);
            }
        }
    }
    public static int combate(String usua, String usua2){
        ArrayList<Carta> mazo1 = new ArrayList<>();
        ArrayList<Carta> mazo2 = new ArrayList<>();
        mazo1=crearMazo1(usua);
        mazo2=crearMazo2(usua2);
        int guanyador=0;
        int iteracion=0;
        int vidaPlayer1=0;
        int vidaPlayer2=0;
        int dmg;
        int hp;
        int res;
        int cura;
        for(Carta vida1 : mazo1){
            vidaPlayer1 = vidaPlayer1 + vida1.getVida();
        }
        for(Carta vida2 : mazo1){
            vidaPlayer2 = vidaPlayer2 + vida2.getVida();
        }
        int numero;
        numero = (int) (Math.random() * 2) + 1;
        if(numero==1){
            for(Carta a : mazo1){
                if(a instanceof Tropa){
                    dmg=((Tropa) a).getAtaque2();
                    hp=((Tropa)mazo2.get(iteracion)).getVida();
                    res=hp-dmg;
                    if(res>=0){
                        ((Tropa)mazo2.get(iteracion)).setVida(res);
                    }
                    else{
                        ((Tropa)mazo2.get(iteracion)).setVida(0);
                    }   
                }
                if(a instanceof Estructura){
                    cura=((Estructura) a).getDefensa2();
                    mazo1.get(0).setVida((mazo1.get(0).getVida())+cura);
                    mazo1.get(1).setVida((mazo1.get(0).getVida())+cura);
                    mazo1.get(2).setVida((mazo1.get(0).getVida())+cura);
                }
                if(a instanceof Hechizo){
                    if(((Hechizo) a).getModo().equals("ataque")){
                    dmg=((Hechizo) a).getHechizoAtaque();
                    if(((mazo2.get(0).getVida())-dmg)>=0){
                        mazo2.get(0).setVida((mazo2.get(0).getVida())-dmg);
                    }
                    if(((mazo2.get(0).getVida())-dmg)<0){
                        mazo2.get(0).setVida(0);
                    }
                    if(((mazo2.get(1).getVida())-dmg)>=1){
                        mazo2.get(1).setVida((mazo2.get(1).getVida())-dmg);
                    }
                    if(((mazo2.get(1).getVida())-dmg)<1){
                        mazo2.get(1).setVida(1);
                    }
                    if(((mazo2.get(2).getVida())-dmg)>=2){
                        mazo2.get(2).setVida((mazo2.get(2).getVida())-dmg);
                    }
                    if(((mazo2.get(2).getVida())-dmg)<2){
                        mazo2.get(2).setVida(2);
                    }
                    }
                    if(((Hechizo) a).getModo().equals("defensa")){
                    cura=((Hechizo) a).getHechizoDefensa();
                    mazo1.get(0).setVida((mazo1.get(0).getVida())+cura);
                    mazo1.get(1).setVida((mazo1.get(1).getVida())+cura);
                    mazo1.get(2).setVida((mazo1.get(2).getVida())+cura);
                    }
                }
                iteracion++;
            }
            iteracion=0;
            for(Carta a : mazo1){
                if(a instanceof Tropa){
                    dmg=((Tropa) a).getAtaque2();
                    hp=((Tropa)mazo1.get(iteracion)).getVida();
                    res=hp-dmg;
                    if(res>=0){
                        ((Tropa)mazo1.get(iteracion)).setVida(res);
                    }
                    else{
                        ((Tropa)mazo1.get(iteracion)).setVida(0);
                    }   
                }
                if(a instanceof Estructura){
                    cura=((Estructura) a).getDefensa2();
                    mazo2.get(0).setVida((mazo2.get(0).getVida())+cura);
                    mazo2.get(1).setVida((mazo2.get(0).getVida())+cura);
                    mazo2.get(2).setVida((mazo2.get(0).getVida())+cura);
                }
                if(a instanceof Hechizo){
                    if(((Hechizo) a).getModo().equals("ataque")){
                    dmg=((Hechizo) a).getHechizoAtaque();
                    if(((mazo1.get(0).getVida())-dmg)>=0){
                        mazo1.get(0).setVida((mazo1.get(0).getVida())-dmg);
                    }
                    if(((mazo1.get(0).getVida())-dmg)<0){
                        mazo1.get(0).setVida(0);
                    }
                    if(((mazo1.get(1).getVida())-dmg)>=1){
                        mazo1.get(1).setVida((mazo1.get(1).getVida())-dmg);
                    }
                    if(((mazo1.get(1).getVida())-dmg)<1){
                        mazo1.get(1).setVida(1);
                    }
                    if(((mazo1.get(2).getVida())-dmg)>=2){
                        mazo1.get(2).setVida((mazo1.get(2).getVida())-dmg);
                    }
                    if(((mazo1.get(2).getVida())-dmg)<2){
                        mazo1.get(2).setVida(2);
                    }
                    }
                    if(((Hechizo) a).getModo().equals("defensa")){
                    cura=((Hechizo) a).getHechizoDefensa();
                    mazo2.get(0).setVida((mazo2.get(0).getVida())+cura);
                    mazo2.get(1).setVida((mazo2.get(1).getVida())+cura);
                    mazo2.get(2).setVida((mazo2.get(2).getVida())+cura);
                    }
                }
                iteracion++;
            }
        }
        if(numero==2){
            for(Carta a : mazo1){
                if(a instanceof Tropa){
                    dmg=((Tropa) a).getAtaque2();
                    hp=((Tropa)mazo1.get(iteracion)).getVida();
                    res=hp-dmg;
                    if(res>=0){
                        ((Tropa)mazo1.get(iteracion)).setVida(res);
                    }
                    else{
                        ((Tropa)mazo1.get(iteracion)).setVida(0);
                    }   
                }
                if(a instanceof Estructura){
                    cura=((Estructura) a).getDefensa2();
                    mazo2.get(0).setVida((mazo2.get(0).getVida())+cura);
                    mazo2.get(1).setVida((mazo2.get(0).getVida())+cura);
                    mazo2.get(2).setVida((mazo2.get(0).getVida())+cura);
                }
                if(a instanceof Hechizo){
                    if(((Hechizo) a).getModo().equals("ataque")){
                    dmg=((Hechizo) a).getHechizoAtaque();
                    if(((mazo1.get(0).getVida())-dmg)>=0){
                        mazo1.get(0).setVida((mazo1.get(0).getVida())-dmg);
                    }
                    if(((mazo1.get(0).getVida())-dmg)<0){
                        mazo1.get(0).setVida(0);
                    }
                    if(((mazo1.get(1).getVida())-dmg)>=1){
                        mazo1.get(1).setVida((mazo1.get(1).getVida())-dmg);
                    }
                    if(((mazo1.get(1).getVida())-dmg)<1){
                        mazo1.get(1).setVida(1);
                    }
                    if(((mazo1.get(2).getVida())-dmg)>=2){
                        mazo1.get(2).setVida((mazo1.get(2).getVida())-dmg);
                    }
                    if(((mazo1.get(2).getVida())-dmg)<2){
                        mazo1.get(2).setVida(2);
                    }
                    }
                    if(((Hechizo) a).getModo().equals("defensa")){
                    cura=((Hechizo) a).getHechizoDefensa();
                    mazo2.get(0).setVida((mazo2.get(0).getVida())+cura);
                    mazo2.get(1).setVida((mazo2.get(1).getVida())+cura);
                    mazo2.get(2).setVida((mazo2.get(2).getVida())+cura);
                    }
                }
                iteracion++;
            }
            iteracion =0;
        for(Carta a : mazo1){
                if(a instanceof Tropa){
                    dmg=((Tropa) a).getAtaque2();
                    hp=((Tropa)mazo2.get(iteracion)).getVida();
                    res=hp-dmg;
                    if(res>=0){
                        ((Tropa)mazo2.get(iteracion)).setVida(res);
                    }
                    else{
                        ((Tropa)mazo2.get(iteracion)).setVida(0);
                    }   
                }
                if(a instanceof Estructura){
                    cura=((Estructura) a).getDefensa2();
                    mazo1.get(0).setVida((mazo1.get(0).getVida())+cura);
                    mazo1.get(1).setVida((mazo1.get(0).getVida())+cura);
                    mazo1.get(2).setVida((mazo1.get(0).getVida())+cura);
                }
                if(a instanceof Hechizo){
                    if(((Hechizo) a).getModo().equals("ataque")){
                    dmg=((Hechizo) a).getHechizoAtaque();
                    if(((mazo2.get(0).getVida())-dmg)>=0){
                        mazo2.get(0).setVida((mazo2.get(0).getVida())-dmg);
                    }
                    if(((mazo2.get(0).getVida())-dmg)<0){
                        mazo2.get(0).setVida(0);
                    }
                    if(((mazo2.get(1).getVida())-dmg)>=1){
                        mazo2.get(1).setVida((mazo2.get(1).getVida())-dmg);
                    }
                    if(((mazo2.get(1).getVida())-dmg)<1){
                        mazo2.get(1).setVida(1);
                    }
                    if(((mazo2.get(2).getVida())-dmg)>=2){
                        mazo2.get(2).setVida((mazo2.get(2).getVida())-dmg);
                    }
                    if(((mazo2.get(2).getVida())-dmg)<2){
                        mazo2.get(2).setVida(2);
                    }
                    }
                    if(((Hechizo) a).getModo().equals("defensa")){
                    cura=((Hechizo) a).getHechizoDefensa();
                    mazo1.get(0).setVida((mazo1.get(0).getVida())+cura);
                    mazo1.get(1).setVida((mazo1.get(1).getVida())+cura);
                    mazo1.get(2).setVida((mazo1.get(2).getVida())+cura);
                    }
                }
                iteracion++;
            }
        }
        for(Carta vida1 : mazo1){
            vidaPlayer1 = vidaPlayer1 + vida1.getVida();
        }
        for(Carta vida2 : mazo1){
            vidaPlayer2 = vidaPlayer2 + vida2.getVida();
        }
        if(vidaPlayer1>vidaPlayer2){
            guanyador=1;
        }
        if(vidaPlayer1>vidaPlayer2){
            guanyador=2;
        }
        return guanyador;
    }
        public static ArrayList<Carta> crearMazo1(String usua){
        ArrayList<Carta> mazop1 = new ArrayList<>();
        String carta1;
        int iteracion = 0;
        int ncartas=0;
        int checkcarta=0;
        int elixir=0;
            for(Jugador a : jugadores){
                if(a.getUsu().equals(usua)){
                    do{
                            carta1 = InputData.pedirCadena("Jugador 1 - Introduce el nombre de la carta que quieres añadir a tu mazo");
                            for(Carta cartaa : a.getCartas()){
                                if(cartaa.getNom().equals(carta1)){ 
                                    for(Carta cartaj : a.getCartas()){
                                        if(cartaj.getNom().equals(carta1)){
                                            checkcarta = 1;
                                        }
                                    }
                                    if(checkcarta == 0){ 
                                        if((elixir+(cartaa.getCoste()))<10){
                                        mazop1.add(a.getCartas().get(iteracion));
                                        elixir=elixir+(cartaa.getCoste());
                                        ncartas++;
                                        checkcarta = 2;
                                        }
                                        else{
                                            System.out.println("Con esta carta superas el maximo de elixir");
                                        }
                                    }
                                }
                                iteracion++;
                            }
                   switch (checkcarta) {
                       case 1:
                           System.out.println("Ya tienes esa carta");
                           break;
                       case 0:
                           System.out.println("No tienes/no existe esta carta");
                           break;
                       case 2:
                           System.out.println("Carta introducida correctamente");
                           break;
                   }
                }while(ncartas<3);
                }
            }
        return mazop1;
    }
    public static ArrayList<Carta> crearMazo2(String usua2){
        ArrayList<Carta> mazop2 = new ArrayList<>();
        String carta1;
        int ncartas=0;
        int checkcarta=0;
        int elixir=0;
            for(Jugador a : jugadores){
                if(a.getUsu().equals(usua2)){
                    do{
                            carta1 = InputData.pedirCadena("Jugador 2 - Introduce el nombre de la carta que quieres añadir a tu mazo");
                            for(Carta cartaa : a.getCartas()){
                                if(cartaa.getNom().equals(carta1)){ //we find it
                                    for(Carta cartaj : a.getCartas()){
                                        if(cartaj.getNom().equals(carta1)){ //ya la tiene
                                            checkcarta = 1;
                                        }
                                    }
                                    if(checkcarta == 0){ //no la tiene
                                        if((elixir+(cartaa.getCoste()))<10){
                                        mazop2.add(cartaa);
                                        elixir=elixir+(cartaa.getCoste());
                                        ncartas++;
                                        checkcarta = 2;
                                        }
                                        else{
                                            System.out.println("Con esta carta superas el maximo de elixir");
                                        }
                                    }
                                }
                            }
                   switch (checkcarta) {
                       case 1:
                           System.out.println("Ya tienes esa carta");
                           break;
                       case 0:
                           System.out.println("No tienes/no existe esta carta");
                           break;
                       case 2:
                           System.out.println("Carta introducida correctamente");
                           break;
                   }
                }while(ncartas<3);
                }
            }
        
        return mazop2;
    }
    
}
