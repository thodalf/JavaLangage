/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import java.util.List;

/**
 *
 * @author Emile
 */
public interface Controller {
    public List<String> getPatterns();
    public void start(String demande);
    public String getName();
}
