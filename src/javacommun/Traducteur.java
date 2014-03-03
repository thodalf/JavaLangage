/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacommun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Thomas
 */
public class Traducteur {
    private Map<Services.Controller, Map<Integer, String>> listMotsCles;

    private static Traducteur instance;
    
    public static Traducteur getInstance(List<Services.Controller> services) {
        if(instance == null)
            instance = new Traducteur(services);
        return instance;
    }
    
    /**
     * Récupère les commandes des pluggins
     * @param services Liste des pluggins
     */
    private Traducteur(List<Services.Controller> services) {
        listMotsCles = new HashMap();
        for(Services.Controller i : services){
            listMotsCles.put(i, i.getPatterns());
        }
    }

    /**
     * Vérifie si une phrase est comprise par un des pluggins puis appel le pluggin associé
     * @param phrase Commande à executer
     */
    public void traduire(String phrase){
        Map<Map<Services.Controller, Integer>, Integer> stat = new HashMap();
        Map<Services.Controller, Integer> max = new HashMap();
        int maxVal = 0;
        boolean find = false;
        
        for(Services.Controller i : listMotsCles.keySet()) {
            for(int id : listMotsCles.get(i).keySet()) {
                Pattern p = Pattern.compile(listMotsCles.get(i).get(id), Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                Matcher m = p.matcher(phrase);
                
                if(m.find()) {
                    find = true;
                    envoyerRequete(i, id, m);
                    break;
                }
            }
        }
        
        if(!find) {
            
        }
    }
    
    /**
     * Envoi les informations nécessaires à l'execution d'un pluggin
     * @param service Pluggin à lancer
     * @param id Identifiant de la commande
     */
    private void envoyerRequete(Services.Controller service, int id, Matcher phrase){
        MainCtr.getInstance().setPanel(service.start(id, phrase));
    }
}
