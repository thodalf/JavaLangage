/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacommun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Thomas
 */
public class Traducteur {
    private Map listMotsCles;

    public Traducteur(List<Service> services) {
        Map match = new HashMap();
        for(Service i : services){
            match.put(i, i.getMotCle());
        }
        this.listMotsCles = match;
    }

    public List Traduire(String phrase){
        String[] listMots = phrase.split(" ");
        List servicesMatch = new ArrayList();
        Iterator iteratorlistMotsCles = listMotsCles.iterator();
        while (iteratorlistMotsCles.hasNext()){
            HashMap currentMotCle = (HashMap)iteratorlistMotsCles.next();
            for (int i = 0; listMots.length <= i; i++){
                if (listMots[i] == currentMotCle.getValue().getMotCle()){
                    servicesMatch.add(currentMotCle);
                }
            }
        }
        this.EnvoyerRequete(servicesMatch);
        return servicesMatch;
    }
    
    public void EnvoyerRequete(List service){
        Iterator it = service.iterator();
        for (it.hasNext()){
              HashMap map = (HashMap) it.next();
              map.getKey().comprendre(map.getValue().getKey());
        }
    }
    
    
}
