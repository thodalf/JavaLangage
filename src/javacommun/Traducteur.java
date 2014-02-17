/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacommun;

import java.util.HashMap;

/**
 *
 * @author Thomas
 */
public class Traducteur {
    private HashMap phraseATraduire;

    public Traducteur(HashMap phraseATraduire) {
        this.phraseATraduire = phraseATraduire;
    }

    public void Traduire(){/*
        Service service = new Service();
        HashMap listeService = service.getAll();
        Set clesListeService = listeService.keySet();
        Iterator iteratorListeService = clesListeService.iterator();
        while (iteratorListeService.hasNext()){
           Object cleListeServices = iteratorListeService.next(); // tu peux typer plus finement ici
           HashMap listeMotsCles = listeService.get(cleListeServices); // tu peux typer plus finement ici
            K cles = listeMotsCles.keySet();
            Iterator it = cles.iterator();
            while (it.hasNext()){
               Object cle = it.next(); // tu peux typer plus finement ici
               String valeurMotCle = listeMotsCles.get(cle); // tu peux typer plus finement ici
               K clefs = this.phraseATraduire.keySet();
                Iterator ite = clefs.iterator();
                while (ite.hasNext()){
                   Object clef = ite.next(); // tu peux typer plus finement ici
                   Object valeurPhrase = this.phraseATraduire.get(clef); // tu peux typer plus finement ici
                   if (valeurMotCle == valeurPhrase){
                       this.EnvoyerRequete((Service) valeurMotCle);
                   }

                }
            }
        }
        return null;*/
    }
    
    public void EnvoyerRequete(/*Service service*/){
        
    }
    
    
}
