/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ieseljust.apac3;

import Model.Jugador;
import Model.Personatge;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gomez
 */
public class APAC3 {
    public static void InsertarJugador(String nom, Integer nivell){
        Session laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        Jugador j=new Jugador();
        
        j.setNom(nom);
        j.setNivell(nivell);
        
        laSessio.persist(j);
        
        System.out.println(j);
        
        if(j.getNivell()==0){
            System.out.println("Nou usuari registrat");
        }
        else{System.out.println("Sesio inciada");}
        
        laSessio.getTransaction().commit();
        laSessio.close();
    }
    
    public static void EliminarJugador(String nom){
        Session laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        
        Query<Jugador> q=laSessio.createQuery("select j from Jugador j where j.nom=?1");
        q.setParameter(1, nom);
        
        Jugador j= q.uniqueResult();
        
        laSessio.delete(j);
        
        System.out.println("Usuari eliminat");
        
        laSessio.getTransaction().commit();
        laSessio.close();
    }
    
    public static void EditarJugador(String nom){
        Session laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        
        Query q=laSessio.createQuery("Update from Jugador a set a.nivell=a.nivell+1 where nom=?1");
        q.setParameter(1, nom);
        int numLinies=q.executeUpdate();
        System.out.println("Linies actualitzades "+numLinies);
        
        laSessio.getTransaction().commit();
        laSessio.close();
    }
    
    public static void MostrarJugadorPerNom(String nom){
        Session laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        
        Query<Jugador> q=laSessio.createQuery("select j from Jugador j where j.nom=?1");
        q.setParameter(1, nom);
        
        List<Jugador> jugadors=q.list();
        
        for (Jugador jugador : jugadors) {
            System.out.println(jugador);
        }
        System.out.println(jugadors.size()+" registres");
        
        laSessio.getTransaction().commit();
        laSessio.close();
        
    }
    
    public static void MostrarJugadors(){
        Session laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.beginTransaction();
        
        Query<Jugador> q=laSessio.createQuery("select j from Jugador j");
        
        List<Jugador> jugadors=q.list();
        
        for (Jugador jugador : jugadors) {
            System.out.println(jugador);
        }
        System.out.println(jugadors.size()+" registres");
        
        laSessio.getTransaction().commit();
        laSessio.close();
        
    }
    
    

    public static void main(String[] args) {
        
        boolean fi=false;
        Scanner sc = new Scanner(System.in);
        while(!fi){
            System.out.println("CRUD de la BBDD Joc");
            System.out.println(""
                    + "1.Insertar jugador\n"
                    + "2.Mostrar jugador\n"
                    + "3.Aumentar 1 nivell al jugador\n"
                    + "4.Eliminar jugador\n"
                    + "5.Eixir"
            );
            System.out.println("Que desitjes fer?");            
            int opcio=sc.nextInt();
            sc.nextLine();
            String nom="";
            Integer nivell=null;
            switch(opcio){
                case 1:
                    while(nom==null || nom.equals("")){
                        System.out.print("Nom: ");
                        nom=sc.nextLine();
                    }
                    while(nivell==null){
                        System.out.print("Nivell: ");
                        nivell=sc.nextInt();
                    }
                    sc.nextLine();
                    InsertarJugador(nom,nivell);
                    break;
                    
                case 2:
                    System.out.println(""
                            + "1. Mostrar tots els jugadors\n"
                            + "2. Buscar jugador per nom"
                    );
                    int qJuga=sc.nextInt();
                    sc.nextLine();
                    if(qJuga==2){
                        while(nom==null || nom.equals("")){
                            System.out.print("Nom: ");
                            nom=sc.nextLine();
                        }
                        MostrarJugadorPerNom(nom);}
                    else{
                        MostrarJugadors();
                    }
                    break;
                
                case 3:
                    while(nom==null || nom.equals("")){
                        System.out.print("Nom: ");
                        nom=sc.nextLine();
                    }
                    EditarJugador(nom);
                    break;
                
                case 4:
                    while(nom==null || nom.equals("")){
                        System.out.print("Nom: ");
                        nom=sc.nextLine();
                    }
                    EliminarJugador(nom);
                    break;
                
                case 5:
                    fi=true;
                    break;
                default:
                    continue;
            }
            String acabar="";
            if(opcio!=5){
            System.out.println("Altra consulta?");
            acabar=sc.nextLine();
            while(!(acabar.equalsIgnoreCase("si") || acabar.equalsIgnoreCase("no"))){
                System.out.println("Resposta no precosable");
                System.out.println("Altra consulta?");
                acabar=sc.nextLine();
            }
            }
            if(acabar.equalsIgnoreCase("si")){
                fi=false;
            }else{
                  fi=true;
            }
        }
    }
}
