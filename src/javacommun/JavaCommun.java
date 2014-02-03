/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacommun;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Thomas Ollivier
 */
public class JavaCommun {
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
    }
     
}

