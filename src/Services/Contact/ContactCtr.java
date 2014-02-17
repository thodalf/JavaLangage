/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Contact;

import Services.Controller;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TheNabo1
 */
public class ContactCtr implements Controller {

    private String name;
    private String info;
    private HashMap<Integer,String> patterns; 
    
    
    public ContactCtr(){
        
        this.name = "Contact"; 
        this.info = "Arrête de lire les infos et bosse !";
        
        this.patterns = new HashMap<Integer, String>(); 
        this.patterns.put(1, "heure");
        this.patterns.put(2, "temps");
        this.patterns.put(3, "age");
        
    }
    
    @Override
    public Map< Integer, String> getPatterns() {
      return this.patterns;
    }

    @Override
    public void start(int idDemande) {
        switch(idDemande){
            
            case 1 :
                javax.swing.JOptionPane.showMessageDialog(null, "Il est midi !","Quelle heure est-il ?", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2 :
                javax.swing.JOptionPane.showMessageDialog(null, "Il fait beau !","Quel temps fait-il ?", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3 :
                javax.swing.JOptionPane.showMessageDialog(null, "Tu es vieux !","Quel age ai-je ?", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                break;
            
        }
    }

    @Override
    public String getName() {
        return this.name; 
    }

    @Override
    public String getInfo() {
        return this.info; 
    }
    
}
