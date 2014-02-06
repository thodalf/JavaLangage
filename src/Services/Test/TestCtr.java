/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Test;

import Services.Controller;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emile
 */
public class TestCtr implements Services.Controller {

    @Override
    public List<String> getPatterns() {
        List<String> mesPattern = new ArrayList<String>();
        mesPattern.add("Premier pattern");
        mesPattern.add("Deuxième pattern");
        
        return mesPattern;
    }

    @Override
    public void start(String demande) {
        
    }   
    
    @Override
    public String toString() {
        return new TestView().toString();
    }
}
