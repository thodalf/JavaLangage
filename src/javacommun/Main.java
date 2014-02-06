/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacommun;

import Loader.Loader;
import Services.Controller;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Thomas Ollivier
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fenetre = new JFrame();
        JPanel pan = new JPanel();
        JPanel panButton = new JPanel();
        
        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Langage naturel");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(400, 100);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible        
        fenetre.setVisible(true);
        JTextField zoneTexte = new JTextField(20);
        JButton bouton = new JButton("Envoyer");
        panButton.setPreferredSize(new Dimension(400, 100));
        //zoneTexte.setSize(200, 50);
        //bouton.setSize(200, 50);
        Container c = fenetre.getContentPane();
        c.add(panButton);
        panButton.add(zoneTexte);
        panButton.add(bouton);
        //c.add(bouton);
        
        //Stockage des pluggins ainsi que leurs mots clef
        Map<Object, List<String>> lesPluggins = new HashMap();
        for(Class plugginClass : loadPluggins()) {
            Services.Controller unPluggin = null;
            try{
                unPluggin = (Services.Controller)plugginClass.newInstance();
                lesPluggins.put(unPluggin, unPluggin.getPatterns());
            } catch(Exception e) {
                
            }
        }        
    }
     
    /**
     * Charge les pluggins
     * @return Liste des controllers de chaque pluggin non instancié
     */
    public static List<Class> loadPluggins() {
        List<Class> lesClass = new ArrayList();
        
        Loader loader = Loader.getInstance();

        List<String> lesFichiers = loader.findClassInPackage(Controller.class.getPackage().getName(), "Ctr");
        
        for(String s : lesFichiers) {
            Class c = loader.loadClass(s);
            if(!c.isInterface())
                lesClass.add(c);
        }
        
        return lesClass;
    }
}

