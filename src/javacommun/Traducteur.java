/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacommun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    private Traducteur(List<Services.Controller> services) {
        Map match = new HashMap();
        for(Services.Controller i : services){
            match.put(i, i.getPatterns());
        }
        this.listMotsCles = match;
    }

    public void traduire(String phrase){
        String[] lesMots = phrase.split(" ");
        Map<Map<Services.Controller, Integer>, Integer> stat = new HashMap();
        Map<Services.Controller, Integer> max = new HashMap();
        int maxVal = 0;
        
        for(String mot : lesMots) {
            for(Services.Controller key : listMotsCles.keySet()) {
                Map<Integer, String> currentMotCle = listMotsCles.get(key);
                for(int id : currentMotCle.keySet()) {               
                    if (currentMotCle.get(id).equals(mot)){
                        Map<Services.Controller, Integer> line = new HashMap();
                        line.put(key, id);
                        
                        if(stat.isEmpty())
                            stat.put(line, 1);
                        else
                            if(stat.keySet().toArray()[0].equals(line))
                                stat.put(line, stat.get(line)+1);
                            else
                                stat.put(line, 1);
                        
                        if(stat.get(line) > maxVal) {
                            maxVal = stat.get(line);
                            max = line;
                        }
                    }
                }   
            }
        }
        
        if(!max.isEmpty()) {
            if(max.size() == 1) {       
                Services.Controller service = (Services.Controller)max.keySet().toArray()[0];
                this.envoyerRequete(service, max.get(service));
            }
        }
    }
    
    private void envoyerRequete(Services.Controller service, int id){
        MainCtr.getInstance().setPanel(service.start(id));
    }
}
