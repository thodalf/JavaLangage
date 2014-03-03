/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import javax.swing.JPanel;

/**
 *
 * @author Emile
 */
public class ContactMainCtr {
    private static ContactMainCtr instance;
    private ContactView view;
    
    public static ContactMainCtr getInstance() {
        if(instance == null)
            instance = new ContactMainCtr();
        return instance;
    }
    
    private ContactMainCtr(){}
    
    public void initView() {
        view = new ContactView();
    }
    
    public JPanel getView() {
        return view;
    }
    
    public void action(int id, Matcher phrase) {
        switch(id) {
            case 1:
                
                break;
            case 2:
                view.modifierTexte(phrase.toString());
                break;
            case 3:
                view.modifierTexte(phrase.toString());
                break;
            case 4:
                view.modifierTexte(phrase.toString());
                break;
            case 5:
                view.modifierTexte(phrase.toString());
                break;
            case 6:
                view.modifierTexte(phrase.toString());
                break;
            case 7:
                view.modifierTexte(phrase.toString());
                break;
            case 8:
                view.modifierTexte(phrase.toString());
                break;
            case 9:
                view.modifierTexte(phrase.toString());
                break;
            case 11:
                view.modifierTexte(phrase.toString());
                break;
            default:
                view.modifierTexte("Bug");
                break;
        }
    }
}
