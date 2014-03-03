/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import java.util.Map;
import java.util.regex.Matcher;
import javax.swing.JPanel;

/**
 *
 * @author Emile
 */
public interface Controller {
    public Map< Integer , String> getPatterns();
    public JPanel start(int idDemande, Matcher phrase);
    public String getName();
    public String getInfo();
}
