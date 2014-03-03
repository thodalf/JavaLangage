/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Contact;

import Services.Controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import javax.swing.JPanel;

/**
 *
 * @author TheNabo1
 */
public class ContactCtr implements Controller {

    private String name;
    private String info;
    private HashMap<Integer,String> patterns; 
    
    
    public ContactCtr() throws IOException{
        Properties properties = new Properties();
        
        FileInputStream input = new FileInputStream("src/Services/Contact/ContactConf.ini");
        try {
            properties.load(input);
        } catch(Exception e) {
            
        } finally {
            input.close();
        }
        
        this.name = properties.getProperty("nom"); 
        this.info = properties.getProperty("info");
        
        this.patterns = new HashMap<Integer, String>(); 
        this.patterns.put(1, properties.getProperty("1"));
        this.patterns.put(2, properties.getProperty("2"));
        this.patterns.put(3, properties.getProperty("3"));
        this.patterns.put(4, properties.getProperty("4"));
        this.patterns.put(5, properties.getProperty("5"));
        this.patterns.put(6, properties.getProperty("6"));
        this.patterns.put(7, properties.getProperty("7"));
        this.patterns.put(8, properties.getProperty("8"));
        this.patterns.put(9, properties.getProperty("9"));
        this.patterns.put(10, properties.getProperty("10"));
        this.patterns.put(11, properties.getProperty("11"));
    }
    
    @Override
    public Map< Integer, String> getPatterns() {
      return this.patterns;
    }

    @Override
    public JPanel start(int idDemande, Matcher phrase){
        ContactMainCtr controller = ContactMainCtr.getInstance();
        controller.initView();
        controller.action(idDemande, phrase);
        
        return controller.getView();
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
