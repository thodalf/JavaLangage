/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Test;

import Services.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author Emile
 */
public class TestCtr implements Services.Controller {    
    @Override
    public String toString() {
        return new TestView().toString();
    }

    @Override
    public String getName() {
        return "Pluggin de test";
    }

    @Override
    public String getInfo() {
        return "Ce pluggin de test permet de tester si l'application fonctionne correctement.\n Et apparement comme vous lisez ceci au moins on est sur que ça ne plante pas à la compilation";
    }

    @Override
    public Map<Integer, String> getPatterns() {
        Map<Integer, String> patterns = new HashMap();
        
        patterns.put(1, "test");
        
        return patterns;
    }

    @Override
    public JPanel start(int idDemande) {
        return new TestView();
    }
}
