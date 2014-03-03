/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import javax.swing.JPanel;

/**
 *
 * @author Emile
 */
public class TestMainCtr {
    private static TestMainCtr instance;
    private TestView view;
    private Map<String, String> lieux = new HashMap();   
    
    public static TestMainCtr getInstance() {
        if(instance == null)
            instance = new TestMainCtr();
        return instance;
    }
    
    private TestMainCtr() {
        lieux.put("brian", "in the kitchen");
        lieux.put("toto", "at Paris");
    }
    
    public void initView() {
        view = new TestView();
    }
    
    public JPanel getView() {
        return view;
    }
    
    public void action(int id, Matcher phrase) {
        switch(id) {
            case 1:
                if(lieux.keySet().contains(phrase.group(5))) {
                    view.modifierTexte(phrase.group(5)+" is "+lieux.get(phrase.group(5)));
                } else {
                    view.modifierTexte("Je n'ai pas d'information sur la position de "+phrase.group(5));
                }
                break;
            default:
                //Todo throw erreur : action inconnue
                break;
        }
    }
}
