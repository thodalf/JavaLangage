/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacommun;

import Loader.Loader;
import Services.Controller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Emile
 */
public class MainCtr {
    private static MainCtr instance;
    private List<Services.Controller> lesPluggins = new ArrayList();
    private MainFrame view;
    
    public static MainCtr getInstance() {
        if(instance == null)
            instance = new MainCtr();
        
        return instance;
    }
    
    private MainCtr(){}
    
    public void init() {
        this.loadPluggins();
        
        List<String> nomsPluggins = new ArrayList();
        for(Services.Controller pluggin : lesPluggins)
            nomsPluggins.add(pluggin.getName());
        
        view = new MainFrame(nomsPluggins);
        view.setVisible(true);
    }
    
    /**
     * Charge les pluggins
     * @return Liste des controllers de chaque pluggin non instancié
     */
    private void loadPluggins() {      
        Loader loader = Loader.getInstance();

        List<String> lesFichiers = loader.findClassInPackage(Controller.class.getPackage().getName(), "Ctr");
        
        for(String s : lesFichiers) {
            Class c = loader.loadClass(s);
            if(!c.isInterface())
                try{
                    Services.Controller unPluggin = (Services.Controller)c.newInstance();
                    lesPluggins.add(unPluggin);
                } catch(Exception e) {

                }
        }
    }
    
    public void plugginGetInfo(int index) {
        Services.Controller unPluggin = (Services.Controller)lesPluggins.get(index);
        view.afficherMsgBoxInfo(unPluggin.getInfo(), "Information - "+unPluggin.getName(), MainFrame.typeMsgBox.INFO);
    }
    
    public void rechercher(String recherche) {
        if (recherche.isEmpty())
            view.afficherMsgBoxInfo("Vous devez saisir une demande", "Erreur - Champ vide", MainFrame.typeMsgBox.ERREUR);
        else {
            Traducteur.getInstance(lesPluggins).traduire(recherche);
        }
    }
    
    public void setPanel(JPanel panel) {
        view.setPanel(panel);
    }
}
